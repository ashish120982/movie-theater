package com.jpmc.theater.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.jpmc.theater.service.strategy.DiscountStrategy;

import lombok.Value;

@Value
public class Theater {

	private List<Show> schedules;

	public Theater() {
		DiscountStrategy strategy = new DiscountStrategy();
		Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), new BigDecimal(12.5), 1);
		Movie turningRed = new Movie("Turning Red", Duration.ofMinutes(85), new BigDecimal(11), 0);
		Movie theBatMan = new Movie("The Batman", Duration.ofMinutes(95), new BigDecimal(9), 0);
		schedules = List.of(new Show(turningRed, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0)), strategy),
				new Show(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 0)), strategy),
				new Show(theBatMan, 3, LocalDateTime.of(LocalDate.now(), LocalTime.of(12, 50)), strategy),
				new Show(turningRed, 4, LocalDateTime.of(LocalDate.now(), LocalTime.of(14, 30)), strategy),
				new Show(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.of(16, 10)), strategy),
				new Show(theBatMan, 6, LocalDateTime.of(LocalDate.now(), LocalTime.of(17, 50)), strategy),
				new Show(turningRed, 7, LocalDateTime.of(LocalDate.now(), LocalTime.of(19, 30)), strategy),
				new Show(spiderMan, 8, LocalDateTime.of(LocalDate.now(), LocalTime.of(21, 10)), strategy),
				new Show(theBatMan, 9, LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 0)), strategy));
	}
	
	public Show getShowBySequence(int sequence) {
		Show movieSchedule = null;
		try {
			movieSchedule = schedules.get(sequence - 1);
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			throw new IllegalStateException("not able to find any showing for given sequence " + sequence);
		}
		return movieSchedule;
	}

}
