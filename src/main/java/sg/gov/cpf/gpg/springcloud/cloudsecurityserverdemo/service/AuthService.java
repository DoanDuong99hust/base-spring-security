package sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.service;

import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.entity.request.SignInRequest;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.entity.request.SignUpRequest;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.entity.response.JwtAuthenticationResponse;

public interface AuthService {

    JwtAuthenticationResponse signIn(SignInRequest signInRequest);

    JwtAuthenticationResponse signUp(SignUpRequest signUpRequest) throws Exception;
}
