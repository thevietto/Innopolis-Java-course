package inno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class AuthController {

    @RequestMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) Boolean error, ModelMap map) {
        if (error == Boolean.TRUE) {
            map.addAttribute("error", true);
        }

        new HashMap<String, String>() {{
            put("", "");
        }};
        return "login";
    }


    @RequestMapping("/index")
    public String index() {
        return "index";
    }

}
