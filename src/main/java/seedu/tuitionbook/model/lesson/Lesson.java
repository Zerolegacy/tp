package seedu.tuitionbook.model.lesson;

import static java.util.Objects.requireNonNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Objects;

/**
 * Represents a Lesson in the address book.
 * Guarantees: immutable; name and date is valid as declared
 * in {@link #isValidModuleName(String)} and {@link #isValidLessonDate(String)}
 */
public class Lesson {
    public static final String MODULE_MESSAGE_CONSTRAINT = "Lesson's module name is invalid.";
    public static final String LESSON_DATETIME_MESSAGE_CONSTRAINT =
            "Lesson's date format invalid. yyyy-MM-ddTHH:mm:ss";
    public static final String MODULE_NAME_VALIDATION_REGEX = "\\p{Alnum}+( \\p{Alnum}+)*";
    public static final DateTimeFormatter LESSON_DATETIME_FORMAT =
            DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss");
    public static final DateTimeFormatter DISPLAY_DATETIME_FORMAT =
            DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm:ss");

    private final String module;
    private final LocalDateTime date;

    /**
     * Constructs a {@code Lesson}.
     * @param module A valid module name
     * @param date A valid lesson datetime
     */
    public Lesson(String module, LocalDateTime date) {
        requireNonNull(module);
        requireNonNull(date);
        this.module = module;
        this.date = date;
    }

    public String getModule() {
        return this.module;
    }

    public String getDatetimeAsString() {
        return this.date.format(LESSON_DATETIME_FORMAT);
    }

    public static boolean isValidModuleName(String test) {
        return test.matches(MODULE_NAME_VALIDATION_REGEX);
    }

    /**
     * Returns true if a given string is a valid lesson datetime.
     */
    public static boolean isValidLessonDate(String test) {
        try {
            LESSON_DATETIME_FORMAT.withResolverStyle(ResolverStyle.STRICT).parse(test);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Lesson)) {
            return false;
        }

        Lesson otherLesson = (Lesson) other;
        return module.equals(otherLesson.module) && date.equals(otherLesson.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(module, date);
    }

    @Override
    public String toString() {
        return String.format("%s | %s", this.module, this.date.format(DISPLAY_DATETIME_FORMAT));
    }
}
