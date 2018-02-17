package com.evohome.thermostat.service;

import com.evohome.thermostat.honeywell.jackson.ZonedDateTimeDeserializer;
import com.evohome.thermostat.honeywell.jackson.ZonedDateTimeSerializer;
import com.evohome.thermostat.honeywell.request.*;
import com.evohome.thermostat.honeywell.response.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
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
        SimpleModule zonedDateTimeModule = new SimpleModule();
        zonedDateTimeModule.addSerializer(ZonedDateTime.class, new ZonedDateTimeSerializer());
        zonedDateTimeModule.addDeserializer(ZonedDateTime.class, new ZonedDateTimeDeserializer());

        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = restTemplate
                .getMessageConverters()
                .stream()
                .filter(MappingJackson2HttpMessageConverter.class::isInstance)
                .map(MappingJackson2HttpMessageConverter.class::cast)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("MappingJackson2HttpMessageConverter not found"));

        jackson2HttpMessageConverter.getObjectMapper().registerModule(zonedDateTimeModule);

        return restTemplate;
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
