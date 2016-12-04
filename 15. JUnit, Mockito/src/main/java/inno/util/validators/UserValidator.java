package inno.util.validators;


import inno.util.form.UserForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserForm form = (UserForm) target;
        if (!form.getPassword().equals(form.getRepassword())) {
            errors.rejectValue("repassword", "", "Passwords are not equal to each other");
        }
    }
}
