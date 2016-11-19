package inno.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLDataException;

@Controller
public class ErrorsController {

    @RequestMapping("/errorTest")
    public String errorTest() throws SQLDataException {
        if (true) {
            throw new SQLDataException("test");
        }
        return "redirect:/posts";
    }

    @ExceptionHandler(SQLDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String errorHandler() {
        return "errors/test";
    }

}
