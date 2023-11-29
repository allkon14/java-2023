package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Task1 {
    public static Duration calculateAverageSessionDuration(List<String> sessions) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");

        return sessions.stream()
            .map(session -> session.split(" - "))
            .map(session -> new LocalDateTime[] {
                LocalDateTime.parse(session[0], dateTimeFormatter),
                LocalDateTime.parse(session[1], dateTimeFormatter)}
            )
            .map(session -> Duration.between(session[0], session[1]))
            .reduce(Duration.ZERO, Duration::plus)
            .dividedBy(sessions.size());
    }

    public static String formatDuration(Duration duration) {
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        return hours + "ч " + minutes + "м";
    }
}

