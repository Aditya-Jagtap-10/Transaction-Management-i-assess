package com.springboot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	Long id;
	@Column(name="name")
	String name;
	@Column(name="brand_name")
	String brandName;
	@Column(name="price")
	Double price;
	@Column(name="rating")
	Double rating;
	@Column(name="is_available")
	Boolean isAvailable;
	@Column(name="quantity")
	Integer quantity;
	
	public Product() {
		super();
	}
	public Product(Long id, String name, String brandName, Double price, Double rating, Boolean isAvailable,
			Integer quantity) {
		super();
		this.id = id;
		this.name = name;
		this.brandName = brandName;
		this.price = price;
		this.rating = rating;
		this.isAvailable = isAvailable;
		this.quantity = quantity;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
