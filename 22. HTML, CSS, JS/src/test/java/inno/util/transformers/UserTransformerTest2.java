package inno.util.transformers;

import inno.model.User;
import inno.util.form.UserForm;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserTransformerTest2 {

    UserFormTransformer transformer;

    @Before
    public void before() {
        transformer = new UserFormTransformer();
        PasswordEncoder encoder = Mockito.mock(PasswordEncoder.class);
        Mockito.when(encoder.encode(Mockito.anyString())).thenReturn("321");
        transformer.encoder = encoder;
    }

    @Test
    public void testPasswordEncrypted() {
        UserForm form = new UserForm();
        form.setName("");
        form.setSurname("");
        form.setEmail("");
        form.setRepassword("");
        form.setPassword("122");

        User user = transformer.toUser(form);
        Assert.assertEquals("321", user.getPassword());
    }

}
