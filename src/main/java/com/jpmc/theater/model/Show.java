package com.jpmc.theater.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonValue;
import com.jpmc.theater.service.strategy.DiscountStrategy;

import lombok.Value;

@Value
public class Show {
	private Movie movie;
	private int sequenceOfTheDay;
	private LocalDateTime showStartTime;
	private DiscountStrategy discountStrategy;

	@JsonValue
	public String getShow() {
		return sequenceOfTheDay + ": " + showStartTime + " " + movie.getMovieStringFormat() + " $" + movie.getBaseTicketPrice();
	}

	public BigDecimal getTicketPrice() {
		return movie.getBaseTicketPrice().subtract(discountStrategy.getDiscount(this));
	}
}
