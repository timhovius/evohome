package com.evohome.thermostat.honeywell.body;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum SetpointMode {
    FOLLOW_SCHEDULE,
    PERMANENT_OVERRIDE,
    TEMPORARY_OVERRIDE;

    private static Map<String, SetpointMode> setpointModeMap = new HashMap<>();

    static {
        setpointModeMap.put("FollowSchedule", FOLLOW_SCHEDULE);
        setpointModeMap.put("PermanentOverride", PERMANENT_OVERRIDE);
        setpointModeMap.put("TemporaryOverride", TEMPORARY_OVERRIDE);
    }

    @JsonCreator
    public static SetpointMode forValue(String value) {
        return setpointModeMap.get(value);
    }

    @JsonValue
    public String toValue() {
        SetpointMode setpointMode = this;

        return setpointModeMap
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == setpointMode)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new IllegalArgumentException("SetpointMode not found"));
    }
}
