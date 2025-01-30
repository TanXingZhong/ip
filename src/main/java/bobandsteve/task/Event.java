package bobandsteve.task;

import bobandsteve.exception.InvalidCommandFormatException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {

    private final LocalDate startDate;
    private final LocalDate endDate;
    private final LocalTime startTime;
    private final LocalTime endTime;

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
                throw new InvalidCommandFormatException("Start date (" + startDate + " " + startTime + ") has to be before end date (" + endDate + " " + endTime + ")");
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
        return "E" + " | " + super.toSaveFormat() + " | " + this.startDate.toString() + " " + this.startTime.toString() + " | " + this.endDate.toString() + " " + this.endTime.toString();
    }
}
