package com.jpmc.theater.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TheaterTest {

	private Theater theater;

	@BeforeEach
	void init() {
		Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), new BigDecimal(12.5), 1);
		Movie turningRed = new Movie("Turning Red", Duration.ofMinutes(85), new BigDecimal(11), 0);
		Movie theBatMan = new Movie("The Batman", Duration.ofMinutes(95), new BigDecimal(9), 0);
		List<Show> schedules = List.of(
				new Show(turningRed, 1, LocalDateTime.of(LocalDate.of(2023, 6, 26), LocalTime.of(9, 0))),
				new Show(spiderMan, 2, LocalDateTime.of(LocalDate.of(2023, 6, 26), LocalTime.of(11, 0))),
				new Show(theBatMan, 3, LocalDateTime.of(LocalDate.of(2023, 6, 26), LocalTime.of(12, 50))),
				new Show(turningRed, 4, LocalDateTime.of(LocalDate.of(2023, 6, 26), LocalTime.of(14, 30))),
				new Show(spiderMan, 5, LocalDateTime.of(LocalDate.of(2023, 6, 26), LocalTime.of(16, 10))),
				new Show(theBatMan, 6, LocalDateTime.of(LocalDate.of(2023, 6, 26), LocalTime.of(17, 50))),
				new Show(turningRed, 7, LocalDateTime.of(LocalDate.of(2023, 6, 26), LocalTime.of(19, 30))),
				new Show(spiderMan, 8, LocalDateTime.of(LocalDate.of(2023, 6, 26), LocalTime.of(21, 10))),
				new Show(theBatMan, 9, LocalDateTime.of(LocalDate.of(2023, 6, 26), LocalTime.of(23, 0))));
		theater = new Theater(schedules);
	}

	@Test
	void testGetShowBySequenceWhenSequenceIsOne() {
		assertEquals("1: 2023-06-26T09:00 Turning Red (1 hour 25 minutes) $8.00",
				theater.getShowBySequence(1).getShowStringFormat());
	}

	@Test
	void testGetShowBySequenceWhenSequenceIsZero() {
		IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> theater.getShowBySequence(0),
				"Expected doThing() to throw, but it didn't");
		assertThat(thrown.getMessage().contains("not able to find any show"));
	}

	@Test
	void testGetShowBySequenceWhenSequenceIsGreaterThanSize() {
		IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> theater.getShowBySequence(10),
				"Expected doThing() to throw, but it didn't");
		assertThat(thrown.getMessage().contains("not able to find any show"));
	}

}
