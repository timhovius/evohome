package com.evohome.thermostat.service;

import com.evohome.thermostat.honeywell.request.*;
import com.evohome.thermostat.honeywell.response.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.ZonedDateTime;
import java.util.List;

public class ThermostatService {
    private final RestTemplate restTemplate;
    private final String username;
    private final String password;

    private Token token;

    public ThermostatService(@Value("${honeywell.evohome.username}") String username,
                             @Value("${honeywell.evohome.password}") String password) {
        this.restTemplate = getRestTemplate();
        this.username = username;
        this.password = password;
        this.token = getToken();
    }

    private RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    private Token getToken() {
        return sendRequest(new TokenRequest(username, password));
    }

    private Token refreshToken() {
        return sendRequest(new RefreshTokenRequest(token));
    }

    private <R, B> R sendAuthenticatedRequest(AuthenticatedRequest<R, B> request) throws RestClientException {
        if (token.isExpired()) {
            token = refreshToken();
        }

        request.getHeaders().add("Authorization", token.getTokenType() + " " + token.getAccessToken());
        request.getHeaders().add("ApplicationId", "b013aa26-9724-4dbd-8897-048b9aada249");

        return sendRequest(request);
    }

    private <R, B> R sendRequest(Request<R, B> request) throws RestClientException {
        ResponseEntity<R> responseEntity = restTemplate.exchange(
                request.getUrl(),
                request.getHttpMethod(),
                new HttpEntity<>(request.getBody().orElse(null), request.getHeaders()),
                request.getResponseClass()
        );

        return responseEntity.getBody();
    }

    public UserAccount getUserAccount() {
        return sendAuthenticatedRequest(new UserAccountRequest());
    }

    public List<Location> getLocations(UserAccount userAccount) {
        return sendAuthenticatedRequest(new LocationRequest(userAccount));
    }

    public Installation getInstallation(Location location) {
        return sendAuthenticatedRequest(new InstallationRequest(location));
    }

    public HeatSetpoint setZoneTemperature(Zone zone, double temperature, ZonedDateTime dateTimeUntil) {
        return sendAuthenticatedRequest(new HeatSetpointRequest(zone, temperature, dateTimeUntil));
    }
}
