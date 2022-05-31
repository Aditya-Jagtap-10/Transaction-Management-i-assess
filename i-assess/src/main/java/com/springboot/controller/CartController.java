package com.springboot.controller;

import java.security.Principal;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.domain.Cart;
import com.springboot.domain.Product;
import com.springboot.domain.User;
import com.springboot.repository.CartRepository;
import com.springboot.repository.ProductRepository;
import com.springboot.repository.UserRepository;

@RestController
public class CartController {

	@Autowired
	CartRepository repo;
	
	@Autowired
	ProductRepository prepo;
	
	@Autowired
	UserRepository urepo;
	
	@GetMapping("/user/showCart/{id}")
	public Cart show(@PathVariable Long id)
	{
		return repo.findById(id).orElse(new Cart());
	}
	
	@GetMapping("/user/product/list")
	public List<Product> productList()
	{
		return prepo.findByIsAvailable(true);
	}
	@PostMapping("/user/createCart")
	public Cart createCart(@RequestBody Cart c)
	{
		double sum=0;
		for (Iterator<Product> iterator = c.getProductList().iterator(); iterator.hasNext();) {
			Product product = iterator.next();
			sum+=product.getPrice();
		}
		if(sum==0)
			c.setPrice(null);
		else
			c.setPrice(sum);
		//System.out.println(sum);
		prepo.saveAll(c.getProductList());
		return repo.save(c);
	}
	@PutMapping("/user/updateCart/{id}")
	public Cart updateCart(@PathVariable Long id,@RequestBody Cart c)
	{
		double sum=0;
		for (Iterator<Product> iterator = c.getProductList().iterator(); iterator.hasNext();) {
			Product product = iterator.next();
			sum+=product.getPrice();
		}
		if(sum==0)
			c.setPrice(null);
		else
			c.setPrice(sum);
		prepo.saveAll(c.getProductList());
		c.setId(id);
		return repo.save(c);
	}
}
