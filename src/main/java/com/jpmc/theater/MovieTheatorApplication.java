package com.jpmc.theater;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.PrintFormat;
import com.jpmc.theater.model.Show;
import com.jpmc.theater.model.Theater;
import com.jpmc.theater.service.PrintMovieSchedulesService;

@SpringBootApplication
public class MovieTheatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieTheatorApplication.class, args);
		Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), new BigDecimal(12.5), 1);
		Movie turningRed = new Movie("Turning Red", Duration.ofMinutes(85), new BigDecimal(11), 0);
		Movie theBatMan = new Movie("The Batman", Duration.ofMinutes(95), new BigDecimal(9), 0);
		List<Show> schedules = List.of(new Show(turningRed, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0))),
				new Show(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 0))),
				new Show(theBatMan, 3, LocalDateTime.of(LocalDate.now(), LocalTime.of(12, 50))),
				new Show(turningRed, 4, LocalDateTime.of(LocalDate.now(), LocalTime.of(14, 30))),
				new Show(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.of(16, 10))),
				new Show(theBatMan, 6, LocalDateTime.of(LocalDate.now(), LocalTime.of(17, 50))),
				new Show(turningRed, 7, LocalDateTime.of(LocalDate.now(), LocalTime.of(19, 30))),
				new Show(spiderMan, 8, LocalDateTime.of(LocalDate.now(), LocalTime.of(21, 10))),
				new Show(theBatMan, 9, LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 0))));
		Theater theater = new Theater(schedules);
		PrintMovieSchedulesService printMovieSchedulesService = new PrintMovieSchedulesService();
		printMovieSchedulesService.printSchedule(theater, PrintFormat.TEXT);
		printMovieSchedulesService.printSchedule(theater, PrintFormat.JSON);
	}

}