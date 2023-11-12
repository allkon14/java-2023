package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public class WordDateParser extends AbstractDateParser {
    public WordDateParser() {
    }

    public WordDateParser(AbstractDateParser nextParser) {
        super(nextParser);
    }

    @Override
    public Optional<LocalDate> parseDate(String stringDate) {
        LocalDate parsedDate = switch (stringDate) {
            case "today" -> LocalDate.now();
            case "yesterday" -> LocalDate.now().minusDays(1);
            case "tomorrow" -> LocalDate.now().plusDays(1);
            default -> null;
        };

        if (parsedDate == null) {
            return super.parseDate(stringDate);
        }
        return Optional.of(parsedDate);
    }
}
