package com.restapi.city;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.restapi.city.controller.ConnectedCitiesRestController;
import com.restapi.city.helper.ConnectedCitiesHelper;

@SpringBootTest
class CityConnectionsApiApplicationTests {
	
	@Autowired
	private ConnectedCitiesRestController connectedCitiesRestController;
	
	@Autowired
	private ConnectedCitiesHelper connectedCitiesHelper;

	@Test
	void contextLoads() {
		assertThat(connectedCitiesRestController).isNotNull();
		assertThat(connectedCitiesHelper).isNotNull();
	}

}
