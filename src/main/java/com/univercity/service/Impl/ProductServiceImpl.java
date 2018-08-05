package com.univercity.service.Impl;

import com.univercity.model.Product;
import com.univercity.repository.interfaces.ProductRepository;
import com.univercity.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public void deleteProduct(long id) {
		productRepository.deleteById(id);
	}

	@Override
	public void saveProduct(Product product) {
		productRepository.saveAndFlush(product);
	}

	@Override
	public void updateProduct(Product product) {
		productRepository.saveAndFlush(product);
	}

	@Override
	public Product getByName(String name) {
		return productRepository.getByName(name);
	}

	@Override
	public Product getById(long id) {
		return productRepository.getOne(id);
	}
}
