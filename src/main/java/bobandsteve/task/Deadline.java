package bobandsteve.task;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;

import bobandsteve.exception.InvalidCommandFormatException;
/**
 * Represents a deadline task in the BobAndSteve application.
 * A deadline task has a description, a status (completed or not), and a date/time by which the task should
 * be completed.
 */
public class Deadline extends Task {

    private final LocalDate by;
    private final LocalTime time;

    /**
     * Constructs a new Deadline task with the specified description, status, and deadline.
     * The deadline is represented by a date and time string in the format "YYYY-MM-DD HH:MM".
     *
     * @param description The description of the deadline task.
     * @param isDone The status of the task (completed or not).
     * @param by The deadline for the task in "YYYY-MM-DD HH:MM" format.
     * @throws InvalidCommandFormatException If the date and time format is invalid or incorrectly formatted.
     */
    public Deadline(String description, String isDone, String by) throws InvalidCommandFormatException {
        super(description, isDone);
        try {
            String[] split = by.split(" ");
            this.by = LocalDate.parse(split[0]);
            this.time = LocalTime.parse(split[1]);
        } catch (DateTimeException | ArrayIndexOutOfBoundsException error) {
            throw new InvalidCommandFormatException("Invalid date format. Expected: YYYY-MM-DD HH:MM");
        }
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + formatDate(this.by, this.time) + ")";
    }

    @Override
    public String toSaveFormat() {
        return "D | " + super.toSaveFormat() + " | " + this.by.toString() + " " + this.time.toString();
    }
}
