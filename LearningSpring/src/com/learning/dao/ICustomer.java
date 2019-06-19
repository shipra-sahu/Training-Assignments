package com.learning.dao;

import java.util.List;

import com.learning.model.Customer;


/**
 * @author shipra.sahu
 *
 */
public interface ICustomer {
	
	Boolean saveCustomer(Customer customer);
	List<Customer> viewCustomers();
}
