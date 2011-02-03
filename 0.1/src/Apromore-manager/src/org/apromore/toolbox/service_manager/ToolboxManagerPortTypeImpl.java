
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package org.apromore.toolbox.service_manager;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.2.9
 * Mon Jan 31 19:11:42 CET 2011
 * Generated source version: 2.2.9
 * 
 */

@javax.jws.WebService(
                      serviceName = "ToolboxManagerService",
                      portName = "ToolboxManager",
                      targetNamespace = "http://www.apromore.org/toolbox/service_manager",
                      wsdlLocation = "http://localhost:8080/Apromore-toolbox/services/ToolboxManager?wsdl",
                      endpointInterface = "org.apromore.toolbox.service_manager.ToolboxManagerPortType")
                      
public class ToolboxManagerPortTypeImpl implements ToolboxManagerPortType {

    private static final Logger LOG = Logger.getLogger(ToolboxManagerPortTypeImpl.class.getName());

    /* (non-Javadoc)
     * @see org.apromore.toolbox.service_manager.ToolboxManagerPortType#searchForSimilarProcesses(org.apromore.toolbox.model_manager.SearchForSimilarProcessesInputMsgType  payload )*
     */
    public org.apromore.toolbox.model_manager.SearchForSimilarProcessesOutputMsgType searchForSimilarProcesses(org.apromore.toolbox.model_manager.SearchForSimilarProcessesInputMsgType payload) { 
        LOG.info("Executing operation searchForSimilarProcesses");
        System.out.println(payload);
        try {
            org.apromore.toolbox.model_manager.SearchForSimilarProcessesOutputMsgType _return = new org.apromore.toolbox.model_manager.SearchForSimilarProcessesOutputMsgType();
            org.apromore.toolbox.model_manager.ResultType _returnResult = new org.apromore.toolbox.model_manager.ResultType();
            _returnResult.setMessage("Message-1636093441");
            _returnResult.setCode(Integer.valueOf(1837116972));
            _return.setResult(_returnResult);
            org.apromore.toolbox.model_manager.ProcessSummariesType _returnProcessSummaries = new org.apromore.toolbox.model_manager.ProcessSummariesType();
            java.util.List<org.apromore.toolbox.model_manager.ProcessSummaryType> _returnProcessSummariesProcessSummary = new java.util.ArrayList<org.apromore.toolbox.model_manager.ProcessSummaryType>();
            org.apromore.toolbox.model_manager.ProcessSummaryType _returnProcessSummariesProcessSummaryVal1 = new org.apromore.toolbox.model_manager.ProcessSummaryType();
            java.util.List<org.apromore.toolbox.model_manager.VersionSummaryType> _returnProcessSummariesProcessSummaryVal1VersionSummaries = new java.util.ArrayList<org.apromore.toolbox.model_manager.VersionSummaryType>();
            _returnProcessSummariesProcessSummaryVal1.getVersionSummaries().addAll(_returnProcessSummariesProcessSummaryVal1VersionSummaries);
            _returnProcessSummariesProcessSummaryVal1.setOriginalNativeType("OriginalNativeType1549076528");
            _returnProcessSummariesProcessSummaryVal1.setName("Name1770056221");
            _returnProcessSummariesProcessSummaryVal1.setId(Integer.valueOf(-243976300));
            _returnProcessSummariesProcessSummaryVal1.setDomain("Domain1567655090");
            _returnProcessSummariesProcessSummaryVal1.setRanking("Ranking-484513957");
            _returnProcessSummariesProcessSummaryVal1.setLastVersion("LastVersion-1403273938");
            _returnProcessSummariesProcessSummaryVal1.setOwner("Owner-1290898857");
            _returnProcessSummariesProcessSummary.add(_returnProcessSummariesProcessSummaryVal1);
            _returnProcessSummaries.getProcessSummary().addAll(_returnProcessSummariesProcessSummary);
            _return.setProcessSummaries(_returnProcessSummaries);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.apromore.toolbox.service_manager.ToolboxManagerPortType#mergeProcesses(org.apromore.toolbox.model_manager.MergeProcessesInputMsgType  payload )*
     */
    public org.apromore.toolbox.model_manager.MergeProcessesOutputMsgType mergeProcesses(org.apromore.toolbox.model_manager.MergeProcessesInputMsgType payload) { 
        LOG.info("Executing operation mergeProcesses");
        System.out.println(payload);
        try {
            org.apromore.toolbox.model_manager.MergeProcessesOutputMsgType _return = new org.apromore.toolbox.model_manager.MergeProcessesOutputMsgType();
            org.apromore.toolbox.model_manager.ResultType _returnResult = new org.apromore.toolbox.model_manager.ResultType();
            _returnResult.setMessage("Message2109367508");
            _returnResult.setCode(Integer.valueOf(938490075));
            _return.setResult(_returnResult);
            org.apromore.toolbox.model_manager.ProcessSummaryType _returnProcessSummary = new org.apromore.toolbox.model_manager.ProcessSummaryType();
            java.util.List<org.apromore.toolbox.model_manager.VersionSummaryType> _returnProcessSummaryVersionSummaries = new java.util.ArrayList<org.apromore.toolbox.model_manager.VersionSummaryType>();
            org.apromore.toolbox.model_manager.VersionSummaryType _returnProcessSummaryVersionSummariesVal1 = new org.apromore.toolbox.model_manager.VersionSummaryType();
            java.util.List<org.apromore.toolbox.model_manager.AnnotationsType> _returnProcessSummaryVersionSummariesVal1Annotations = new java.util.ArrayList<org.apromore.toolbox.model_manager.AnnotationsType>();
            _returnProcessSummaryVersionSummariesVal1.getAnnotations().addAll(_returnProcessSummaryVersionSummariesVal1Annotations);
            _returnProcessSummaryVersionSummariesVal1.setRanking("Ranking-1905652924");
            _returnProcessSummaryVersionSummariesVal1.setName("Name789281826");
            _returnProcessSummaryVersionSummariesVal1.setLastUpdate("LastUpdate-1102668590");
            _returnProcessSummaryVersionSummariesVal1.setCreationDate("CreationDate-1861998187");
            _returnProcessSummaryVersionSummariesVal1.setScore(Double.valueOf(0.5112074108192589));
            _returnProcessSummaryVersionSummaries.add(_returnProcessSummaryVersionSummariesVal1);
            _returnProcessSummary.getVersionSummaries().addAll(_returnProcessSummaryVersionSummaries);
            _returnProcessSummary.setOriginalNativeType("OriginalNativeType1025942773");
            _returnProcessSummary.setName("Name-553778649");
            _returnProcessSummary.setId(Integer.valueOf(-181031975));
            _returnProcessSummary.setDomain("Domain2029059651");
            _returnProcessSummary.setRanking("Ranking-1445055845");
            _returnProcessSummary.setLastVersion("LastVersion466665076");
            _returnProcessSummary.setOwner("Owner430062815");
            _return.setProcessSummary(_returnProcessSummary);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}