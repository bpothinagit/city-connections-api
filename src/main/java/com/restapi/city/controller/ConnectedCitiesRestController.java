package com.restapi.city.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.city.helper.ConnectedCitiesHelper;

/** 
 * @author bharatpothina
 * Controller to handle the REST End points
 *
 */
@RestController
public class ConnectedCitiesRestController {
	
    @Autowired
    private ConnectedCitiesHelper connectedCitiesHelper;

    /**
     * @param origin
     * @param destination
     * @return
     * @throws IOException
     */
    @GetMapping("/connected")
    public @ResponseBody String determineCityConnections(@RequestParam("origin") String origin,
    									   @RequestParam("destination") String destination) throws IOException {
    	return connectedCitiesHelper.areCitiesConnected(origin, destination);
    }
}
