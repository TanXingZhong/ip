package bobAndSteve;
import bobAndSteve.Task.Task;
import bobAndSteve.Task.Event;
import bobAndSteve.Task.Todo;
import bobAndSteve.Task.Deadline;
import java.util.ArrayList;
import java.util.List;

public class BobAndSteve {
    private final String name = "Bob and Steve";
    private final Bye bye;
    private final List<Task> tasks = new ArrayList<>();
    public BobAndSteve() {
        this.bye = new Bye();
    }

    public void commands(String input) {
        String[] split = input.split(" ", 2);
        String command = split[0];
        switch (command) {
            case "bye" -> {
                bye.end();
            }
            case "list" -> this.list();
            case "todo" -> {
                this.addTask(new Todo(split[1]));
            }
            case "deadline" -> {
                String[] by = split[1].split(" /by");
                this.addTask(new Deadline(by[0], by[1]));
            }
            case "event" -> {
                String[] events = split[1].split(" /from");
                String[] fromStart = events[1].split("/");
                this.addTask(new Event(events[0], fromStart[0], fromStart[1]));
            }
            case "unmark" ->{
                int pos = Integer.parseInt(split[1]);
                Task task = tasks.get(pos - 1);
                task.unmark();
                System.out.println(task.toString());
            }
            case "mark" -> {
                int pos = Integer.parseInt(split[1]);
                Task task = tasks.get(pos - 1);
                task.mark();
                System.out.println(task.toString());
            }
            default -> System.out.println("Unknown command");
        }
    }

    public void greeting() {
        String greeting = "Hello! I'm " + name + " \n" +
                "What can I do for you?\n";
        System.out.println(greeting);
    }

    public void list() {
        System.out.println("Here are the tasks in your list:");
        for(int i = 0; i < tasks.size(); i++) {
            int index = i + 1;
            System.out.println(index + "." + tasks.get(i));
        }
    }

    public void addTask(Task t) {
        tasks.add(t);
        System.out.println("Got it. I've added this task:");
        System.out.println(t.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    @Override
    public String toString() {
        return name;
    }
}