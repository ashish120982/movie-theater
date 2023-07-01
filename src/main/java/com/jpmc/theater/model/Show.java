package com.jpmc.theater.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Comparator;

import com.fasterxml.jackson.annotation.JsonValue;
import com.jpmc.theater.constants.MovieTheaterConstants;

import lombok.Value;

@Value
public class Show {
	private Movie movie;
	private int sequenceOfTheDay;
	private LocalDateTime showStartTime;

	@JsonValue
	public String getShowStringFormat() {
		return sequenceOfTheDay + ": " + showStartTime + " " + movie.getMovieStringFormat() + " $" + getTicketPrice();
	}

	public BigDecimal getTicketPrice() {
		BigDecimal discount = MovieTheaterConstants.DISCOUNT_STRATEGIES.stream()
				.map(d -> d.calculateDiscount(this)).max(Comparator.naturalOrder()).orElse(BigDecimal.ZERO);
		discount = discount.setScale(2, RoundingMode.HALF_EVEN);
		return movie.getBaseTicketPrice().subtract(discount);
	}
}
