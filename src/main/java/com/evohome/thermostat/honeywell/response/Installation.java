package com.evohome.thermostat.honeywell.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Installation {
    private Location location;
    private List<Gateway> gateways;

    @JsonCreator
    public Installation(@JsonProperty("locationInfo") Location location,
                        @JsonProperty("gateways") List<Gateway> gateways) {
        this.location = location;
        this.gateways = gateways;
    }

    public Location getLocation() {
        return location;
    }

    public List<Gateway> getGateways() {
        return Collections.unmodifiableList(gateways);
    }
}
