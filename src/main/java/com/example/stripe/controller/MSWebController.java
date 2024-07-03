package com.example.stripe.controller;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.stripe.model.DayOfMonth;
import com.example.stripe.model.DaysOfMonthDTO;
import com.example.stripe.repository.DayOfMonthRepository;
import com.example.stripe.util.DateUtil;

@Controller
public class MSWebController {

	// @Resource(name = "applicationScopedBean")
	// MSApplicationOAuthToken applicationOAuthToken;

	@Autowired
	private DayOfMonthRepository db;

	@GetMapping("/previousTimetable")
	String getPreviousMonthTimetable(@RequestParam(name = "month", required = false) Integer month,
			@RequestParam(name = "year", required = false) Integer year, @ModelAttribute DaysOfMonthDTO daysOfMonth,
			BindingResult errors, final ModelMap model) {
		LocalDate previousMonth = LocalDate.of(year, month, 1).minusMonths(1l);
		return timetable(daysOfMonth, previousMonth, errors, model);
	}

	@GetMapping("/nextTimetable")
	String getNextMonthTimetable(@RequestParam(name = "month", required = false) Integer month,
			@RequestParam(name = "year", required = false) Integer year, @ModelAttribute DaysOfMonthDTO daysOfMonth,
			BindingResult errors, final ModelMap model) {
		LocalDate nextMonth = LocalDate.of(year, month, 1).plusMonths(1l);
		return timetable(daysOfMonth, nextMonth, errors, model);
	}

	@GetMapping("/timetable")
	String getTimetable(@ModelAttribute DaysOfMonthDTO daysOfMonth, BindingResult errors, final ModelMap model) {
		return timetable(daysOfMonth, LocalDate.now(), errors, model);
	}

	@PostMapping("/timetable")
	String setTimetable(@ModelAttribute DaysOfMonthDTO daysOfMonth, BindingResult errors, final ModelMap model) {
		return timetable(daysOfMonth, LocalDate.now(), errors, model);
	}

	private String timetable(DaysOfMonthDTO daysOfMonth, LocalDate now, BindingResult errors, final ModelMap model) {
		DaysOfMonthDTO days;

		// String accessToken = applicationOAuthToken.getAccessToken();
		// String tokenType = applicationOAuthToken.getTokenType();
		// String json = listEventsByOrganisation(ORGANISATION_ID, accessToken,
		// tokenType);
		// JSONObject parser = JSONObject.fromObject(json);
		// eventId: 322882689817
		// seriesId: 199412888317
		// String series = retrieveAnEventSeries("199412888317", accessToken,
		// tokenType);
		// JSONArray arrayOfOrganisations = parser.optJSONArray("events");
		// for(int i = 0; i < arrayOfOrganisations.size(); i++) {
		// JSONObject obj = arrayOfOrganisations.getJSONObject(i);
		// String id = obj.getString("id");
		// System.out.println(id);
		// }
		if (daysOfMonth.isEmpty()) {

			// LocalDate now = LocalDate.now();
			List<DayOfMonth> daysFromDB = getDaysOfMonthFromDB(now.getYear(), now.getMonthValue());
			if (!daysFromDB.isEmpty()) {
				days = new DaysOfMonthDTO(daysFromDB);
				model.addAttribute("daysOfMonth", days);
			} else {
				int daysInMonth = getDaysInMonth(now.getYear(), now.getMonthValue());
				days = new DaysOfMonthDTO();
				for (int i = 0; i < daysInMonth; i++) {

					DayOfMonth dayInTheMonth = getDayOfMonthFromList(daysFromDB, 1 + i);
					if (dayInTheMonth == null) {
						dayInTheMonth = new DayOfMonth();
						String compositeKey = (1 + i) + "" + now.getMonthValue() + "" + now.getYear();
						dayInTheMonth.setId(Long.parseLong(compositeKey));
						dayInTheMonth.setDay(1 + i);
						dayInTheMonth.setHourDhuhr(0);
						dayInTheMonth.setMinuteDhuhr(0);
						dayInTheMonth.setHourMaghrib(0);
						dayInTheMonth.setMinuteMaghrib(0);
						dayInTheMonth.setHourIsha(0);
						dayInTheMonth.setMinuteIsha(0);
						dayInTheMonth.setHourAsr(0);
						dayInTheMonth.setMinuteAsr(0);
						dayInTheMonth.setHourFajr(0);
						dayInTheMonth.setMinuteFajr(0);
						dayInTheMonth.setMonth(now.getMonthValue());
						dayInTheMonth.setYear(now.getYear());
					}
					days.addDay(dayInTheMonth);

				}

				model.addAttribute("daysOfMonth", days);
			}
			
		} else {
			// String parentEventSeries = retrieveAnEventSeries(FAJR_SERIES_PARENT_ID,
			// accessToken, tokenType);
			// Map<String,Object> parentEventSeriesObj = parseMap(parentEventSeries);
			// Map<String,Object> descriptionObj = (Map<String, Object>)
			// parentEventSeriesObj.get("description");
			// String html = (String) descriptionObj.get("html");
			List<DayOfMonth> persistDays = daysOfMonth.getDays();
			for (DayOfMonth day : persistDays) {
				DayOfMonth existingDayOfMonth = getDayOfMonthFromDB(day.getYear(), day.getMonth(), day.getDay());
				// db.create(day);
				if (existingDayOfMonth != null) {
					// update event api
					String eventStartDateTimeUTC = DateUtil.toEventUTCFormattedDate(day.getYear(), day.getMonth(),
							day.getDay(), day.getHourFajr(), day.getMinuteFajr());
					String eventEndDateTimeUTC = DateUtil.toEventUTCFormattedDatePlusMinutes(day.getYear(),
							day.getMonth(), day.getDay(), day.getHourFajr(), day.getMinuteFajr(), 20l);
					// String fajrEventUpdated =
					// updateAnEvent(existingDayOfMonth.getObjectId().toString(),
					// eventStartDateTimeUTC, eventEndDateTimeUTC, accessToken, tokenType);
					try {
						// Map<String,Object> fajrEventObjUpdated = parseMap(fajrEventUpdated);
						day.setId(existingDayOfMonth.getId());
						day.setIsNew(false);
						db.save(day);// update
					} catch (Exception jsone) {
						continue;
					}
				} else {

					String fajrUTCTime = DateUtil.toScheduleUTCFormattedDate(day.getYear(), day.getMonth(),
							day.getDay(), day.getHourFajr(), day.getMinuteFajr());
					// String fajrEventSchedule = createAnEventSchedule(FAJR_SERIES_PARENT_ID,
					// fajrUTCTime, accessToken, tokenType);
					try {
						// Map<String,Object> fajrEventObj = parseMap(fajrEventSchedule);
						// List<Object> fajrEventIds = (List<Object>)
						// fajrEventObj.get("created_event_ids");
						// if(!fajrEventIds.isEmpty()) {
						// String fajrEventId = (String) fajrEventIds.get(0);
						// Long eventbriteId = Long.decode(fajrEventId);
						// day.setObjectId(eventbriteId);
						String compositeKey = day.getDay() + "" + day.getMonth() + "" + day.getYear();
						day.setId(Long.parseLong(compositeKey));
						db.save(day);
						// }

					} catch (Exception jsone) {
						continue;
					}

				}
				System.out.println("commit to db");
			}
			model.addAttribute("daysOfMonth", daysOfMonth);
		}
		model.addAttribute("monthTitle", now.getMonth());
		model.addAttribute("monthValue", now.getMonthValue());
		model.addAttribute("yearValue", now.getYear());
		// logic to build student data

		return "timetable";
	}

	private int getDaysInMonth(int year, int month) {
		YearMonth yearMonthObject = YearMonth.of(year, month);
		return yearMonthObject.lengthOfMonth(); // 28
	}

	private List<DayOfMonth> getDaysOfMonthFromDB(int year, int month) {
		// Map<String,Object> values = new HashMap<>();
		// values.put("year", year);
		// values.put("month", month);
		return db.getWhere(year, month);
	}

	private DayOfMonth getDayOfMonthFromDB(int year, int month, int day) {
		// Map<String,Object> values = new HashMap<>();
		// values.put("year", year);
		// values.put("month", month);
		// values.put("day", day);
		List<DayOfMonth> days = db.getWhere(year, month, day);
		if (days.isEmpty()) {
			return null;
		}
		return days.get(0);
	}

	private DayOfMonth getDayOfMonthFromList(List<DayOfMonth> days, int day) {
		for (DayOfMonth dayObj : days) {
			if (dayObj.getDay() == day) {
				return dayObj;
			}
		}
		return null;
	}

	private List<Object> parseList(String json) {
		BasicJsonParser bjp = new BasicJsonParser();
		return bjp.parseList(json);
	}

	private Map<String, Object> parseMap(String json) {
		BasicJsonParser bjp = new BasicJsonParser();
		return bjp.parseMap(json);
	}
}
