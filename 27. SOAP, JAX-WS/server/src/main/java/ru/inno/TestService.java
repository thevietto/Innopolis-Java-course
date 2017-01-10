package ru.inno;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface TestService {

    @WebMethod
    String test();

}
