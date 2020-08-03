package com.restapi.city.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.city.helper.ConnectedCitiesHelper;

@RestController
public class ConnectedCitiesRestController {
	
    @Autowired
    private ConnectedCitiesHelper connectedCitiesHelper;

    @RequestMapping("/connected")
    public @ResponseBody String determineCityConnections(@RequestParam("origin") String origin,
    									   @RequestParam("destination") String destination) throws IOException {
    	return connectedCitiesHelper.areCitiesConnected(origin, destination);
    }
}
