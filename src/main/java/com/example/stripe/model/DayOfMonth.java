package com.example.stripe.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;

public class DayOfMonth implements Persistable<Long> {

	@Id
	private long id;
	private Integer day;
	private Integer hourDhuhr;
	private Integer minuteDhuhr;
	private Integer hourAsr;
	private Integer minuteAsr;
	private Integer hourMaghrib;
	private Integer minuteMaghrib;
	private Integer hourIsha;
	private Integer minuteIsha;
	private Integer month;
	private Integer year;
	private Integer hourFajr;
	private Integer minuteFajr;
	private static boolean isNew = true;
	private static final int[] hours = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
	private static final int[] minutes = {0,5,10,15,20,25,30,35,40,45,50,55};
	
	public DayOfMonth() {
		
	}
	
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public Integer getHourDhuhr() {
		return hourDhuhr;
	}
	public void setHourDhuhr(Integer hourDhuhr) {
		this.hourDhuhr = hourDhuhr;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getHourFajr() {
		return hourFajr;
	}
	public void setHourFajr(Integer hourFajr) {
		this.hourFajr = hourFajr;
	}
	public Integer getMinuteDhuhr() {
		return minuteDhuhr;
	}
	public void setMinuteDhuhr(Integer minuteDhuhr) {
		this.minuteDhuhr = minuteDhuhr;
	}
	public Integer getHourAsr() {
		return hourAsr;
	}
	public void setHourAsr(Integer hourAsr) {
		this.hourAsr = hourAsr;
	}
	public Integer getMinuteAsr() {
		return minuteAsr;
	}
	public void setMinuteAsr(Integer minuteAsr) {
		this.minuteAsr = minuteAsr;
	}
	public Integer getHourMaghrib() {
		return hourMaghrib;
	}
	public void setHourMaghrib(Integer hourMaghrib) {
		this.hourMaghrib = hourMaghrib;
	}
	public Integer getMinuteMaghrib() {
		return minuteMaghrib;
	}
	public void setMinuteMaghrib(Integer minuteMaghrib) {
		this.minuteMaghrib = minuteMaghrib;
	}
	public Integer getHourIsha() {
		return hourIsha;
	}
	public void setHourIsha(Integer hourIsha) {
		this.hourIsha = hourIsha;
	}
	public Integer getMinuteIsha() {
		return minuteIsha;
	}
	public void setMinuteIsha(Integer minuteIsha) {
		this.minuteIsha = minuteIsha;
	}
	public Integer getMinuteFajr() {
		return minuteFajr;
	}
	public void setMinuteFajr(Integer minuteFajr) {
		this.minuteFajr = minuteFajr;
	}
	
	public static int[] getHours() {
		return hours;
	}
	public static int[] getMinutes() {
		return minutes;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void setIsNew(boolean isNew) {
		this.isNew = isNew;
	}

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return isNew;
	}
	
}
