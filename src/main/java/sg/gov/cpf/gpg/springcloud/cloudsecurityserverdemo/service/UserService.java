package sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.entity.User;

public interface UserService {

    User insert(User user) throws Exception;
    User findByUsername(String username);
    User findByEmail(String email);
    UserDetailsService userDetailsService();
}
