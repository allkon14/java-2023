package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public abstract class AbstractDateParser {
    private final AbstractDateParser nextParser;

    public AbstractDateParser() {
        this(null);
    }

    public AbstractDateParser(AbstractDateParser nextParser) {
        this.nextParser = nextParser;
    }

    public Optional<LocalDate> parseDate(String stringDate) {
        if (nextParser == null) {
            return Optional.empty();
        }

        return nextParser.parseDate(stringDate);
    }

}
