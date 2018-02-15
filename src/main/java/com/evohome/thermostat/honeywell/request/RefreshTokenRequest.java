package com.evohome.thermostat.honeywell.request;

import com.evohome.thermostat.honeywell.response.Token;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Optional;

public class RefreshTokenRequest implements Request<Token, MultiValueMap<String, String>> {
    private final Token token;

    public RefreshTokenRequest(final Token token) {
        this.token = token;
    }

    @Override
    public String getUrl() {
        return "https://tccna.honeywell.com/Auth/OAuth/Token";
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    public HttpHeaders getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "Basic YjAxM2FhMjYtOTcyNC00ZGJkLTg4OTctMDQ4YjlhYWRhMjQ5OnRlc3Q=");

        return headers;
    }

    @Override
    public Optional<MultiValueMap<String, String>> getBody() {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "refresh_token");
        body.add("refresh_token", token.getRefreshToken());

        return Optional.of(body);
    }

    @Override
    public ParameterizedTypeReference<Token> getResponseClass() {
        return new ParameterizedTypeReference<Token>() {
        };
    }
}
