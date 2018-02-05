package com.evohome.thermostat.honeywell.request;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.util.Optional;

public interface Request<R, B> {

    String BASE_URL = "https://tccna.honeywell.com/WebApi/emea/api/v1";

    String getUrl();

    HttpMethod getHttpMethod();

    HttpHeaders getHeaders();

    default Optional<B> getBody() {
        return Optional.empty();
    }

    ParameterizedTypeReference<R> getResponseClass();
}
