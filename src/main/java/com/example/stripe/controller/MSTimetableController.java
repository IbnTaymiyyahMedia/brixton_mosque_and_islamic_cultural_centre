package com.example.stripe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stripe.model.DayOfMonth;
import com.example.stripe.service.MSTimetableService;

@RestController
public class MSTimetableController {
	@Autowired
	private MSTimetableService service;
	
	@GetMapping("/timetable.json")
	public List<DayOfMonth> timetable() {
		return service.findAll();
	}
}
