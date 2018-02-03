package com.evohome.thermostat.honeywell.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeZone {
    private String timeZoneId;
    private String displayName;
    private int offsetMinutes;
    private int currentOffsetMinutes;
    private boolean supportsDaylightSaving;

    @JsonCreator
    public TimeZone(@JsonProperty("timeZoneId") String timeZoneId,
                    @JsonProperty("displayName") String displayName,
                    @JsonProperty("offsetMinutes") int offsetMinutes,
                    @JsonProperty("currentOffsetMinutes") int currentOffsetMinutes,
                    @JsonProperty("supportsDaylightSaving") boolean supportsDaylightSaving) {
        this.timeZoneId = timeZoneId;
        this.displayName = displayName;
        this.offsetMinutes = offsetMinutes;
        this.currentOffsetMinutes = currentOffsetMinutes;
        this.supportsDaylightSaving = supportsDaylightSaving;
    }

    public String getTimeZoneId() {
        return timeZoneId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getOffsetMinutes() {
        return offsetMinutes;
    }

    public int getCurrentOffsetMinutes() {
        return currentOffsetMinutes;
    }

    public boolean isSupportsDaylightSaving() {
        return supportsDaylightSaving;
    }
}
