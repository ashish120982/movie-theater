package com.jpmc.theater.constants;

import java.util.Arrays;
import java.util.List;

import com.jpmc.theater.service.strategy.DiscountStrategy;

public class MovieTheaterConstants {
	public static final int MOVIE_CODE_SPECIAL = 1;
	public static final List<DiscountStrategy> DISCOUNT_STRATEGIES = Arrays.asList(DiscountStrategy.discountCodeStrategy(),
			DiscountStrategy.sequenceStrategy(), DiscountStrategy.startingHourStrategy());
}
