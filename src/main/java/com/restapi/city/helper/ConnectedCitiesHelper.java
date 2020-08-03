package com.restapi.city.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

@Component
public class ConnectedCitiesHelper {

	private static final String YES_RESPONSE = "yes";
	private static final String NO_RESPONSE = "no";
	
	private Map<String, LinkedHashSet<String>> adjacentCitiesMap = null;
	private String origin;
    private String destination;
    private boolean isConnected;
	
    public String areCitiesConnected(String origin, String destination) throws IOException {
    	this.origin = origin;
    	this.destination = destination;
    	if(StringUtils.isEmpty(origin) || StringUtils.isEmpty(destination)) {
    		return NO_RESPONSE;
    	} else {
    		return traverseAndDetermineCityConnections();
    	}
    }

    private String traverseAndDetermineCityConnections() throws IOException {
    	isConnected = false;
		try (BufferedReader reader = 
				new BufferedReader(new FileReader(ResourceUtils.getFile("classpath:city.txt")))) {
			String line = null;
			adjacentCitiesMap = new HashMap<>();
			while((line = reader.readLine()) != null) {
				String[] cities = line.split(",");
				buildCityConnections(cities[0].trim(), cities[1].trim());
				buildCityConnections(cities[1].trim(), cities[0].trim());
			}
		}
		if(adjacentCitiesMap.containsKey(origin) && adjacentCitiesMap.containsKey(destination)) {
			LinkedList<String> traversedCities = new LinkedList<>();
		    traversedCities.add(origin);
		    return determineCityConnections(traversedCities);
		} else {
			return NO_RESPONSE;
		}
	}

    private void buildCityConnections(String city1, String city2) {
    	LinkedHashSet<String> adjacentCity = adjacentCitiesMap.get(city1);
    	if(adjacentCity == null) {
    		adjacentCity = new LinkedHashSet<>();
    		adjacentCitiesMap.put(city1, adjacentCity);
    	}
    	adjacentCity.add(city2);
    }
    
    private String determineCityConnections(LinkedList<String> traversedCities)
	{
	    LinkedList<String> cityList = null;
	    LinkedHashSet<String> adjacentCity = adjacentCitiesMap.get(traversedCities.getLast());
        cityList = new LinkedList<String>(adjacentCity);
	    
	    for (String city : cityList) {
	        if (traversedCities.contains(city)) {
	            continue;
	        } 
	        if (city.equals(destination)) {
	            traversedCities.add(city);
	            isConnected = true;
	        }
	    }
	
	    for (String city : cityList) {
	        if (traversedCities.contains(city) || city.equals(destination)) {
	            continue;
	        }
	        traversedCities.addLast(city);
	        determineCityConnections(traversedCities);
	    }
	    return isConnected ? YES_RESPONSE : NO_RESPONSE;
	 }

}
