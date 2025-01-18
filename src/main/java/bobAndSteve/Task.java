package bobAndSteve;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private final List<String> tasks;

    public Task () {
        this.tasks = new ArrayList<>();
    }

    public void mark(int input) {
        System.out.println("____________________________________________________________");
        int pos = input - 1;
        if (pos > tasks.size()) {
            System.out.println("Task does not exist");
        } else if (pos < 0) {
            System.out.println("Please key in a number bigger or equal to 1");
        } else {
            System.out.println("Nice! I've marked this task as done:");
            String task = tasks.get(pos).replace("[ ]", "[X]");
            tasks.set(pos, task);
            System.out.println(" " + tasks.get(pos));
        }
        System.out.println("____________________________________________________________");
    }

    public void unmark(int input) {
        System.out.println("____________________________________________________________");
        int pos = input - 1;
        if (pos > tasks.size()) {
            System.out.println("Task does not exist");
        } else if (pos < 0) {
            System.out.println("Please key in a number bigger or equal to 1");
        } else {
            System.out.println("OK, I've marked this task as not done yet:");
            String task = tasks.get(pos).replace("[X]", "[ ]");
            tasks.set(pos, task);
            System.out.println(" " + tasks.get(pos));
        }
        System.out.println("____________________________________________________________");
    }

    public void addList(String task) {
        System.out.println("____________________________________________________________");
        tasks.add("[ ] " + task);
        System.out.println("added: " + task);
        System.out.println("____________________________________________________________");
    }

    public void list() {
        System.out.println("____________________________________________________________");
        System.out.println("Here are the tasks in your list:");
        for(int i = 0; i < tasks.size(); i++) {
            System.out.println(i + 1 + ". " + tasks.get(i));
        }
        System.out.println("____________________________________________________________");
    }
}
