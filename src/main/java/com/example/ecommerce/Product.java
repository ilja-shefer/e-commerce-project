package com.example.ecommerce;

import javax.persistence.*;


@Entity
@Table(name = "product")
public class Product {

    @Id
    @SequenceGenerator(name="product_sequence", sequenceName="product_sequence", allocationSize=1, initialValue=1001)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="product_sequence")
    @Column(name = "id")
    private Long id;

    @Column(
            name = "product_name",
            nullable = false
    )
    private String name;
    
    @Column(
            name = "product_price",
            nullable = false
    )
	private double price;
    
    public Product() {};

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", id=" + id + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
