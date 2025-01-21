package bobAndSteve.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class Task {

    public String description;
    public String isDone;

    public Task (String description, String isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    public void mark() {
        System.out.println("Nice! I've marked this task as done:");
        this.isDone = "[X]";
    }

    public void unmark() {
        System.out.println("OK, I've marked this task as not done yet:");
        this.isDone = "[ ]";
    }

    @Override
    public String toString() {
        return isDone + " " + description;
    }

    public String formatDate(LocalDate date, LocalTime time) {
        return date.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + " " + time.format(DateTimeFormatter.ofPattern("hh:mm a"));
    }

    public String toSaveFormat() {
        if(isDone.equals("[X]")) {
            return "1 | " + this.description;
        } else {
            return "0 | " + this.description;
        }
    }
}
