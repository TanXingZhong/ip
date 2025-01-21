package bobAndSteve.task;

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

    public String toSaveFormat() {
        if(isDone.equals("[X]")) {
            return "1 | " + this.description;
        } else {
            return "0 | " + this.description;
        }
    }
}
