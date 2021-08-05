package com.app.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Customer {

	private Integer id;
	private String name;
	private String mobile;
	private String address;

}
