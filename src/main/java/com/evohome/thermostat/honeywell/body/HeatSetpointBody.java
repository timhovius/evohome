package com.evohome.thermostat.honeywell.body;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

public class HeatSetpointBody {
    private double heatSetpointValue;
    private SetpointMode setpointMode;
    private ZonedDateTime timeUntil;

    @JsonCreator
    public HeatSetpointBody(@JsonProperty("heatSetpointValue") final double heatSetpointValue,
                            @JsonProperty("setpointMode") final SetpointMode setpointMode,
                            @JsonProperty("timeUntil") final ZonedDateTime timeUntil) {
        this.heatSetpointValue = heatSetpointValue;
        this.setpointMode = setpointMode;
        this.timeUntil = timeUntil;
    }

    public double getHeatSetpointValue() {
        return heatSetpointValue;
    }

    public SetpointMode getSetpointMode() {
        return setpointMode;
    }

    public ZonedDateTime getTimeUntil() {
        return timeUntil;
    }
}
