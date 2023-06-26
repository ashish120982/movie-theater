package com.jpmc.theater.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpmc.theater.model.Theater;

@SpringBootTest
public class TestPrintMovieSchedulesService {

    @Test
    void printMovieSchedule() {
    	PrintMovieSchedulesService printMovieSchedulesService = new PrintMovieSchedulesService();
        Theater theater = new Theater();
        printMovieSchedulesService.printSchedule(theater);
    }
}
