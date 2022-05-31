package com.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	public User findByUsername(String username);
	public User findByName(String name);

}
