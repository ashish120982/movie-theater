package com.jpmc.theater;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpmc.theater.model.Reservation;
import com.jpmc.theater.model.Theater;

@SpringBootTest
public class TheaterTests {
    @Test
    void totalFeeForCustomer() {
        Theater theater = new Theater();
        Reservation reservation = new Reservation("Customer1001", theater.getShowBySequence(2), 4);
        assertEquals(reservation.totalFee(), 50);
    }

}
