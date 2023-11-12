package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static List<LocalDate> findFridaysTheThirteenth(int year) {
        List<LocalDate> fridaysTheThirteenth = new ArrayList<>();

        for (int month = 1; month <= 12; month++) {
            LocalDate date = LocalDate.of(year, month, 13);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                fridaysTheThirteenth.add(date);
            }
        }
        return fridaysTheThirteenth;
    }

    public static LocalDate findNextFridayTheThirteenth(LocalDate date) {
        LocalDate newDate = date;

        if (date.getDayOfMonth() > 13) {
            newDate = date.plusMonths(1);
        }
        newDate = newDate.withDayOfMonth(13);

        while (newDate.getDayOfWeek() != DayOfWeek.FRIDAY) {
            newDate = newDate.plusMonths(1);
        }
        return newDate;
    }

    public static void main(String[] args) {
        int year = 1925;
        List<LocalDate> fridaysTheThirteenth = findFridaysTheThirteenth(year);
        System.out.println(fridaysTheThirteenth);

        LocalDate date = LocalDate.of(2023, 2, 13);
        LocalDate nextFridayTheThirteenth = findNextFridayTheThirteenth(date);
        System.out.println(nextFridayTheThirteenth);

        year = 2023;
        fridaysTheThirteenth = findFridaysTheThirteenth(year);
        System.out.println(fridaysTheThirteenth);
    }
}
