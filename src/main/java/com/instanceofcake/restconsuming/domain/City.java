package com.instanceofcake.restconsuming.domain;

public class City {

	private String city;
	private String province;
	private String country;
	private Integer restaurants;
	private String timezone;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(Integer restaurants) {
		this.restaurants = restaurants;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	
	@Override
	public String toString() {
		return "City [city=" + city + ", province=" + province + ", country=" + country + ", restaurants=" + restaurants
				+ ", timezone=" + timezone + "]";
	}
	
	
	
     
}
