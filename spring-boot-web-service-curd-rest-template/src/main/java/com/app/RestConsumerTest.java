package com.app;

import java.util.Arrays;
import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.app.entities.Customer;

public class RestConsumerTest {
	private static final String CUSTOMERS_URL = "http://localhost:8080/customers";

	public void getCustomerList() {
		RestTemplate restTemplate = new RestTemplate();
		Customer[] customers = restTemplate.exchange(CUSTOMERS_URL, HttpMethod.GET, addHeaders(), Customer[].class)
				.getBody();
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}

	public void getCustomer(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		Customer customer = restTemplate
				.exchange("http://localhost:8080/customer/" + id, HttpMethod.GET, addHeaders(), Customer.class)
				.getBody();
		System.out.println(customer);
	}

	public void deteleCustomer(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		String str = restTemplate
				.exchange("http://localhost:8080/customer/delete/" + id, HttpMethod.DELETE, addHeaders(), String.class)
				.getBody();
		System.out.println(str);
	}

	public void createCustomer(Customer customer) {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Customer> entity = new HttpEntity<Customer>(customer, headers);

		Customer c = restTemplate
				.exchange("http://localhost:8080/customer/save", HttpMethod.POST, entity, Customer.class).getBody();

		System.out.println(c);

	}

	public static HttpEntity addHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return entity;
	}

}
