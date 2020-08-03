package com.restapi.city.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.restapi.city.helper.ConnectedCitiesHelper;

@SpringBootTest
public class ConnectedCitiesRestControllerTest {
	
	@Autowired
	private ConnectedCitiesRestController connectedCitiesRestController;
	
	@MockBean
	private ConnectedCitiesHelper connectedCitiesHelper;
	
	@Test
	public void testDetermineCityConnections() throws IOException {
		doReturn("yes").when(connectedCitiesHelper).areCitiesConnected("Boston", "Newark");
		doReturn("yes").when(connectedCitiesHelper).areCitiesConnected("Boston", "Philadelphia");
		doReturn("no").when(connectedCitiesHelper).areCitiesConnected("Philadelphia", "Albany");
		doReturn("no").when(connectedCitiesHelper).areCitiesConnected("", "");
		
		assertEquals("yes", connectedCitiesRestController.determineCityConnections("Boston", "Newark"));
		assertEquals("yes", connectedCitiesRestController.determineCityConnections("Boston", "Philadelphia"));
		assertEquals("no", connectedCitiesRestController.determineCityConnections("Philadelphia", "Albany"));
		assertEquals("no", connectedCitiesRestController.determineCityConnections("", ""));
	}

}
