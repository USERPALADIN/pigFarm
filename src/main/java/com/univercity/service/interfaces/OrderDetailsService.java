package com.univercity.service.interfaces;

import com.univercity.model.Associate;
import com.univercity.model.Customer;
import com.univercity.model.OrderDetails;
import com.univercity.model.Product;

import java.util.List;

public interface OrderDetailsService {

	List<OrderDetails> getAllOrderDetails();

	void saveOrderDetails(OrderDetails orderDetails);

	void deleteOrderDetails(long id);

	void updateOrderDetails(OrderDetails orderDetails);

	OrderDetails getByProduct(Product product);

	OrderDetails getByCustomer(Customer customer);

	OrderDetails getByAssociate(Associate associate);
}
