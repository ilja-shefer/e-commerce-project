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
	CommandLineRunner clrShoppingCart(ShoppingCartRepository shoppingCartRepository, ProductRepository productRepository, ItemRepository itemRepo) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {	
				// Saving a new shopping cart
				Product milk = new Product("milk", 19.99);
				productRepository.save(milk);
				System.out.println("After save milk: " + milk);
				
				Item item1 = new Item(milk, 4);
				ShoppingCart cart = new ShoppingCart("John Smith", 10.00);
				cart.addItem(item1);
				ShoppingCart saved = shoppingCartRepository.save(cart);
				System.out.println("Cart after save 1: " + saved);
				
				
				// Updating an existing shopping cart
				Product cheese = new Product("cheese", 30.49);
				productRepository.save(cheese);

				item1 = new Item(cheese, 2);
				itemRepo.save(item1);  // It's not clear why it is needed - possibly a Hibernate bug?
				System.out.println(item1);

				ShoppingCart cart1 = shoppingCartRepository.findAll().get(0);
				cart1.addItem(item1);
				saved = shoppingCartRepository.save(cart1);
				System.out.println("Cart after save 3: " + saved);
				

//				cart = shoppingCartRepository.findAll().get(0);
//				cart.getItems().remove(0);
//				shoppingCartRepository.save(cart);
//				System.out.println("Cart after save 3: " + cart);
				
//				cartOfJohn.setCustomerName("Robby");
//				shoppingCartRepository.save(cartOfJohn);
//				System.out.println("Cart after save 2: " + cartOfJohn);
//
//				cartOfJohn.removeItem(item1);
//				shoppingCartRepository.save(cartOfJohn);
//				System.out.println("Cart after save 3: " + cartOfJohn);
			}
		};
	}
}
