package com.system.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "db_product")
public class Product {

	private long product_id;
	private String product_name;
	
	public Product() {
		
	}
		
	public Product(@JsonProperty("id")  int product_id, @JsonProperty("name") String product_name) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	
	@Column(name = "product_name", nullable = false)
	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	
}
