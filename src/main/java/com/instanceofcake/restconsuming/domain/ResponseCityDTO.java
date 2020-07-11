package com.instanceofcake.restconsuming.domain;

import java.util.List;

public class ResponseCityDTO {
	
	private Integer amountofResturants;
	 
	private List<City> cities;
	
	

	public ResponseCityDTO(Integer amountofResturants, List<City> cities) {
		super();
		this.amountofResturants = amountofResturants;
		this.cities = cities;
	}

	public Integer getAmountofResturants() {
		return amountofResturants;
	}

	public void setAmountofResturants(Integer amountofResturants) {
		this.amountofResturants = amountofResturants;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
	

}
