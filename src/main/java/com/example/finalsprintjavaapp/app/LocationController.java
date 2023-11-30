package com.example.finalsprintjavaapp.app;

import com.example.finalsprintjavaapp.app.*;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/locations")
public class LocationController {
    private final List<Location> locations;

    public LocationController() {
        locations = new ArrayList<>();
        LoadLocationsData();
        // Read data from airports.txt and cities.txt and populate the locations list
        // You can do this in the constructor or use a separate method to load data.
    }

    private void LoadLocationsData() {
        try {
            File airportsFile = new File("src/main/java/com/example/finalsprintjavaapp/txt/airports.txt");
            File citiesFile = new File("src/main/java/com/example/finalsprintjavaapp/txt/cities.txt");
            File aircraftFile = new File("src/main/java/com/example/finalsprintjavaapp/txt/aircraft.txt");

            List<String> airportLines = FileUtils.readLines(airportsFile, "UTF-8");
            List<String> cityLines = FileUtils.readLines(citiesFile, "UTF-8");
            List<String> aircraftLines = FileUtils.readLines(aircraftFile, "UTF-8");

            int minLength = Math.min(airportLines.size(), cityLines.size());

            for (int i = 0; i < minLength; i++) {
                String airport = airportLines.get(i);
                String city = cityLines.get(i);
                String aircraft = aircraftLines.get(i);
                locations.add(new Location(airport, city, aircraft));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/airports")
    public List<String> getAirports() {
        List<String> airports = new ArrayList<>();
        for (Location location : locations) {
            airports.add(location.getAirport());
        }
        return airports;
    }

    @GetMapping("/cities")
    public List<String> getCities() {
        List<String> cities = new ArrayList<>();
        for (Location location : locations) {
            cities.add(location.getCity());
        }
        return cities;
    }

    @GetMapping("/aircraft")
    public List<String> getAircraft() {
        List<String> aircraft = new ArrayList<>();
        for (Location location : locations) {
            aircraft.add(location.getAircraft());
        }
        return aircraft;
    }

    @GetMapping("/airportsAndCities")
    public List<Location> getAirportsAndCities() {
        return locations;
    }
}
