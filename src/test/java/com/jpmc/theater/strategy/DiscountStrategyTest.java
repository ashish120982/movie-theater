package com.jpmc.theater.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Show;


@SpringBootTest
public class DiscountStrategyTest {

    @Test
    void testMovieShowWithDiscountCode() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),new BigDecimal(12.5), 1);
        Show show = new Show(spiderMan, 5, LocalDateTime.of(LocalDate.of(2023, 6, 26), LocalTime.of(21, 0)));
        assertEquals(new BigDecimal(10).setScale(2, RoundingMode.HALF_EVEN), show.getTicketPrice());
    }
    
    @Test
    void testMovieShowHavingSequenceAsOne() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),new BigDecimal(12.5), 0);
        Show show = new Show(spiderMan, 1, LocalDateTime.of(LocalDate.of(2023, 6, 26), LocalTime.of(18, 0)));
        assertEquals(new BigDecimal(9.5).setScale(2, RoundingMode.HALF_EVEN), show.getTicketPrice());
    }
    
    @Test
    void testMovieShowHavingSequenceAsTwo() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),new BigDecimal(12.5), 0);
        Show show = new Show(spiderMan, 2, LocalDateTime.of(LocalDate.of(2023, 6, 26), LocalTime.of(18, 0)));
        assertEquals(new BigDecimal(10.5).setScale(2, RoundingMode.HALF_EVEN), show.getTicketPrice());
    }

    @Test
    void testMovieShowHavingSequenceAsSeven() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),new BigDecimal(12.5), 0);
        Show show = new Show(spiderMan, 7, LocalDateTime.of(LocalDate.of(2023, 6, 26), LocalTime.of(18, 0)));
        assertEquals(new BigDecimal(11.5).setScale(2, RoundingMode.HALF_EVEN), show.getTicketPrice());
    }
    
    @Test
    void testMovieShowWithNoDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),new BigDecimal(12.5), 0);
        Show show = new Show(spiderMan, 5, LocalDateTime.of(LocalDate.of(2023, 6, 26), LocalTime.of(18, 0)));
        assertEquals(new BigDecimal(12.5).setScale(2, RoundingMode.HALF_EVEN), show.getTicketPrice());
    }
    
    @Test
    void testMovieShowWithStartHourDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),new BigDecimal(12.5), 1);
        Show show = new Show(spiderMan, 5, LocalDateTime.of(LocalDate.of(2023, 6, 26), LocalTime.of(14, 0)));
        assertEquals(new BigDecimal(9.38).setScale(2, RoundingMode.HALF_EVEN), show.getTicketPrice());
    }
}
