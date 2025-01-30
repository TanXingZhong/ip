package bobandsteve.task;

import bobandsteve.exception.InvalidCommandFormatException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Deadline extends Task {

    private final LocalDate by;
    private final LocalTime time;

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
        return "D" + " | " + super.toSaveFormat() + " | " + this.by.toString() + " " + this.time.toString();
    }
}
