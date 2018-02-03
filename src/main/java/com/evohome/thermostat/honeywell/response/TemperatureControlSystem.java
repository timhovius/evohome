package com.evohome.thermostat.honeywell.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TemperatureControlSystem {
    private final int systemId;
    private final String modelType;
    private final List<Zone> zones;
    private final List<SystemMode> systemModes;

    @JsonCreator
    public TemperatureControlSystem(@JsonProperty("systemId") final int systemId,
                                    @JsonProperty("modelType") final String modelType,
                                    @JsonProperty("zones") final List<Zone> zones,
                                    @JsonProperty("allowedSystemModes") final List<SystemMode> systemModes) {
        this.systemId = systemId;
        this.modelType = modelType;
        this.zones = zones;
        this.systemModes = systemModes;
    }

    public int getSystemId() {
        return systemId;
    }

    public String getModelType() {
        return modelType;
    }

    public List<Zone> getZones() {
        return zones;
    }

    public List<SystemMode> getSystemModes() {
        return systemModes;
    }
}
