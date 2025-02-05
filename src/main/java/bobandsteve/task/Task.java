package bobandsteve.task;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a general task in the BobAndSteve application.
 * A task has a description, a completion status, and methods to mark/unmark it as done.
 */
public abstract class Task {

    private final String description;
    private String done;

    /**
     * Constructs a new Task with the specified description and completion status.
     *
     * @param description The description of the task.
     * @param done The status of the task (whether it's completed or not).
     */
    public Task(String description, String done) {
        this.description = description;
        this.done = done;
    }

    /**
     * Marks the task as completed by setting its status to "[X]".
     */
    public void mark() {
        this.done = "[X]";
    }

    /**
     * Marks the task as not completed by setting its status to "[ ]".
     */
    public void unmark() {
        this.done = "[ ]";
    }

    @Override
    public String toString() {
        return done + " " + description;
    }

    /**
     * Formats the given date and time into a readable string.
     *
     * @param date The date to be formatted.
     * @param time The time to be formatted.
     * @return A formatted string in the format "MMM d yyyy hh:mm a".
     */
    public String formatDate(LocalDate date, LocalTime time) {
        return date.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + " "
                + time.format(DateTimeFormatter.ofPattern("hh:mm a"));
    }

    /**
     * Returns a string representation of the task's status and description,
     * formatted for saving to a file.
     *
     * @return A string in the format "1 | task description" if the task is done,
     *         or "0 | task description" if the task is not done.
     */
    public String toSaveFormat() {
        if (done.equals("[X]")) {
            return "1 | " + this.description;
        } else {
            return "0 | " + this.description;
        }
    }
}
