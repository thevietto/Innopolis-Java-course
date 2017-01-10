package ru.inno;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

@WebService(name = "PersonsService", serviceName = "PersonsService", portName = "PersonsPort")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class PersonsService {

//    @WebMethod(exclude = true)
    @WebMethod(operationName = "getAwesomePersons")
    @WebResult(partName = "Person", name = "Person")
    public List<Person> getPersons() {
        List<Person> result = new ArrayList<Person>();
        result.add(new Person("Вася", "Пупкин", 19));
        result.add(new Person("Ахмед", "Петров", 99));
        result.add(new Person("Петр", "Ахмедов", 45));
        return result;
    }

    @WebResult(partName = "Person")
    public Person addPerson(@WebParam(name = "awesomePerson") Person person) {
        return person;
    }

}
