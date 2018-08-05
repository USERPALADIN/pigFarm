package com.univercity.service.Impl;

import com.univercity.model.Associate;
import com.univercity.model.Customer;
import com.univercity.model.OrderDetails;
import com.univercity.model.Product;
import com.univercity.repository.interfaces.OrderDetailsRepository;
import com.univercity.service.interfaces.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	private final OrderDetailsRepository orderDetailsRepository;

	@Autowired
	public OrderDetailsServiceImpl(OrderDetailsRepository orderDetailsRepository) {
		this.orderDetailsRepository = orderDetailsRepository;
	}

	@Override
	public List<OrderDetails> getAllOrderDetails() {
		return orderDetailsRepository.findAll();
	}

	@Override
	public void saveOrderDetails(OrderDetails orderDetails) {
		orderDetailsRepository.saveAndFlush(orderDetails);
	}

	@Override
	public void deleteOrderDetails(long id) {
		orderDetailsRepository.deleteById(id);
	}

	@Override
	public void updateOrderDetails(OrderDetails orderDetails) {
			orderDetailsRepository.saveAndFlush(orderDetails);
	}

	@Override
	public OrderDetails getByProduct(Product product) {
		return orderDetailsRepository.getByProduct(product);
	}

	@Override
	public OrderDetails getByCustomer(Customer customer) {
		return orderDetailsRepository.getByCustomer(customer);
	}

	@Override
	public OrderDetails getByAssociate(Associate associate) {
		return  orderDetailsRepository.getByAssociate(associate);
	}
}
