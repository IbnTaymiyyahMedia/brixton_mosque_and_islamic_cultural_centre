package com.example.stripe.model;

import java.util.ArrayList;
import java.util.List;

public class DaysOfMonthDTO {
	List<DayOfMonth> days;
	
	public DaysOfMonthDTO(){
		days = new ArrayList<>();
	}
	
	public DaysOfMonthDTO(List<DayOfMonth> days){
		this.days = days;
	}
	
	public void addDay(DayOfMonth day) {
		this.days.add(day);
	}

	public List<DayOfMonth> getDays() {
		return days;
	}

	public void setDays(List<DayOfMonth> days) {
		this.days = days;
	}
	
	public boolean isEmpty() {
		return this.days.isEmpty();
	}
	
}
