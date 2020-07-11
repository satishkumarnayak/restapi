package com.instanceofcake.restconsuming.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.instanceofcake.restconsuming.domain.City;
import com.instanceofcake.restconsuming.domain.ResponseCityDTO;
import com.instanceofcake.restconsuming.exception.ProvinceNotFoundException;
import com.instanceofcake.restconsuming.service.ConsumerService;
import com.instanceofcake.restconsuming.util.Util;

@RestController
public class ConsumerController {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ConsumerService service;

	List<String> validProvinceList = Arrays.asList("ON", "NL", "PE", "NS", "NB", "QC", "MB", "SK", "AB", "BC", "YT", "NT",
			"NU");

	@GetMapping(path = "/cities/{province}")
	public ResponseCityDTO getCitiesByProvince(@PathVariable String province) {

		validate(province);

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("App-token", "d7033722-4d2e-4263-9d67-d83854deb0fc");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		List<City> cities;
		
		/*
		 * String body = restTemplate.exchange("http://demo8417596.mockable.io/",
		 * HttpMethod.GET, entity, String.class) .getBody();
		 * 
		 * Type listType = new TypeToken<ArrayList<City>>() { }.getType(); cities = new
		 * Gson().fromJson(body, listType);
		 */

		cities = Util.getMockResponse();

		ResponseCityDTO response = service.getCitiesByProvince(cities, province);

		return response;
	}

	private void validate(String province) {
		if (province != null && !province.trim().isEmpty()) {
			if (!validProvinceList.contains(province)) {
				throw new ProvinceNotFoundException("Province Not Found:" + province);
			}
		}
	}

}
