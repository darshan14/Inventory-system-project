package com.system.inventory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.inventory.model.Product;
import com.system.inventory.service.InventoryService;


@RequestMapping("api/v1/product")
@RestController
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@PostMapping
	public void createProduct(@RequestBody Product product) {
		inventoryService.addProduct(product);
	}
	
	@DeleteMapping(path ="/{id}")
	public void deleteProduct(@PathVariable("id") int productID) {
		inventoryService.deleteProductByID((long) productID);
	}
	
	@PutMapping(path ="/{id}")
	public Optional<Product> updateProduct(@RequestBody Product product, @PathVariable("id") long productID) {
		return inventoryService.updateProduct(product, productID);
	}

	@GetMapping
	public List<Product> getAllProductList() {
		return inventoryService.getAllProducts();
	}

	@GetMapping(path ="/{id}")
	public Optional<Product> getProduct(@PathVariable("id") long id) {
		Optional<Product> optionalProduct = inventoryService.getProductDetails(id);
        return optionalProduct;
	}
	
	/*
	 * @GetMapping("/getProd") public List<String> getTuples() { return
	 * inventoryRepository.getTuples(); }
	 */
}
