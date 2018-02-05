package com.evohome.thermostat.service;

import com.evohome.thermostat.honeywell.request.*;
import com.evohome.thermostat.honeywell.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class ThermostatService {
    private final RestTemplate restTemplate;

    @Value("${honeywell.username}")
    private String username;

    @Value("${honeywell.password}")
    private String password;

    @Autowired
    public ThermostatService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // TODO refresh token
    // TODO move token to new Request class
    private Token getToken() {
        // Create the request body as a MultiValueMap
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "password");
        body.add("username", username);
        body.add("password", password);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "Basic YjAxM2FhMjYtOTcyNC00ZGJkLTg4OTctMDQ4YjlhYWRhMjQ5OnRlc3Q=");

        return restTemplate.postForObject(
                "https://tccna.honeywell.com/Auth/OAuth/Token",
                new HttpEntity<>(body, headers),
                Token.class
        );
    }

    private <R, B> R sendRequest(Request<R, B> request) throws RestClientException {
        Token token = getToken();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token.getTokenType() + " " + token.getAccessToken());
        headers.add("ApplicationId", "b013aa26-9724-4dbd-8897-048b9aada249");

        ResponseEntity<R> responseEntity = restTemplate.exchange(
                request.getUrl(),
                request.getHttpMethod(),
                new HttpEntity<>(request.getBody(), headers),
                request.getResponseClass()
        );

        return responseEntity.getBody();
    }

    public UserAccount getUserAccount() {
        return sendRequest(new UserAccountRequest());
    }

    public List<Location> getLocations(UserAccount userAccount) {
        return sendRequest(new LocationRequest(userAccount));
    }

    public Installation getInstallation(Location location) {
        return sendRequest(new InstallationRequest(location));
    }

    public HeatSetpoint setZoneTemperature(Zone zone, double temperature, ZonedDateTime dateTimeUntil) {
        return sendRequest(new HeatSetpointRequest(zone, temperature, dateTimeUntil));
    }
}
