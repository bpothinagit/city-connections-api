package com.restapi.city.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConnectedCitiesHelperTest {
	
	private static final String YES_RESPONSE = "yes";
	private static final String NO_RESPONSE = "no";
	
	@Autowired
	private ConnectedCitiesHelper connectedCitiesHelper;
	
	@Test
	public void testAreCitiesConnected() throws IOException {
		assertEquals(YES_RESPONSE, connectedCitiesHelper.areCitiesConnected("Boston", "Newark"));		
		assertEquals(YES_RESPONSE, connectedCitiesHelper.areCitiesConnected("Boston", "Philadelphia"));		
		assertEquals(NO_RESPONSE, connectedCitiesHelper.areCitiesConnected("Philadelphia", "Albany"));
		assertEquals(NO_RESPONSE, connectedCitiesHelper.areCitiesConnected("NonExistantCity1", "NonExistantCity2"));
		assertEquals(NO_RESPONSE, connectedCitiesHelper.areCitiesConnected("Boston", "NonExistantCity2"));
		assertEquals(NO_RESPONSE, connectedCitiesHelper.areCitiesConnected("", ""));
		assertEquals(NO_RESPONSE, connectedCitiesHelper.areCitiesConnected("Boston", ""));
	}

}
