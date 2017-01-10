package ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.1.9
 * 2017-01-09T20:11:32.070+03:00
 * Generated source version: 3.1.9
 * 
 */
@WebService(targetNamespace = "http://inno.ru/", name = "PersonsService")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface PersonsService {

    @WebMethod
    @WebResult(name = "Person", targetNamespace = "http://inno.ru/", partName = "Person")
    public Person addPerson(
        @WebParam(partName = "awesomePerson", name = "awesomePerson")
        Person awesomePerson
    );

    @WebMethod
    @WebResult(name = "Person", targetNamespace = "http://inno.ru/", partName = "Person")
    public PersonArray getAwesomePersons();
}
