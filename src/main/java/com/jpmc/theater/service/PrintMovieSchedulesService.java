package com.jpmc.theater.service;

import java.time.LocalDate;

import com.jpmc.theater.model.PrintFormat;
import com.jpmc.theater.model.Theater;

public class PrintMovieSchedulesService {

	public void printSchedule(Theater theater, PrintFormat format) {
		System.out.println(LocalDate.now());
		System.out.println("===================================================");
		format.printSchedules(theater);
		System.out.println("===================================================");
	}

}
