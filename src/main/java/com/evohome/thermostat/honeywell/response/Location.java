package com.evohome.thermostat.honeywell.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Location extends Response {
    private int id;
    private String name;
    private String streetAddress;
    private String city;
    private String country;
    private String postcode;
    private String locationType;
    private boolean useDaylightSaveSwitching;
    private TimeZone timeZone;
    private UserAccount locationOwner;

    @JsonCreator
    public Location(@JsonProperty("locationId") int id,
                    @JsonProperty("name") String name,
                    @JsonProperty("streetAddress") String streetAddress,
                    @JsonProperty("city") String city,
                    @JsonProperty("country") String country,
                    @JsonProperty("postcode") String postcode,
                    @JsonProperty("locationType") String locationType,
                    @JsonProperty("useDaylightSaveSwitching") boolean useDaylightSaveSwitching,
                    @JsonProperty("timeZone") TimeZone timeZone,
                    @JsonProperty("locationOwner") UserAccount locationOwner) {
        this.id = id;
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
        this.postcode = postcode;
        this.locationType = locationType;
        this.useDaylightSaveSwitching = useDaylightSaveSwitching;
        this.timeZone = timeZone;
        this.locationOwner = locationOwner;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getLocationType() {
        return locationType;
    }

    public boolean isUseDaylightSaveSwitching() {
        return useDaylightSaveSwitching;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public UserAccount getLocationOwner() {
        return locationOwner;
    }
}
