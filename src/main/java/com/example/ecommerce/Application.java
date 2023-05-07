package com.example.ecommerce;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	CommandLineRunner clrShoppingCart(ShoppingCartRepository shoppingCartRepository, ProductRepository productRepository) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				Product milk = new Product("milk", 19.99);
				Product cheese = new Product("cheese", 30.49);
				productRepository.saveAll(List.of(milk, cheese));
				System.out.println("After save milk: " + milk);
				
				Item item1 = new Item(milk, 4);
				ShoppingCart cartOfJohn = new ShoppingCart("John Trump", 10.00);
//				cartOfJohn.getItems().add(item1);
				cartOfJohn.addItem(item1);
				cartOfJohn.addItem(new Item(cheese, 2));
				shoppingCartRepository.save(cartOfJohn);
				System.out.println("After save 1: " + cartOfJohn);

//				cartOfJohn.getItems().get(0).setQuantity(128);
//				shoppingCartRepository.save(cartOfJohn);
				
				cartOfJohn.setCustomerName("Robby");
				shoppingCartRepository.save(cartOfJohn);
				System.out.println("After save 2: " + cartOfJohn);

				cartOfJohn.removeItem(item1);
				shoppingCartRepository.save(cartOfJohn);
				System.out.println("After save 3: " + cartOfJohn);
			}
		};
	}
}
