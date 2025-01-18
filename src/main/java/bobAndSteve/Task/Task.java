package bobAndSteve.Task;

public class Task {

    public String description;
    public Task (String description) {
        this.description = "[ ] " + description;
    }

    public void mark() {
        System.out.println("Nice! I've marked this task as done:");
        this.description = description.replace("[ ]", "[X]");
    }

    public void unmark() {
        System.out.println("OK, I've marked this task as not done yet:");
        this.description = description.replace("[X]", "[ ]");
    }

    @Override
    public String toString() {
        return description;
    }
}
