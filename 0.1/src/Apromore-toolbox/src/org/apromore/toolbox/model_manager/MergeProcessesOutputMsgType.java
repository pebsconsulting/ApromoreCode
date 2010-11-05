
package org.apromore.toolbox.model_manager;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.cxf.jaxb.JAXBToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;


/**
 * <p>Java class for MergeProcessesOutputMsgType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MergeProcessesOutputMsgType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Result" type="{http://www.apromore.org/toolbox/model_manager}ResultType"/>
 *         &lt;element name="ProcessSummary" type="{http://www.apromore.org/toolbox/model_manager}ProcessSummaryType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MergeProcessesOutputMsgType", propOrder = {
    "result",
    "processSummary"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2010-11-05T05:56:23+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
public class MergeProcessesOutputMsgType {

    @XmlElement(name = "Result", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2010-11-05T05:56:23+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected ResultType result;
    @XmlElement(name = "ProcessSummary")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2010-11-05T05:56:23+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected ProcessSummaryType processSummary;

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link ResultType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2010-11-05T05:56:23+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public ResultType getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2010-11-05T05:56:23+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setResult(ResultType value) {
        this.result = value;
    }

    /**
     * Gets the value of the processSummary property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessSummaryType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2010-11-05T05:56:23+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public ProcessSummaryType getProcessSummary() {
        return processSummary;
    }

    /**
     * Sets the value of the processSummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessSummaryType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2010-11-05T05:56:23+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setProcessSummary(ProcessSummaryType value) {
        this.processSummary = value;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2010-11-05T05:56:23+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String toString() {
        return JAXBToStringBuilder.valueOf(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
