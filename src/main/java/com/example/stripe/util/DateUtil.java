package com.example.stripe.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateUtil {

	public static String toScheduleUTCFormattedDate(int year, int month, int day, int hour, int minute) {
		ZonedDateTime date = getUKOffset(year, month, day, hour, minute);
		return numberToString(date.getYear()) + numberToString(date.getMonthValue()) + numberToString(date.getDayOfMonth()) + "T" + numberToString(date.getHour()) + numberToString(date.getMinute()) + "00Z";
	}
	
	public static String numberToString(int number) {
		if(number < 10) {
			return "0" + number;
		}
		return "" + number;
	}
	
	public static ZonedDateTime getUKOffset(int year, int month, int day, int hour, int minute) {
		ZoneId londonZone = ZoneId.of("Europe/London");
		ZonedDateTime date = ZonedDateTime.of(year, month, day, hour, minute, 0, 0, londonZone);
		ZoneId utcZone = ZoneId.of("UTC");
		return date.withZoneSameInstant(utcZone);
	}
	
	public static String toEventUTCFormattedDate(int year, int month, int day, int hour, int minute) {
		ZonedDateTime date = getUKOffset(year, month, day, hour, minute);
		return numberToString(date.getYear()) + "-" + numberToString(date.getMonthValue()) + "-" + numberToString(date.getDayOfMonth()) + "T" + numberToString(date.getHour()) + ":" + numberToString(date.getMinute()) + ":00Z";
		
	}

	public static String toEventUTCFormattedDatePlusMinutes(Integer year, Integer month, Integer day, Integer hour,
			Integer minute, Long minutes) {
		// TODO Auto-generated method stub
		ZoneId londonZone = ZoneId.of("Europe/London");
		ZoneId utcZone = ZoneId.of("UTC");
		ZonedDateTime date = ZonedDateTime.of(year, month, day, hour, minute, 0, 0, londonZone).plusMinutes(minutes).withZoneSameInstant(utcZone);
		return numberToString(date.getYear()) + "-" + numberToString(date.getMonthValue()) + "-" + numberToString(date.getDayOfMonth()) + "T" + numberToString(date.getHour()) + ":" + numberToString(date.getMinute()) + ":00Z";
	}
}
