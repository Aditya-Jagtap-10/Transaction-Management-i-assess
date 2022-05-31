package com.springboot.service;


import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springboot.domain.User;
import com.springboot.repository.UserRepository;


public class UserService implements UserDetailsService {

	@Autowired
	UserRepository ur;
	@Autowired
	PasswordEncoder passwordencoder;
	
	public UserDetails loadUserByUsername(String username) {
		User u=ur.findByUsername(username);
		if(u==null) {
			throw new UsernameNotFoundException("Not found");
		}
		return new UserDetails() {
			
			@Override
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean isCredentialsNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean isAccountNonLocked() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean isAccountNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public String getUsername() {
				// TODO Auto-generated method stub
				return u.getName();
			}
			
			@Override
			public String getPassword() {
				// TODO Auto-generated method stub
				return passwordencoder.encode(u.getPassword());
			}
			
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				// TODO Auto-generated method stub
				return Collections.singleton(new SimpleGrantedAuthority(u.getRole()));
			}
		};
	}

}
