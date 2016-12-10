package inno.service.impl;

import inno.model.Role;
import inno.model.User;
import inno.repository.RoleRepository;
import inno.repository.UserRepository;
import inno.service.UserService;
import inno.util.form.UserForm;
import inno.util.transformers.UserFormTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private static final String DEFAULT_ROLE_NAME = "ROLE_USER";
    private Role defaultRole;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserFormTransformer transformer;

    @PostConstruct
    private void initialize() {
        defaultRole = roleRepository.findByName(DEFAULT_ROLE_NAME);
    }

    @Transactional
    @Override
    public void saveUser(UserForm form) {
        User user = transformer.toUser(form);
        user.getRoles().add(defaultRole);
        userRepository.save(user);
    }
}
