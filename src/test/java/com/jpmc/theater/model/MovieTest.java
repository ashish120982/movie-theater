package com.jpmc.theater.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpmc.theater.constants.MovieTheaterConstants;
@SpringBootTest
public class MovieTest {
	
	@Test
	void testCreateMovie() {
		Movie endGame = new Movie("Avengers: End Game", Duration.ofMinutes(180),new BigDecimal(38.5), 1);
		assertEquals("Avengers: End Game", endGame.getTitle());
		assertEquals(180l, endGame.getRunningTime().toMinutes());
		assertEquals(new BigDecimal(38.5), endGame.getBaseTicketPrice());
		assertEquals(MovieTheaterConstants.MOVIE_CODE_SPECIAL, endGame.getDiscountCode());
		assertEquals("Avengers: End Game (3 hours 0 minute)", endGame.getMovieStringFormat());
	}
	
}
