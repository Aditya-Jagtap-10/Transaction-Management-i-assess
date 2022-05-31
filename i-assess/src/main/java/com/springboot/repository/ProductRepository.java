package com.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	public List<Product> findByIsAvailable(Boolean isAvailable);
	
}
