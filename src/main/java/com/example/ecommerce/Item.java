package com.example.ecommerce;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "item")
public class Item {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	private int quantity;
	
	public Item() {}

	public Item(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
		//this.id = Long.valueOf(0);
	}

	@Override
	public String toString() {
		return "Item [product=" + product + ", quantity=" + quantity + ", id=" + id + "]";
	}
	
//	public String toString() {
//		return "Item [product=" + product + ", quantity=" + quantity + "]";
//	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
