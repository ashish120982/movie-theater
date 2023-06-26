package com.jpmc.theater.model;

import java.math.BigDecimal;
import java.time.Duration;

import com.jpmc.theater.utils.PrintStringUtils;

import lombok.Value;

@Value
public class Movie {
	private String title;
	private Duration runningTime;
	private BigDecimal baseTicketPrice;
	private int discountCode;

	public String getMovieStringFormat() {
		return title + " " + PrintStringUtils.humanReadableFormat(runningTime);
	}

}