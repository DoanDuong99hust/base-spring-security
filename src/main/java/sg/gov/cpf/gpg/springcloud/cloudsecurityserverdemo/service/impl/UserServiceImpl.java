package sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.entity.User;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.jwt.CustomUserDetails;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.repository.UserRepository;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User insert(User user) throws Exception {
        Optional<User> user1 = userRepository.findByUsername(user.getUsername());
        if (user1.isPresent()) {
            throw new Exception("User already existed!");
        }
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        return userOptional.orElse(new User());
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        return userOptional.orElse(new User());
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Optional<User> userOptional = userRepository.findByUsername(username);
                if (userOptional.isPresent()) {
                    return new CustomUserDetails(userOptional.get());
                }
                throw new UsernameNotFoundException("User not found!");
            }
        };
    }
}
