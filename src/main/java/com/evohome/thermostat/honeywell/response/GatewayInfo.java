package com.evohome.thermostat.honeywell.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GatewayInfo {
    private final int id;
    private final String mac;
    private final String crc;
    private final boolean isWiFi;

    @JsonCreator
    public GatewayInfo(@JsonProperty("gatewayId") final int id,
                       @JsonProperty("mac") final String mac,
                       @JsonProperty("crc") final String crc,
                       @JsonProperty("isWiFi") final boolean isWiFi) {
        this.id = id;
        this.mac = mac;
        this.crc = crc;
        this.isWiFi = isWiFi;
    }

    public int getId() {
        return id;
    }

    public String getMac() {
        return mac;
    }

    public String getCrc() {
        return crc;
    }

    public boolean isWiFi() {
        return isWiFi;
    }
}
