package com.example.stripe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.example.stripe.service.MSRestInterface;
import com.example.stripe.service.MSWhatsApp;
import com.stripe.Stripe;

@SpringBootApplication
public class StripeApplication {

	public static void main(String[] args) {
		Stripe.apiKey = "sk_live_1P13hlLHaTUKwgqrTcnau8mp";
		SpringApplication.run(StripeApplication.class, args);
	}
	
	/*
	@Bean
	MSRestInterface rest() {
		RestClient client = RestClient.create(MSWhatsApp.DOMAIN);
		HttpServiceProxyFactory factory = HttpServiceProxyFactory
				.builderFor(RestClientAdapter.create(client))
				.build();
		return factory.createClient(MSRestInterface.class);
	}
*/
	
}
