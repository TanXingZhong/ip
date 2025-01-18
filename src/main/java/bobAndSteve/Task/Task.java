package bobAndSteve.Task;

import java.util.ArrayList;
import java.util.List;

public class Task {

    public String description;
    public Task (String description) {
        this.description = "[ ] " + description;
    }

    public void mark() {
        System.out.println("____________________________________________________________");
        System.out.println("Nice! I've marked this task as done:");
        this.description = description.replace("[ ]", "[X]");
        System.out.println(" " + description);
        System.out.println("____________________________________________________________");
    }

    public void unmark() {
        System.out.println("____________________________________________________________");
        System.out.println("OK, I've marked this task as not done yet:");
        this.description = description.replace("[X]", "[ ]");
        System.out.println(" " + description);
        System.out.println("____________________________________________________________");
    }

    @Override
    public String toString() {
        return description;
    }
}
