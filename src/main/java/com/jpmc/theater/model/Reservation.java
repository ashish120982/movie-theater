package com.jpmc.theater.model;

import java.math.BigDecimal;

import lombok.Value;

@Value
public class Reservation {
    private String customerId;
    private Show show;
    private int audienceCount;

    public BigDecimal totalFee() {
        return show.getTicketPrice().multiply(new BigDecimal(audienceCount));
    }
}