package com.evohome.thermostat.honeywell.request;

import org.springframework.http.HttpHeaders;

public abstract class AuthenticatedRequest<R, B> implements Request<R, B> {
    private HttpHeaders httpHeaders;

    AuthenticatedRequest() {
        this.httpHeaders = new HttpHeaders();
    }

    @Override
    public HttpHeaders getHeaders() {
        return httpHeaders;
    }
}
