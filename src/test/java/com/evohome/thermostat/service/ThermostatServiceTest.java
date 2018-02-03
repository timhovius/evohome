package com.evohome.thermostat.service;

import com.evohome.thermostat.honeywell.response.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThermostatServiceTest {
    private ThermostatService thermostatService;

    @Before
    public void setUp() {
        thermostatService = new ThermostatService(new RestTemplate());
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