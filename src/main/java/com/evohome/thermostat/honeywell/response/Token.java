package com.evohome.thermostat.honeywell.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Token extends Response {
    private final String accessToken;
    private final String refreshToken;
    private final String tokenType;
    private final int expiresIn;
    private final String scope;
    private final LocalDateTime createdAt;

    @JsonCreator
    public Token(
            @JsonProperty("access_token") final String accessToken,
            @JsonProperty("refresh_token") final String refreshToken,
            @JsonProperty("token_type") final String tokenType,
            @JsonProperty("expires_in") final int expiresIn,
            @JsonProperty("scope") final String scope) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.tokenType = tokenType;
        this.expiresIn = expiresIn;
        this.scope = scope;
        this.createdAt = LocalDateTime.now();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public String getScope() {
        return scope;
    }

    public boolean isExpired() {
        return !LocalDateTime.now().isBefore(createdAt.plusSeconds(expiresIn));
    }
}
