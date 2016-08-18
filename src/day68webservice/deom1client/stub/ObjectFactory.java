
package day68webservice.deom1client.stub;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the day68webservice.deom1client.stub package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetJobResponse_QNAME = new QName("http://demo1service.day68webservice/", "getJobResponse");
    private final static QName _GetJob_QNAME = new QName("http://demo1service.day68webservice/", "getJob");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: day68webservice.deom1client.stub
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetJobResponse }
     * 
     */
    public GetJobResponse createGetJobResponse() {
        return new GetJobResponse();
    }

    /**
     * Create an instance of {@link GetJob }
     * 
     */
    public GetJob createGetJob() {
        return new GetJob();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetJobResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://demo1service.day68webservice/", name = "getJobResponse")
    public JAXBElement<GetJobResponse> createGetJobResponse(GetJobResponse value) {
        return new JAXBElement<GetJobResponse>(_GetJobResponse_QNAME, GetJobResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetJob }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://demo1service.day68webservice/", name = "getJob")
    public JAXBElement<GetJob> createGetJob(GetJob value) {
        return new JAXBElement<GetJob>(_GetJob_QNAME, GetJob.class, null, value);
    }

}
