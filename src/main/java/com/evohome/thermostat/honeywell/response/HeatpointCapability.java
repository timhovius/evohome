package com.evohome.thermostat.honeywell.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class HeatpointCapability {
    private final double maxHeatSetpoint;
    private final double minHeatSetpoint;
    private final double valueResolution;
    private final List<String> allowedSetpointModes;
    private final String maxDuration;
    private final String timingResolution;

    @JsonCreator
    public HeatpointCapability(@JsonProperty("maxHeatSetpoint") final double maxHeatSetpoint,
                               @JsonProperty("minHeatSetpoint") final double minHeatSetpoint,
                               @JsonProperty("valueResolution") final double valueResolution,
                               @JsonProperty("allowedSetpointModes") final List<String> allowedSetpointModes,
                               @JsonProperty("maxDuration") final String maxDuration,
                               @JsonProperty("timingResolution") final String timingResolution) {
        this.maxHeatSetpoint = maxHeatSetpoint;
        this.minHeatSetpoint = minHeatSetpoint;
        this.valueResolution = valueResolution;
        this.allowedSetpointModes = allowedSetpointModes;
        this.maxDuration = maxDuration;
        this.timingResolution = timingResolution;
    }

    public double getMaxHeatSetpoint() {
        return maxHeatSetpoint;
    }

    public double getMinHeatSetpoint() {
        return minHeatSetpoint;
    }

    public double getValueResolution() {
        return valueResolution;
    }

    public List<String> getAllowedSetpointModes() {
        return allowedSetpointModes;
    }

    public String getMaxDuration() {
        return maxDuration;
    }

    public String getTimingResolution() {
        return timingResolution;
    }
}
