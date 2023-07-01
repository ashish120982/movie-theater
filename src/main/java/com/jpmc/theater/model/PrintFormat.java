package com.jpmc.theater.model;

import com.jpmc.theater.utils.PrintStringUtils;

public enum PrintFormat {
	JSON {
		public String printSchedules(Theater theater) {
			return PrintStringUtils.convertToJson(theater);
		}
	},
	TEXT {
		public String printSchedules(Theater theater) {
			StringBuffer sb = new StringBuffer();
			theater.getSchedules().forEach(s -> {
				sb.append(s.getSequenceOfTheDay() + ": " + s.getShowStartTime() + " " + s.getMovie().getTitle() + " "
						+ PrintStringUtils.humanReadableFormat(s.getMovie().getRunningTime()) + " $"
						+ s.getTicketPrice());
				sb.append(System.getProperty("line.separator"));
			});
			return sb.toString();
		}
	};

	public abstract String printSchedules(Theater theater);
}
