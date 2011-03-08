
/*
 * 
 */

package org.apromore.canoniser.da;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.2.9
 * Sun Dec 05 10:42:29 CET 2010
 * Generated source version: 2.2.9
 * 
 */


@WebServiceClient(name = "DACanoniserService", 
                  wsdlLocation = "http://localhost:8080/Apromore-dataAccess/services/DACanoniser?wsdl",
                  targetNamespace = "http://www.apromore.org/data_access/service_canoniser") 
public class DACanoniserService extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://www.apromore.org/data_access/service_canoniser", "DACanoniserService");
    public final static QName DACanoniser = new QName("http://www.apromore.org/data_access/service_canoniser", "DACanoniser");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/Apromore-dataAccess/services/DACanoniser?wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from http://localhost:8080/Apromore-dataAccess/services/DACanoniser?wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public DACanoniserService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public DACanoniserService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DACanoniserService() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     * 
     * @return
     *     returns DACanoniserPortType
     */
    @WebEndpoint(name = "DACanoniser")
    public DACanoniserPortType getDACanoniser() {
        return super.getPort(DACanoniser, DACanoniserPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DACanoniserPortType
     */
    @WebEndpoint(name = "DACanoniser")
    public DACanoniserPortType getDACanoniser(WebServiceFeature... features) {
        return super.getPort(DACanoniser, DACanoniserPortType.class, features);
    }

}