package com.univercity.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name_product", unique = true)
	private  String name;

	@Column(name = "price")
	private  int price;

	@ManyToOne
	@JoinColumn(name = "product_unit_id")
	private Unit   unit;

	public Product() {
	}

	public Product(String name, int price, Unit unit) {
		this.name = name;
		this.price = price;
		this.unit = unit;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Unit  getUnit() {
		return unit;
	}

	public void setUnit(Unit  unit) {
		this.unit = unit;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
