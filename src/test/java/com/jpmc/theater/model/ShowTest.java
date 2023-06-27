package com.jpmc.theater.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShowTest {

	@Test
	void testCreateShow() {
		Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),new BigDecimal(12.5), 1);
        Show show = new Show(spiderMan, 5, LocalDateTime.of(LocalDate.of(2023, 6, 26), LocalTime.of(18, 0)));
		assertEquals(spiderMan, show.getMovie());
		assertEquals(5, show.getSequenceOfTheDay());
		assertEquals(LocalDateTime.of(LocalDate.of(2023, 6, 26), LocalTime.of(18, 0)), show.getShowStartTime());
		assertEquals("5: 2023-06-26T18:00 Spider-Man: No Way Home (1 hour 30 minutes) $10.00",show.getShowStringFormat());
		assertEquals(new BigDecimal(10).setScale(2, RoundingMode.HALF_EVEN), show.getTicketPrice());
	}
    
}
