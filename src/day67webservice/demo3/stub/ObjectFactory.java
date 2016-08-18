
package day67webservice.demo3.stub;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the day67webservice.demo3.stub package. 
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

    private final static QName _GetPersonAll_QNAME = new QName("http://demo3.day67webservice/", "getPersonAll");
    private final static QName _AddPersionResponse_QNAME = new QName("http://demo3.day67webservice/", "addPersionResponse");
    private final static QName _AddPersion_QNAME = new QName("http://demo3.day67webservice/", "addPersion");
    private final static QName _GetPersonAllResponse_QNAME = new QName("http://demo3.day67webservice/", "getPersonAllResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: day67webservice.demo3.stub
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddPersionResponse }
     * 
     */
    public AddPersionResponse createAddPersionResponse() {
        return new AddPersionResponse();
    }

    /**
     * Create an instance of {@link GetPersonAll }
     * 
     */
    public GetPersonAll createGetPersonAll() {
        return new GetPersonAll();
    }

    /**
     * Create an instance of {@link AddPersion }
     * 
     */
    public AddPersion createAddPersion() {
        return new AddPersion();
    }

    /**
     * Create an instance of {@link GetPersonAllResponse }
     * 
     */
    public GetPersonAllResponse createGetPersonAllResponse() {
        return new GetPersonAllResponse();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://demo3.day67webservice/", name = "getPersonAll")
    public JAXBElement<GetPersonAll> createGetPersonAll(GetPersonAll value) {
        return new JAXBElement<GetPersonAll>(_GetPersonAll_QNAME, GetPersonAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPersionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://demo3.day67webservice/", name = "addPersionResponse")
    public JAXBElement<AddPersionResponse> createAddPersionResponse(AddPersionResponse value) {
        return new JAXBElement<AddPersionResponse>(_AddPersionResponse_QNAME, AddPersionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPersion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://demo3.day67webservice/", name = "addPersion")
    public JAXBElement<AddPersion> createAddPersion(AddPersion value) {
        return new JAXBElement<AddPersion>(_AddPersion_QNAME, AddPersion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://demo3.day67webservice/", name = "getPersonAllResponse")
    public JAXBElement<GetPersonAllResponse> createGetPersonAllResponse(GetPersonAllResponse value) {
        return new JAXBElement<GetPersonAllResponse>(_GetPersonAllResponse_QNAME, GetPersonAllResponse.class, null, value);
    }

}
