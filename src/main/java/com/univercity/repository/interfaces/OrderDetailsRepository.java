package com.univercity.repository.interfaces;

import com.univercity.model.Associate;
import com.univercity.model.Customer;
import com.univercity.model.OrderDetails;
import com.univercity.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Long> {

	OrderDetails getByProduct(Product product);

	OrderDetails getByCustomer(Customer customer);

	OrderDetails getByAssociate(Associate associate);
}
