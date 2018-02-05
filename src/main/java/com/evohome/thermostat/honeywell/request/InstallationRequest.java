package com.evohome.thermostat.honeywell.request;

import com.evohome.thermostat.honeywell.response.Installation;
import com.evohome.thermostat.honeywell.response.Location;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

public class InstallationRequest implements Request<Installation, Object> {
    private final Location location;

    public InstallationRequest(Location location) {
        this.location = location;
    }

    @Override
    public String getUrl() {
        return BASE_URL + "/location/" + location.getId() + "/installationInfo?includeTemperatureControlSystems=True";
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    public ParameterizedTypeReference<Installation> getResponseClass() {
        return new ParameterizedTypeReference<Installation>() {
        };
    }
}
