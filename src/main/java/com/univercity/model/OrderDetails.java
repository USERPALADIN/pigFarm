package com.univercity.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_details")
public class OrderDetails {

	@Id
	@Column(name = "order_details_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn( name = "order_details_customer_id")
	private Customer customer;

	@Column(name = "date")
	private String  date;

	@ManyToOne
	@JoinColumn(name = "order_details_product_id")
	private Product product;

	@Column(name = "amount_product")
	private int amount;

	@ManyToOne
	@JoinColumn(name = "order_details_associate_id")
	private Associate associate;

	public OrderDetails() {
	}

	public OrderDetails(Customer customer, String  date, Product product, int amount, Associate associate) {
		this.customer = customer;
		this.date = date;
		this.product = product;
		this.amount = amount;
		this.associate = associate;
	}

	public String  getDate() {
		return date;
	}

	public void setDate(String  date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public long getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Product getProduct() {
		return product;
	}

	public Associate getAssociate() {
		return associate;
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
