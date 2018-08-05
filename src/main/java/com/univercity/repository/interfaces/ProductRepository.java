package com.univercity.repository.interfaces;

import com.univercity.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

	Product getByName(String name);
}
