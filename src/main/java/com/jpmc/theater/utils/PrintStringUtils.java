package com.jpmc.theater.utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface PrintStringUtils {

	public static String humanReadableFormat(Duration duration) {
		long hour = duration.toHours();
		long remainingMin = duration.toMinutes() - TimeUnit.HOURS.toMinutes(duration.toHours());
		return String.format("(%s hour%s %s minute%s)", hour, handlePlural(hour), remainingMin,
				handlePlural(remainingMin));
	}

	private static String handlePlural(long value) {
		return value > 1 ? "s" : "";
	}
	
	public static String convertToJson(Object object){
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(object);
        } catch (JsonProcessingException exception) {
            exception.printStackTrace();
        }
        return jsonString;
	}
}
