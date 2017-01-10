package ru.inno;

import javax.jws.WebService;

@WebService(endpointInterface = "ru.inno.TestService")
public class TestServiceImpl implements TestService {

    public String test() {
        return null;
    }

}
