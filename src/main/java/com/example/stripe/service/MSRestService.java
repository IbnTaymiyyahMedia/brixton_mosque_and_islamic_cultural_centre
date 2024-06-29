package com.example.stripe.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.stripe.model.MSWhatsAppUser;

@Service
public class MSRestService {

	private final RestClient restClient;
	
	public MSRestService() {
		restClient = RestClient.builder()
				.baseUrl(MSWhatsApp.DOMAIN)
				.build();
	}
	
	public List<MSWhatsAppUser> findAll() {
		return restClient.get()
				.uri("/whatsapp/users")
				.retrieve()
				.body(new ParameterizedTypeReference<List<MSWhatsAppUser>>() {});
	}
	
	public MSWhatsAppUser findById(Integer id) {
		return restClient.get()
				.uri("/whatsapp/users/{id}", id)
				.retrieve()
				.body(MSWhatsAppUser.class);
	}
	
	public MSWhatsAppUser create(MSWhatsAppUser user) {
		return restClient.post()
				.uri("/whatsapp/users")
				.contentType(MediaType.APPLICATION_JSON)
				.body(user)
				.retrieve()
				.body(MSWhatsAppUser.class);
	}
	
	public MSWhatsAppUser update(Integer id, MSWhatsAppUser user) {
		return restClient.put()
				.uri("/whatsapp/users/{id}", id)
				.contentType(MediaType.APPLICATION_JSON)
				.body(user)
				.retrieve()
				.body(MSWhatsAppUser.class);
	}
	
	public void delete(Integer id) {
		 restClient.delete()
				.uri("/whatsapp/users/{id}", id)
				.retrieve()
				.toBodilessEntity();
	}
}
