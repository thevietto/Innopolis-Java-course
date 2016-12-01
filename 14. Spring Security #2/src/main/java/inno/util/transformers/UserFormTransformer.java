package inno.util.transformers;

import inno.model.User;
import inno.util.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserFormTransformer {

    @Autowired
    BCryptPasswordEncoder encoder;

    public User toUser(UserForm form) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setName(form.getName());
        user.setSurname(form.getSurname());
        user.setPassword(encoder.encode(form.getPassword()));
        return user;
    }

}
