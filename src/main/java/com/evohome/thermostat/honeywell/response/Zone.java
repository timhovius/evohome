package com.evohome.thermostat.honeywell.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Zone {
    private final int id;
    private final String modelType;
    private final String name;
    private final String zoneType;
    private final HeatpointCapability heatpointCapability;
    private final ScheduleCapability scheduleCapability;

    @JsonCreator
    public Zone(@JsonProperty("zoneId") final int id,
                @JsonProperty("modelType") final String modelType,
                @JsonProperty("name") final String name,
                @JsonProperty("zoneType") final String zoneType,
                @JsonProperty("heatSetpointCapabilities") final HeatpointCapability heatpointCapability,
                @JsonProperty("scheduleCapability") final ScheduleCapability scheduleCapability) {
        this.id = id;
        this.modelType = modelType;
        this.name = name;
        this.zoneType = zoneType;
        this.heatpointCapability = heatpointCapability;
        this.scheduleCapability = scheduleCapability;
    }

    public int getId() {
        return id;
    }

    public String getModelType() {
        return modelType;
    }

    public String getName() {
        return name;
    }

    public String getZoneType() {
        return zoneType;
    }

    public HeatpointCapability getHeatpointCapability() {
        return heatpointCapability;
    }

    public ScheduleCapability getScheduleCapability() {
        return scheduleCapability;
    }
}
