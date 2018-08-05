package com.univercity.service.Impl;

import com.univercity.model.Customer;
import com.univercity.repository.interfaces.CustomerRepository;
import com.univercity.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public void deleteCustomer(long id) {
		customerRepository.deleteById(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerRepository.saveAndFlush(customer);
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerRepository.saveAndFlush(customer);
	}

	@Override
	public Customer getById(long id) {
		return customerRepository.getOne(id);
	}


}
