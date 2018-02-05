package com.evohome.thermostat.honeywell.request;

import com.evohome.thermostat.honeywell.response.Location;
import com.evohome.thermostat.honeywell.response.UserAccount;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

import java.util.List;

public class LocationRequest extends AuthenticatedRequest<List<Location>, Object> {
    private final UserAccount userAccount;

    public LocationRequest(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public String getUrl() {
        return BASE_URL + "/location?userId=" + userAccount.getUserId();
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    public ParameterizedTypeReference<List<Location>> getResponseClass() {
        return new ParameterizedTypeReference<List<Location>>() {
        };
    }
}
