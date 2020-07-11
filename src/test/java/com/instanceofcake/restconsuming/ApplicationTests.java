package com.instanceofcake.restconsuming;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.instanceofcake.restconsuming.domain.City;
import com.instanceofcake.restconsuming.domain.ResponseCityDTO;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	@LocalServerPort
	int randomServerPort;

	@Test
	public void testGetONDataSuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + randomServerPort + "/cities/ON";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		assertNotNull(result);
		assertEquals(200, result.getStatusCodeValue());
		
		Type listType = new TypeToken<ResponseCityDTO>() {
		}.getType();
		ResponseCityDTO actualONResult = new Gson().fromJson(result.getBody(), listType);

		assertEquals(13852, actualONResult.getAmountofResturants());
		assertEquals(70, actualONResult.getCities().size());
		City city = actualONResult.getCities().get(0);
		assertEquals("Toronto", city.getCity());
		assertEquals("CAN", city.getCountry());
		assertEquals("ON", city.getProvince());
		assertEquals(4057, city.getRestaurants());
		assertEquals("America/Toronto", city.getTimezone());

	}
	
	@Test
	public void testGetInvalidProvinceFailure() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + randomServerPort + "/cities/INVALIDPROVINCECODE";
		URI uri = new URI(baseUrl);
		ResponseEntity<String> result = null;
		try {
		result = restTemplate.getForEntity(uri, String.class);
		} catch(HttpClientErrorException e){

			assertNotNull(e);
			assertTrue((e.getMessage().contains("Province Not Found:INVALIDPROVINCECODE")));
		}
		
		
		

	}
}
