package com.springboot.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springboot.handler.ForbiddenHandler;
import com.springboot.service.UserService;

@EnableWebSecurity
@Configuration
@ComponentScan({"com.springboot"})
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	ForbiddenHandler handler;
	@Autowired
	UserService userService;
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
		http.exceptionHandling().accessDeniedHandler(handler);
	 http.httpBasic()
	    .and()
		.authorizeRequests()
     .antMatchers("/product/list").hasAnyAuthority("ADMIN")
	 .antMatchers("/product/delete/{id}").hasAnyAuthority("ADMIN")
	 .antMatchers("/product/*").hasAnyAuthority("ADMIN")
     .antMatchers("/user/product/list").hasAnyAuthority("CUSTOMER")
     .antMatchers("/user/showCart/{id}").hasAnyAuthority("CUSTOMER")
     .antMatchers("/user/createCart").hasAnyAuthority("CUSTOMER")
     .antMatchers("/user/updateCart/{id}").hasAnyAuthority("CUSTOMER")
     .anyRequest().authenticated()
     .and()
     .logout().permitAll()
     .and()
     .formLogin();
	 http.csrf().disable();
			
	}
	
	void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userService);
	}
	@Bean
	public ForbiddenHandler forbiddenHandler()
	{
		return new ForbiddenHandler();
	}
	@Bean
	public UserService userDetailsService() {
	  return new UserService();
	};
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	};
	
	

    

}
