package com.jpmc.theater.service.strategy;

import java.math.BigDecimal;

import com.jpmc.theater.constants.MovieTheaterConstants;
import com.jpmc.theater.model.Show;

public interface DiscountStrategy {

	BigDecimal calculateDiscount(Show show);

	public static DiscountStrategy startingHourStrategy() {
		return show -> (show.getShowStartTime().getHour() >= 11 && show.getShowStartTime().getHour() < 16)
				? show.getMovie().getBaseTicketPrice().multiply(new BigDecimal(0.25))
				: BigDecimal.ZERO;
	}

	public static DiscountStrategy sequenceStrategy() {
		return show -> {
			switch (show.getSequenceOfTheDay()) {
			case 1:
				return new BigDecimal(3);
			case 2:
				return new BigDecimal(2);
			case 7:
				return BigDecimal.ONE;
			default:
				return BigDecimal.ZERO;
			}
		};
	}

	public static DiscountStrategy discountCodeStrategy() {
		return show -> (MovieTheaterConstants.MOVIE_CODE_SPECIAL == show.getMovie().getDiscountCode())
				? show.getMovie().getBaseTicketPrice().multiply(new BigDecimal(0.2))
				: BigDecimal.ZERO;
	}

}
