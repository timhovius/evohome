package com.evohome.thermostat.honeywell.request;

import com.evohome.thermostat.honeywell.body.HeatSetpointBody;
import com.evohome.thermostat.honeywell.body.SetpointMode;
import com.evohome.thermostat.honeywell.response.HeatSetpoint;
import com.evohome.thermostat.honeywell.response.Zone;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

import java.time.ZonedDateTime;

public class HeatSetpointRequest implements Request<HeatSetpoint> {
    private final Zone zone;
    private final double temperature;
    private final ZonedDateTime timeUntil;

    public HeatSetpointRequest(final Zone zone, final double temperature, final ZonedDateTime timeUntil) {
        this.zone = zone;
        this.temperature = temperature;
        this.timeUntil = timeUntil;
    }

    @Override
    public String getUrl() {
        return BASE_URL + "/temperatureZone/" + zone.getId() + "/heatSetpoint";
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.PUT;
    }

    @Override
    public HeatSetpointBody getBody() {
        return new HeatSetpointBody(temperature, SetpointMode.TEMPORARY_OVERRIDE, timeUntil);
    }

    @Override
    public ParameterizedTypeReference<HeatSetpoint> getResponseClass() {
        return new ParameterizedTypeReference<HeatSetpoint>() {
        };
    }
}
