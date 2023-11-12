package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("MultipleStringLiterals")
public class SentenceDateParser extends AbstractDateParser {
    public static final Pattern PATTERN = Pattern.compile(
        "^(?<count>\\d+) (?<dateType>day|week|month|year)(s)? (?<when>ago|after)$");

    public SentenceDateParser() {
    }

    public SentenceDateParser(AbstractDateParser nextParser) {
        super(nextParser);
    }

    @Override
    public Optional<LocalDate> parseDate(String stringDate) {
        Matcher matcher = PATTERN.matcher(stringDate);

        if (matcher.find()) {
            int count = Integer.parseInt(matcher.group("count"));
            String dateType = matcher.group("dateType");
            String when = matcher.group("when");

            dateType = dateType.endsWith("s") ? dateType.substring(0, dateType.length() - 2) : dateType;

            LocalDate parsedDate = null;

            if (Objects.equals(when, "after")) {
                parsedDate = switch (dateType) {
                    case "day" -> LocalDate.now().plusDays(count);
                    case "week" -> LocalDate.now().plusWeeks(count);
                    case "month" -> LocalDate.now().plusMonths(count);
                    case "year" -> LocalDate.now().plusYears(count);
                    default -> null;
                };
            } else if (Objects.equals(when, "ago")) {
                parsedDate = switch (dateType) {
                    case "day" -> LocalDate.now().minusDays(count);
                    case "week" -> LocalDate.now().minusWeeks(count);
                    case "month" -> LocalDate.now().minusMonths(count);
                    case "year" -> LocalDate.now().minusYears(count);
                    default -> null;
                };
            }
            if (parsedDate == null) {
                return super.parseDate(stringDate);
            }
            return Optional.of(parsedDate);
        }

        return super.parseDate(stringDate);
    }
}
