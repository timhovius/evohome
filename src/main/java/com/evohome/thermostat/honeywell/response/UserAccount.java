package com.evohome.thermostat.honeywell.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserAccount extends Response {
    private int userId;
    private String username;
    private String firstname;
    private String lastname;
    private String streetAddress;
    private String city;
    private String postcode;
    private String country;
    private String language;

    @JsonCreator
    public UserAccount(@JsonProperty("userId") int userId,
                       @JsonProperty("username") String username,
                       @JsonProperty("firstname") String firstname,
                       @JsonProperty("lastname") String lastname,
                       @JsonProperty("streetAddress") String streetAddress,
                       @JsonProperty("city") String city,
                       @JsonProperty("postcode") String postcode,
                       @JsonProperty("country") String country,
                       @JsonProperty("language") String language) {
        this.userId = userId;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.language = language;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }

    public String getLanguage() {
        return language;
    }
}
