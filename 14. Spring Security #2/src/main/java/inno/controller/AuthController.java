package inno.controller;

import inno.service.UserService;
import inno.util.form.UserForm;
import inno.util.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    UserValidator userValidator;

    @RequestMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) Boolean error, ModelMap map) {
        if (error == Boolean.TRUE) {
            map.addAttribute("error", true);
        }
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(ModelMap map) {
        map.addAttribute("userForm", new UserForm());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("userForm") @Valid UserForm form, BindingResult result) {
        userValidator.validate(form, result);
        if (result.hasErrors()) {
            return "registration";
        }
        userService.saveUser(form);
        return "redirect:/login";
    }


    @RequestMapping("/index")
    public String index() {
        return "index";
    }

}
