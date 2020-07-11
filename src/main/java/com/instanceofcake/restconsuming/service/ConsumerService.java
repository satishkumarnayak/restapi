package com.instanceofcake.restconsuming.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.instanceofcake.restconsuming.domain.City;
import com.instanceofcake.restconsuming.domain.ResponseCityDTO;

@Component
public class ConsumerService {

	
	public ResponseCityDTO getCitiesByProvince(List<City> cities, String province) {
		
		List<City> citiesInProvince = cities.stream()
				                            .filter((city) -> city.getProvince().equals(province))
				                            .collect(Collectors.toList());

		Integer amountOfResturantsInProvince = citiesInProvince.stream()
															   .collect(Collectors.summingInt(City::getRestaurants));

		ResponseCityDTO response = new ResponseCityDTO(amountOfResturantsInProvince, citiesInProvince);
		return response;
		
	}
}
