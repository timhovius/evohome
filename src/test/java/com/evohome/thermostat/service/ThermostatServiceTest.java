package com.evohome.thermostat.service;

import com.evohome.thermostat.honeywell.response.*;
import org.junit.Before;
import org.junit.Test;

import java.time.ZonedDateTime;
import java.util.List;

public class ThermostatServiceTest {
    private ThermostatService thermostatService;

    @Before
    public void setUp() throws Exception {
        String username = System.getenv("HONEYWELL_EVOHOME_USERNAME");
        String password = System.getenv("HONEYWELL_EVOHOME_PASSWORD");

        thermostatService = new ThermostatService(username, password);
    }

    @Test
    public void getUserAccount() {
        thermostatService.getUserAccount();
    }

    @Test
    public void getLocations() {
        UserAccount userAccount = thermostatService.getUserAccount();
        thermostatService.getLocations(userAccount);
    }

    @Test
    public void getInstallation() {
        UserAccount userAccount = thermostatService.getUserAccount();
        List<Location> locations = thermostatService.getLocations(userAccount);
        thermostatService.getInstallation(locations.get(0));
    }

    @Test
    public void setZoneTemperature() {
        UserAccount userAccount = thermostatService.getUserAccount();
        List<Location> locations = thermostatService.getLocations(userAccount);
        Installation installation = thermostatService.getInstallation(locations.get(0));

        // Get first gateway
        Gateway gateway = installation.getGateways().get(0);

        // Get first temperatureControlSystem
        TemperatureControlSystem temperatureControlSystem = gateway.getTemperatureControlSystems().get(0);

        // Get first zone
        Zone zone = temperatureControlSystem.getZones().get(0);

        // Set temperature for 1 hour
        ZonedDateTime zonedDateTime = ZonedDateTime.now().plusHours(1);

        thermostatService.setZoneTemperature(zone, 20.0, zonedDateTime);
    }
}