package com.univercity.service.interfaces;

import com.univercity.model.Customer;

import java.util.List;

public interface CustomerService {

	List<Customer> getAllCustomers();

	void deleteCustomer(long id);

	void updateCustomer(Customer customer);

	void saveCustomer(Customer customer);

	Customer getById(long id);
}
