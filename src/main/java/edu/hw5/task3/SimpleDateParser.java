package edu.hw5.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class SimpleDateParser extends AbstractDateParser {

    private static final List<DateTimeFormatter> SUPPORTED_PATTERNS = List.of(
        DateTimeFormatter.ofPattern("yyyy-MM-dd"),
        DateTimeFormatter.ofPattern("yyyy-dd-MM"),
        DateTimeFormatter.ofPattern("d/M/yyyy"),
        DateTimeFormatter.ofPattern("d/M/yy"),
        DateTimeFormatter.ofPattern("dd/MM/yyyy"),
        DateTimeFormatter.ofPattern("dd/MM/yy")
    );

    public SimpleDateParser() {

    }

    public SimpleDateParser(AbstractDateParser nextParser) {
        super(nextParser);
    }

    @Override
    public Optional<LocalDate> parseDate(String stringDate) {
        for (DateTimeFormatter pattern : SUPPORTED_PATTERNS) {
            try {
                LocalDate date = LocalDate.parse(stringDate, pattern);
                return Optional.of(date);
            } catch (Exception ignored) {
            }
        }
        return super.parseDate(stringDate);
    }
}
