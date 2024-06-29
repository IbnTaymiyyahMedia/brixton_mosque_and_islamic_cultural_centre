package com.example.stripe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.stripe.model.MSWhatsAppUser;

@Repository
public interface MSWhatsAppRepository extends CrudRepository<MSWhatsAppUser, Long> {

}
