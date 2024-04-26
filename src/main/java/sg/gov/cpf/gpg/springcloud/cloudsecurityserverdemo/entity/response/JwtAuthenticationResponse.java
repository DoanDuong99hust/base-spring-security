package sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.entity.response;

import java.util.List;

public class JwtAuthenticationResponse {

    private List<String> authorities;
    private String token;

    public JwtAuthenticationResponse() {
    }

    public JwtAuthenticationResponse(List<String> authorities, String token) {
        this.authorities = authorities;
        this.token = token;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public JwtAuthenticationResponse setAuthorities(List<String> authorities) {
        this.authorities = authorities;
        return this;
    }

    public String getToken() {
        return token;
    }

    public JwtAuthenticationResponse setToken(String token) {
        this.token = token;
        return this;
    }
}
