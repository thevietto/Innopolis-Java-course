package ru.inno;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloWorldService {

    @WebMethod
    public String hello() {
        return "it works!";
    }

    @WebMethod
    public int sum(int a, int b) {
        return a + b;
    }

}
