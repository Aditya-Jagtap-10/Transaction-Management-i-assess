package com.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.domain.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long>{
	
	
}
