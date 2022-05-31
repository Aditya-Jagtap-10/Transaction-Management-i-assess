package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.domain.Product;
import com.springboot.repository.ProductRepository;

@RestController
public class ProductController {
	@Autowired
	ProductRepository prepo;
	
	@GetMapping("/product/list")
	public List<Product> list()
	{
		return (List<Product>) prepo.findAll();
	}
	@DeleteMapping("/product/delete/{id}")
	public Boolean delete(@PathVariable Long id)
	{
		System.out.println(id);
		try {
			if(prepo.findById(id)==null)
			{
				return false;
			}
			prepo.deleteById(id);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
}
