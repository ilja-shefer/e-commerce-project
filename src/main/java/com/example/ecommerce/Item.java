package com.example.ecommerce;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "item")
public class Item {
	@Id
    @SequenceGenerator(name="item_sequence", sequenceName="item_sequence", allocationSize=1, initialValue=101)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="item_sequence")
    private Long id;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	private int quantity;

//	@ManyToOne
//  @JoinColumn(name = "shopping_cart_id")
//  private ShoppingCart cart;
	

	public Item() {}

	public Item(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Item [product=" + product + ", quantity=" + quantity + ", id=" + id + "]";
	}

//	public ShoppingCart getCart() {
//		return cart;
//	}
//
//	public void setCart(ShoppingCart cart) {
//		this.cart = cart;
//	}
//
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
