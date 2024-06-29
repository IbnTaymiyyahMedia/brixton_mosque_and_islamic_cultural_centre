package com.example.stripe.service;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import com.example.stripe.model.MSWhatsAppUser;

public interface MSRestInterface {
	
	@GetExchange("/users")
	public List<MSWhatsAppUser> findAll() ;
	
	@GetExchange("/users/{id}")
	public MSWhatsAppUser findById(Integer id) ;
	
	@PostExchange("/users")
	public MSWhatsAppUser create(MSWhatsAppUser user) ;
	
	@PutExchange("/users/{id}")
	public MSWhatsAppUser update(@PathVariable Integer id, MSWhatsAppUser user) ;
	
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable  Integer id) ;
}
