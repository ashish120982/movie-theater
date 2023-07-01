package com.jpmc.theater.model;

import java.util.List;

import lombok.Value;

@Value
public class Theater {

	private List<Show> schedules;

	public Show getShowBySequence(int sequence) {
		if (sequence < 1 || sequence > schedules.size()) {
			throw new IllegalStateException("not able to find any show for given sequence ");
		}
		return schedules.get(sequence - 1);
	}

}
