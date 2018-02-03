package com.evohome.thermostat.honeywell.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ScheduleCapability {
    private final int maxSwitchpointsPerDay;
    private final int minSwitchpointsPerDay;
    private final String timingResolution;
    private final double setpointValueResolution;

    @JsonCreator
    public ScheduleCapability(@JsonProperty("maxSwitchpointsPerDay") final int maxSwitchpointsPerDay,
                              @JsonProperty("minSwitchpointsPerDay") final int minSwitchpointsPerDay,
                              @JsonProperty("timingResolution") final String timingResolution,
                              @JsonProperty("setpointValueResolution") final double setpointValueResolution) {
        this.maxSwitchpointsPerDay = maxSwitchpointsPerDay;
        this.minSwitchpointsPerDay = minSwitchpointsPerDay;
        this.timingResolution = timingResolution;
        this.setpointValueResolution = setpointValueResolution;
    }

    public int getMaxSwitchpointsPerDay() {
        return maxSwitchpointsPerDay;
    }

    public int getMinSwitchpointsPerDay() {
        return minSwitchpointsPerDay;
    }

    public String getTimingResolution() {
        return timingResolution;
    }

    public double getSetpointValueResolution() {
        return setpointValueResolution;
    }
}
