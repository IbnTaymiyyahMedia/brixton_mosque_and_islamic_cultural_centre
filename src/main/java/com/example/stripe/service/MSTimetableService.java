package com.example.stripe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stripe.model.DayOfMonth;
import com.example.stripe.repository.DayOfMonthRepository;

@Service
public class MSTimetableService {
	@Autowired
	DayOfMonthRepository repository;
	
	public List<DayOfMonth> findAll() {
		return (List<DayOfMonth>) repository.findAll();
	}
}
