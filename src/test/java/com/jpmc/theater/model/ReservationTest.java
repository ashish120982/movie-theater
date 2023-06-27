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
public class ReservationTest {

	@Test
	void testCreateReservation() {
		Show show = new Show(new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), new BigDecimal(12.5), 1), 1,
				LocalDateTime.of(LocalDate.of(2023, 6, 26), LocalTime.of(18, 0)));
		Reservation reservation = new Reservation("Customer1001", show, 3);
		assertEquals("Customer1001", reservation.getCustomerId());
		assertEquals(3, reservation.getAudienceCount());
		assertEquals("1: 2023-06-26T18:00 Spider-Man: No Way Home (1 hour 30 minutes) $9.50", 
				reservation.getShow().getShowStringFormat());
		assertEquals(new BigDecimal(28.5).setScale(2, RoundingMode.HALF_EVEN), reservation.getAmount());
	}

}
