package com.univercity.service.interfaces;

import com.univercity.model.Product;

import java.util.List;

public interface ProductService {

	List<Product> getAllProducts();

	void deleteProduct(long id);

	void saveProduct(Product product);

	void updateProduct(Product product);

	Product getByName(String name);

	Product getById(long id);
}
