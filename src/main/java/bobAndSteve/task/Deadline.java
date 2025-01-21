package bobAndSteve.task;

public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String isDone, String by) {
        super(description, isDone);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    @Override
    public String toSaveFormat() {
        return "D" +  " | " + super.toSaveFormat() + " | " + this.by;
    }
}
