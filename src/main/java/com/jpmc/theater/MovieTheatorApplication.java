package com.jpmc.theater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpmc.theater.model.PrintFormat;
import com.jpmc.theater.model.Theater;
import com.jpmc.theater.service.PrintMovieSchedulesService;

@SpringBootApplication
public class MovieTheatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieTheatorApplication.class, args);
        Theater theater = new Theater();
        PrintMovieSchedulesService printMovieSchedulesService = new PrintMovieSchedulesService();
        printMovieSchedulesService.printSchedule(theater, PrintFormat.JSON);
	}

}