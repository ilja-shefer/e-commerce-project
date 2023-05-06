package com.example.ecommerce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public  List<Product> getProducts(){
		return productRepository.findAll();
	}
	
	public void addNewProduct(Product product) {
		productRepository.save(product);
	}

}
