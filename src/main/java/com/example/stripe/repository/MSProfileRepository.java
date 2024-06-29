package com.example.stripe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.stripe.model.MSBusinessProfile;

@Repository
public interface MSProfileRepository extends CrudRepository<MSBusinessProfile, Long> {

}
