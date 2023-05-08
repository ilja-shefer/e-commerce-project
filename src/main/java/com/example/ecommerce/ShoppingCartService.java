package com.example.ecommerce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {
	private final ShoppingCartRepository shoppingCartRepository;

	@Autowired
	public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
		this.shoppingCartRepository = shoppingCartRepository;
	}

	// Retrieve all shopping carts
	public List<ShoppingCart> getShoppingCarts() {
		return shoppingCartRepository.findAll();
	}
	
	// Add a new shopping cart
	public ShoppingCart addNewShoppingCart(ShoppingCart shoppingCart) {
		return shoppingCartRepository.save(shoppingCart);
	}
	
	// Add a new item to a shopping cart TODO !!!!doesn't work
	public ShoppingCart addNewItemToShoppingCart(Long id, Item item) {
		ShoppingCart shoppingCart = shoppingCartRepository.findById(id).orElseThrow();
		
		shoppingCart.addItem(item);
		return shoppingCartRepository.save(shoppingCart);
	}
	
	// Delete an item from a shopping cart 
	public ShoppingCart deleteItemFromShoppingCart(Long cartId, Long itemId) {
		ShoppingCart shoppingCart = shoppingCartRepository.findById(cartId).orElseThrow();
		
		Item itemToRemove = shoppingCart.getItems().stream()
                .filter(item -> item.getId().equals(itemId))
                .findFirst()
                .orElseThrow();

        shoppingCart.removeItem(itemToRemove);
		
		return shoppingCart;
	}
	
	// Update an item in a shopping cart
	public void updateItemInShoppingCart(Long cartId, Long itemId, Item updatedItem) {
        // Retrieve the shopping cart from the database
        ShoppingCart shoppingCart = shoppingCartRepository.findById(cartId)
                .orElseThrow();

        // Find the item in the shopping cart's list of items
        Item itemToUpdate = shoppingCart.getItems().stream()
                .filter(item -> item.getId().equals(itemId))
                .findFirst()
                .orElseThrow();

        // Update the properties of the item with the updated values
        itemToUpdate.setQuantity(updatedItem.getQuantity());

        // Save the updated shopping cart back to the database
        shoppingCartRepository.save(shoppingCart);
    }
	
	//Updates the discount in a shopping cart identified by the given cart ID 
	public ShoppingCart updateDiscountInShoppingCart(Long cartId, double discount) {
	    // Retrieve the shopping cart from the database
	    ShoppingCart shoppingCart = shoppingCartRepository.findById(cartId)
	            .orElseThrow();

	    // Update the discount in the shopping cart
	    shoppingCart.setDiscount(discount);

	    // Save the updated shopping cart back to the database
	    return shoppingCartRepository.save(shoppingCart);
	}
	
	//Calculates the total price of items in a shopping cart identified by the given cart ID 
	public double calculateTotalPriceInShoppingCart(Long cartId) {
	    // Retrieve the shopping cart from the database
	    ShoppingCart shoppingCart = shoppingCartRepository.findById(cartId)
	            .orElseThrow();

	    // Calculate the total price
	    double totalPrice = shoppingCart.getItems().stream()
	            .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
	            .sum();

	    return totalPrice;
	}
}
