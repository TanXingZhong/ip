package bobandsteve.task;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import bobandsteve.exception.InvalidCommandFormatException;
/**
 * Represents an event task in the BobAndSteve application.
 * An event task has a description, a status (completed or not), a start date/time, and an end date/time.
 */
public class Event extends Task {

    private final LocalDate startDate;
    private final LocalDate endDate;
    private final LocalTime startTime;
    private final LocalTime endTime;

    /**
     * Constructs a new Event task with the specified description, status, start, and end times.
     * The start and end times are represented by date and time strings in the format "YYYY-MM-DD HH:MM".
     *
     * @param description The description of the event task.
     * @param isDone The status of the task (completed or not).
     * @param start The start time of the event in "YYYY-MM-DD HH:MM" format.
     * @param end The end time of the event in "YYYY-MM-DD HH:MM" format.
     * @throws InvalidCommandFormatException If the date time format invalid or start time is after the end time.
     */
    public Event(String description, String isDone, String start, String end) throws InvalidCommandFormatException {
        super(description, isDone);
        try {
            String[] startSplit = start.split(" ");
            String[] endSplit = end.split(" ");
            this.startDate = LocalDate.parse(startSplit[0]);
            this.startTime = LocalTime.parse(startSplit[1]);
            this.endDate = LocalDate.parse(endSplit[0]);
            this.endTime = LocalTime.parse(endSplit[1]);
            if (startDate.isAfter(endDate) || startTime.isAfter(endTime)) {
                throw new InvalidCommandFormatException("Start date (" + startDate + " " + startTime + ")"
                        + " has to be before end date (" + endDate + " " + endTime + ")");
            }
        } catch (DateTimeException | ArrayIndexOutOfBoundsException error) {
            throw new InvalidCommandFormatException("Invalid date format. Expected: YYYY-MM-DD HH:MM");
        }
    }

    @Override
    public String toString() {
        if (startDate.isEqual(endDate)) {
            return "[E]" + super.toString() + " (at: " + formatDate(startDate, startTime) + " - "
                    + endTime.format(DateTimeFormatter.ofPattern("hh:mm a")) + ")";
        } else {
            return "[E]" + super.toString() + " (from: " + formatDate(startDate, startTime)
                    + " to: " + formatDate(endDate, endTime) + ")";
        }
    }


    @Override
    public String toSaveFormat() {
        return "E" + " | " + super.toSaveFormat() + " | " + this.startDate.toString() + " "
                + this.startTime.toString() + " | " + this.endDate.toString() + " " + this.endTime.toString();
    }
}
