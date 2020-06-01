package com.system.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.inventory.model.Product;
import com.system.inventory.repository.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	public void addProduct(Product product) {
		inventoryRepository.save(toEntity(product));
	}
	
	public void deleteProductByID(long productID) {
		inventoryRepository.deleteById(productID);
	}
	
	public Optional<Product> updateProduct(Product product, long productID) {
		return inventoryRepository.findById(productID).map(iProduct -> 
		{	
			iProduct.setProduct_name(product.getProduct_name());
			return inventoryRepository.save(iProduct);
			});			      
	}

	public List<Product> getAllProducts() {
		return inventoryRepository.findAll();
	}

	public Optional<Product> getProductDetails(long id) {
		Optional<Product> optionalProduct = inventoryRepository.findById(id);
        return optionalProduct;
	}

	private Product toEntity(Product p) {
		Product entity = new Product();
        entity.setProduct_id(p.getProduct_id());
        entity.setProduct_name(p.getProduct_name());
        return entity;
    }
	
}
