package com.jpmc.theater.model;

import com.jpmc.theater.utils.PrintStringUtils;

public enum PrintFormat {
	JSON {
		public void printSchedules(Theater theater) {
			System.out.println(PrintStringUtils.convertToJson(theater));
		}
	},TEXT {
		public void printSchedules(Theater theater) {
			theater.getSchedules()
			.forEach(s -> System.out.println(s.getSequenceOfTheDay() + ": " + s.getShowStartTime() + " "
					+ s.getMovie().getTitle() + " " + PrintStringUtils.humanReadableFormat(s.getMovie().getRunningTime()) + " $"
					+ s.getMovie().getBaseTicketPrice()));
		}
	};

	public abstract void printSchedules(Theater theater);
}
