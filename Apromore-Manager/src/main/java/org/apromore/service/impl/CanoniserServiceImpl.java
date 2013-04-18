package org.apromore.service.impl;

import org.apromore.anf.ANFSchema;
import org.apromore.anf.AnnotationsType;
import org.apromore.canoniser.Canoniser;
import org.apromore.canoniser.exception.CanoniserException;
import org.apromore.canoniser.provider.CanoniserProvider;
import org.apromore.cpf.CPFSchema;
import org.apromore.cpf.CanonicalProcessType;
import org.apromore.plugin.PluginRequestImpl;
import org.apromore.plugin.PluginResult;
import org.apromore.plugin.exception.PluginException;
import org.apromore.plugin.exception.PluginNotFoundException;
import org.apromore.plugin.property.RequestParameterType;
import org.apromore.service.CanoniserService;
import org.apromore.service.model.CanonisedProcess;
import org.apromore.service.model.DecanonisedProcess;
import org.apromore.util.StreamUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.xml.bind.JAXBException;

/**
 * Implementation of the Canoniser Service Contract.
 *
 * @author <a href="mailto:cam.james@gmail.com">Cameron James</a>
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true, rollbackFor = Exception.class)
public class CanoniserServiceImpl implements CanoniserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CanoniserServiceImpl.class);

    private CanoniserProvider canProvider;

    /**
     * Default Constructor allowing Spring to Autowire for testing and normal use.
     * @param canoniserProvider Canoniser Provider.
     */
    @Inject
    public CanoniserServiceImpl(final @Qualifier("canoniserProvider") CanoniserProvider canoniserProvider) {
        canProvider = canoniserProvider;
    }


    /* (non-Javadoc)
     * @see org.apromore.service.CanoniserService#findByNativeType(java.lang.String)
     */
    @Override
    public Set<Canoniser> listByNativeType(final String nativeType) {
        return canProvider.listByNativeType(nativeType);
    }
    
    /* (non-Javadoc)
     * @see org.apromore.service.CanoniserService#findByNativeType(java.lang.String)
     */
    @Override
    public Canoniser findByNativeType(String nativeType) throws PluginNotFoundException {
        return canProvider.findByNativeType(nativeType);
    }

    /* (non-Javadoc)
     * @see org.apromore.service.CanoniserService#findByNativeTypeAndNameAndVersion(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public Canoniser findByNativeTypeAndNameAndVersion(String nativeType, String name, String version) throws PluginNotFoundException {
        return canProvider.findByNativeTypeAndNameAndVersion(nativeType, name, version);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.apromore.service.CanoniserService#canonise(java.lang.String, java.io.InputStream, java.util.Set)
     */
    @Override
    public CanonisedProcess canonise(final String nativeType, final InputStream processXml, final Set<RequestParameterType<?>> canoniserProperties)
            throws CanoniserException {
        LOGGER.info("Canonising process with native type {}", nativeType);
        LOGGER.info(StreamUtil.convertStreamToString(processXml));

        List<CanonicalProcessType> cpfList = new ArrayList<>();
        List<AnnotationsType> anfList = new ArrayList<>();
        CanonisedProcess cp = new CanonisedProcess();

        cp.setOriginal(processXml);

        try {
            processXml.reset();
            cp.setOriginal(processXml);
            Canoniser c = canProvider.findByNativeType(nativeType);
            PluginRequestImpl canoniserRequest = new PluginRequestImpl();
            canoniserRequest.addRequestProperty(canoniserProperties);
            PluginResult canoniserResult = c.canonise(processXml, anfList, cpfList, canoniserRequest);
            cp.setMessages(canoniserResult.getPluginMessage());
        } catch (IOException | CanoniserException | PluginNotFoundException e) {
            throw new CanoniserException("Could not canonise " + nativeType, e);
        }

        ByteArrayOutputStream anfXml = new ByteArrayOutputStream();
        ByteArrayOutputStream cpfXml = new ByteArrayOutputStream();

        if (cpfList.size() > 1 || anfList.size() > 1) {
            throw new CanoniserException("Canonising to multiple CPF, ANF files is not yet supported!");
        } else {
            try {
                ANFSchema.marshalAnnotationFormat(anfXml, anfList.get(0), false);
                cp.setAnf(new ByteArrayInputStream(anfXml.toByteArray()));
                cp.setAnt(anfList.get(0));

                CPFSchema.marshalCanonicalFormat(cpfXml, cpfList.get(0), false);
                cp.setCpf(new ByteArrayInputStream(cpfXml.toByteArray()));
                cp.setCpt(cpfList.get(0));

            } catch (JAXBException | SAXException e) {
                throw new CanoniserException("Error trying to marshal ANF or CPF. This is probably an internal error in a Canoniser.", e);
            }
        }

        return cp;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.apromore.service.CanoniserService#deCanonise(java.lang.Integer, java.lang.String, java.lang.String,
     * org.apromore.cpf.CanonicalProcessType, javax.activation.DataSource, java.util.Set)
     */
    @Override
    public DecanonisedProcess deCanonise(final Integer processId, final String version, final String nativeType,
            final CanonicalProcessType canonicalFormat, final AnnotationsType annotationFormat,
            final Set<RequestParameterType<?>> canoniserProperties) throws CanoniserException {

        LOGGER.info("DeCanonising process with native type {}", nativeType);

        ByteArrayOutputStream nativeXml = new ByteArrayOutputStream();
        DecanonisedProcess decanonisedProces = new DecanonisedProcess();

        try {
            Canoniser c = canProvider.findByNativeType(nativeType);
            PluginRequestImpl canoniserRequest = new PluginRequestImpl();
            canoniserRequest.addRequestProperty(canoniserProperties);            
            PluginResult pluginResult = c.deCanonise(canonicalFormat, annotationFormat, nativeXml, canoniserRequest);
            InputStream nativeXmlIs = new ByteArrayInputStream(nativeXml.toByteArray());
            decanonisedProces.setNativeFormat(nativeXmlIs);
            decanonisedProces.setMessages(pluginResult.getPluginMessage());
            return decanonisedProces;
        } catch (PluginException e) {
            throw new CanoniserException("Could not deCanonise " + nativeType, e);
        }

    }

    // TODO all the following methods do not really belong here

    /**
     * @see org.apromore.service.CanoniserService#CPFtoString(org.apromore.cpf.CanonicalProcessType) {@inheritDoc}
     */
    @Override
    public String CPFtoString(final CanonicalProcessType cpt) throws JAXBException {
        ByteArrayOutputStream xml = new ByteArrayOutputStream();
        try {
            CPFSchema.marshalCanonicalFormat(xml, cpt, false);
        } catch (SAXException e) {
            throw new JAXBException(e);
        }
        return StreamUtil.convertStreamToString(new ByteArrayInputStream(xml.toByteArray()));
    }

}
