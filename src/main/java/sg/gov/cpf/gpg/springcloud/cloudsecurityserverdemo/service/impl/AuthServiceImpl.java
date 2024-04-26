package sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.constant.PermissionEnum;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.constant.RoleEnum;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.entity.Permission;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.entity.Role;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.entity.User;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.entity.request.SignInRequest;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.entity.request.SignUpRequest;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.entity.response.JwtAuthenticationResponse;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.jwt.CustomUserDetails;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.jwt.JwtService;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.repository.UserRepository;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.service.AuthService;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthServiceImpl(UserService userService, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user = userService.findByEmail(request.getEmail());
        List<String> authorities = new ArrayList<>();
        for (Role role: user.getRoles()) {
            authorities.add(role.getValue().name());
        }
        String jwt = jwtService.generateToken(new CustomUserDetails(user));
        return new JwtAuthenticationResponse(authorities, jwt);
    }

    @Override
    public JwtAuthenticationResponse signUp(SignUpRequest request) throws Exception {
        Role defaultRole = new Role();
        defaultRole.setValue(RoleEnum.USER);
        User user = userService.insert(new User()
                .setFistName(request.getFirstName())
                .setLastName(request.getLastName())
                .setUsername(request.getUsername())
                .setEmail(request.getEmail())
                .setPassword(passwordEncoder.encode(request.getPassword()))
                .setRoles(Set.of(defaultRole))
                .setPermissions(Set.of(new Permission().setValue(PermissionEnum.READ)))
        );
        String jwt = jwtService.generateToken(new CustomUserDetails(user));
        return new JwtAuthenticationResponse().setToken(jwt);
    }
}
