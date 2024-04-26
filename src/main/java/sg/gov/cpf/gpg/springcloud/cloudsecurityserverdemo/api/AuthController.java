package sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.entity.request.SignInRequest;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.entity.request.SignUpRequest;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.entity.response.JwtAuthenticationResponse;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.service.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authenticationService;

    public AuthController(AuthService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) throws Exception {
        return ResponseEntity.ok(authenticationService.signUp(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest request) {
        return ResponseEntity.ok(authenticationService.signIn(request));
    }
}
