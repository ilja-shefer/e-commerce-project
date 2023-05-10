package com.example.ecommerce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/shopping_cart")
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@GetMapping
	public List<ShoppingCart> getAllSoppingCarts() {
		return shoppingCartService.getShoppingCarts();
	}
	
	@PostMapping
	public void registerNewShoppingCart(@RequestBody ShoppingCart shoppingCart) {
		shoppingCartService.addNewShoppingCart(shoppingCart);
	}
	
	@PutMapping("/{id}/item")
    public void addNewItemToShoppingCart(@RequestBody Item item,
                                         @PathVariable("id") Long id) {
        System.out.println("id: " + id);
        System.out.println("item: " + item);
		ShoppingCart saved = shoppingCartService.addNewItemToShoppingCart(id, item);
    }

    @PutMapping("/{id}/item/{itemId}")
    public void updateItemInShoppingCart(@RequestBody Item item,
                                         @PathVariable("id") Long id,
                                         @PathVariable("itemId") Long itemId) {
        shoppingCartService.updateItemInShoppingCart(id, itemId, item);
    }

    @PutMapping("/{id}/discount")
    public void updateDiscountShoppingCart(@PathVariable("id") Long id,
                                           @RequestParam(name = "disc") double discount) {
        shoppingCartService.updateDiscountInShoppingCart(id, discount);
    }
	
	@DeleteMapping("/{id}")
	public void  deleteItemFromShoppingCart(@PathVariable("id") Long id, 
											@RequestParam (name="item_id") Long itemId) {
		shoppingCartService.deleteItemFromShoppingCart(id, itemId);
	}
	
	
	
	@GetMapping("/{id}")
	public void calculateTotalPriceInShoppingCart(@PathVariable("id") Long id) {
		shoppingCartService.calculateTotalPriceInShoppingCart(id);
	}
}

