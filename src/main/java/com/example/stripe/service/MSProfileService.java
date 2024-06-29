package com.example.stripe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.stripe.model.MSBusinessProfile;
import com.example.stripe.repository.MSProfileRepository;

@Service
public class MSProfileService {
	
	@Autowired
	MSProfileRepository repository;

	public static final int PROFILES_PER_PAGE = 20;

	public Page<MSBusinessProfile> listAll(int pageNum, String sortField, String sortDir, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	public MSBusinessProfile save(MSBusinessProfile profileImage) {
		// TODO Auto-generated method stub
		return repository.save(profileImage);
	}

	
}
