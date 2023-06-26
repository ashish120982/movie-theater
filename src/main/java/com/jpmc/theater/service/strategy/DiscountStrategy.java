package com.jpmc.theater.service.strategy;

import java.math.BigDecimal;

import com.jpmc.theater.constants.MovieTheaterConstants;
import com.jpmc.theater.model.Show;

public class DiscountStrategy {
    
	public BigDecimal getDiscount(Show show) {

        BigDecimal startHourDiscount = calculateDiscountByStartHour(show); // 25% discount based on start hour
        BigDecimal specialDiscount = calculateDiscountByDiscountCode(show); // 20% discount for special movie
        BigDecimal sequenceDiscount = calculateSequenceDiscount(show);

        // biggest discount wins
        return  getLargestDiscountValue(startHourDiscount, specialDiscount, sequenceDiscount);  
    }

	private BigDecimal getLargestDiscountValue(BigDecimal value1, BigDecimal value2, BigDecimal value3) {
		BigDecimal largerValue = (value1.compareTo(value2) > 0) ? value1 : value2;
		return (largerValue.compareTo(value3) > 0) ? largerValue : value3;
	}

	private BigDecimal calculateDiscountByStartHour(Show show) {
		BigDecimal startHourDiscount = BigDecimal.ZERO;
		int showStartHour = show.getShowStartTime().getHour();
		if (showStartHour >= 11 && showStartHour < 16) {
			startHourDiscount = show.getMovie().getBaseTicketPrice().multiply(new BigDecimal(0.25));
        }
		return startHourDiscount;
	}
	
	private BigDecimal calculateDiscountByDiscountCode(Show show) {
		BigDecimal specialDiscount = BigDecimal.ZERO;
        if (MovieTheaterConstants.MOVIE_CODE_SPECIAL == show.getMovie().getDiscountCode()) {
            specialDiscount = show.getMovie().getBaseTicketPrice().multiply(new BigDecimal(0.2)); 
        } 
		return specialDiscount;
	}

	private BigDecimal calculateSequenceDiscount(Show show) {
		BigDecimal sequenceDiscount = BigDecimal.ZERO;
        switch (show.getSequenceOfTheDay()) {
	        case 1 : sequenceDiscount = new BigDecimal(3); break;
	        case 2 : sequenceDiscount = new BigDecimal(2); break;
	        case 7 : sequenceDiscount =  BigDecimal.ONE; break;
	        default : return BigDecimal.ZERO;
        }
		return sequenceDiscount;
	}

}
