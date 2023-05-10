package com.example.ecommerce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<Product> getProducts() {
		return productService.getProducts();
	}
	
	@PostMapping
	public void registerNewProduct(@RequestBody Product product) {
		productService.addNewProduct(product);
	}
}
