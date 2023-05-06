package com.example.ecommerce;

import javax.persistence.*;


@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @SequenceGenerator(
//            name = "book_sequence",
//            sequenceName = "book_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = SEQUENCE,
//            generator = "book_sequence"
//    )
    @Column(
            name = "id",
            updatable = false
    )
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
		this.id = Long.valueOf(0);
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
