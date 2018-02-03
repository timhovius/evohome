package com.evohome.thermostat.honeywell.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Gateway {
    private final GatewayInfo gatewayInfo;
    private final List<TemperatureControlSystem> temperatureControlSystems;

    public Gateway(@JsonProperty("gatewayInfo") final GatewayInfo gatewayInfo,
                   @JsonProperty("temperatureControlSystems") final List<TemperatureControlSystem> temperatureControlSystems) {
        this.gatewayInfo = gatewayInfo;
        this.temperatureControlSystems = temperatureControlSystems;
    }

    public GatewayInfo getGatewayInfo() {
        return gatewayInfo;
    }

    public List<TemperatureControlSystem> getTemperatureControlSystems() {
        return temperatureControlSystems;
    }
}
