package com.megatech.domain.rest.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

public class GetForObjectDemoWithJSON {

	public static void main(String args[]) {
		// deleteEmployee();
		// getEmployee();
		// updateEmployee();
		// addEmployee();
		String baseUrl = "http://localhost:9090/MegatechAssest/rest/";
		String url = baseUrl + "getAllCountries";
		System.out.println(url);

	}

	private static void getEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		Country country = restTemplate.getForObject("http://localhost:9090/MegatechAssest/rest/getCountry/{id}",
				Country.class, 2);
		System.out.println("ID: " + country.getId());
		System.out.println("Name: " + country.getCountryName());
		System.out.println("Village Name: " + country.getPopulation());
	}

	private static void deleteEmployee() {
		final String uri = "http://localhost:9090/MegatechAssest/rest/deleteCountry/{id}";

		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "12");

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, params);
	}

	private static void updateEmployee() {
		final String uriForPut = "http://localhost:9090/MegatechAssest/rest/updateCountry";

		Country country = new Country();
		country.setId(3);
		country.setCountryName("Bhutan");
		country.setPopulation(10000);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(uriForPut, country);
	}

	private static void addEmployee() {
		RestTemplate restTemplate = new RestTemplate();

		final String uri = "http://localhost:9090/MegatechAssest/rest/addCountry";

		Country country = new Country();
		country.setCountryName("USA");
		country.setPopulation(4000);

		Country addedCountry = restTemplate.postForObject(uri, country, Country.class);
		System.out.println("Country added : " + addedCountry.getCountryName());
	}

}