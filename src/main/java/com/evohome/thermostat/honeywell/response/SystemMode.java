package com.evohome.thermostat.honeywell.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SystemMode {
    private final String systemMode;
    private final boolean canBePermanent;
    private final boolean canBeTemporary;
    private final String maxDuration;
    private final String timingResolution;
    private final String timingMode;

    @JsonCreator
    public SystemMode(@JsonProperty("systemMode") final String systemMode,
                      @JsonProperty("canBePermanent") final boolean canBePermanent,
                      @JsonProperty("canBeTemporary") final boolean canBeTemporary,
                      @JsonProperty("maxDuration") final String maxDuration,
                      @JsonProperty("timingResolution") final String timingResolution,
                      @JsonProperty("timingMode") final String timingMode) {
        this.systemMode = systemMode;
        this.canBePermanent = canBePermanent;
        this.canBeTemporary = canBeTemporary;
        this.maxDuration = maxDuration;
        this.timingResolution = timingResolution;
        this.timingMode = timingMode;
    }

    public String getSystemMode() {
        return systemMode;
    }

    public boolean isCanBePermanent() {
        return canBePermanent;
    }

    public boolean isCanBeTemporary() {
        return canBeTemporary;
    }

    public String getMaxDuration() {
        return maxDuration;
    }

    public String getTimingResolution() {
        return timingResolution;
    }

    public String getTimingMode() {
        return timingMode;
    }
}
