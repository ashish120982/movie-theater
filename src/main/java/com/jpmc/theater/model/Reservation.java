package com.jpmc.theater.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.Value;

@Value
public class Reservation {
	private String customerId;
	private Show show;
	private int audienceCount;

	public BigDecimal getAmount() {
		return show.getTicketPrice().multiply(new BigDecimal(audienceCount))
				.setScale(2, RoundingMode.HALF_EVEN);
	}
}