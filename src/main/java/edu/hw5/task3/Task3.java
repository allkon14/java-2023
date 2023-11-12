package edu.hw5.task3;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public final class Task3 {
    private static final AbstractDateParser CHAIN;

    static {
        try {
            CHAIN = buildChain();
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    private Task3() {
    }

    public static Optional<LocalDate> parseDate(String string) {
        return string != null ? CHAIN.parseDate(string) : Optional.empty();
    }

    private static AbstractDateParser buildChain() throws ReflectiveOperationException {
        AbstractDateParser finalParser = null;

        List<Class<? extends AbstractDateParser>> parsers = List.of(
            WordDateParser.class, SimpleDateParser.class, SentenceDateParser.class
        );

        for (Class<? extends AbstractDateParser> parser : parsers) {
            finalParser = parser.getConstructor(AbstractDateParser.class).newInstance(finalParser);
        }

        return finalParser;
    }

}
