package com.evohome.thermostat.honeywell.request;

import com.evohome.thermostat.honeywell.body.Body;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

public interface Request<T> {

    String BASE_URL = "https://tccna.honeywell.com/WebApi/emea/api/v1";

    String getUrl();

    HttpMethod getHttpMethod();

    Body getBody();

    ParameterizedTypeReference<T> getResponseClass();
}
