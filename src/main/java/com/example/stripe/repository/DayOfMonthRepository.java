package com.example.stripe.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.stripe.model.DayOfMonth;

@Repository
public interface DayOfMonthRepository extends CrudRepository<DayOfMonth, Long> {

	@Query("SELECT * FROM day_of_month WHERE year = :year AND month = :month order by day")
    List<DayOfMonth> getWhere(@Param("year") int year, @Param("month") int month);
	
	@Query("SELECT * FROM day_of_month WHERE year = :year AND month = :month AND day = :day")
    List<DayOfMonth> getWhere(@Param("year") int year, @Param("month") int month, @Param("day") int day);
}