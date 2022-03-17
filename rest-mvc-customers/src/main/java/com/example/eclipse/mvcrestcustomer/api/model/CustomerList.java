package com.example.eclipse.mvcrestcustomer.api.model;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;



public class CustomerList {
	@JsonProperty
    List<Customer> customers;
    
    public CustomerList() {
    	
    	
    	customers= new ArrayList<Customer>();
    }

	public CustomerList(List<Customer> customers) {
		super();
		this.customers = customers;
	}
    
    
    
}
