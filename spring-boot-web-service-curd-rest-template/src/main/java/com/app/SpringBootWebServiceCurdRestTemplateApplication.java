package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.app.entities.Customer;

@SpringBootApplication
public class SpringBootWebServiceCurdRestTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebServiceCurdRestTemplateApplication.class, args);

		RestConsumerTest consumerTest = new RestConsumerTest();
		// consumerTest.getCustomerList();
		// consumerTest.getCustomer(23);

		Customer customer = new Customer();
		customer.setName("Ajinkya");
		customer.setMobile("9158565604");
		customer.setAddress("Sambhaji nagar, Kharadi");

		// consumerTest.createCustomer(customer);
		consumerTest.deteleCustomer(23);

	}
}
