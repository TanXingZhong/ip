package bobAndSteve;
import java.util.ArrayList;
import java.util.List;

public class BobAndSteve {
    private final String name = "Bob and Steve";
    private final Task task;
    private final Bye bye;

    public BobAndSteve() {
        this.bye = new Bye();
        this.task = new Task();
    }

    public void commands(String input) {
        String[] split = input.split(" ");
        String command = split[0];
        switch (command) {
            case "bye" -> {
                bye.end();
            }
            case "list" -> task.list();
            case "mark" -> {
                int pos = Integer.parseInt(split[1]);
                task.mark(pos);
            }
            case "unmark" ->{
                int pos = Integer.parseInt(split[1]);
                task.unmark(pos);
            }
            default -> task.addList(input);
        }
    }

    public void greeting() {
        String greeting = "____________________________________________________________\n" +
                "Hello! I'm " + name + " \n" +
                "What can I do for you?\n" +
                "____________________________________________________________\n";
        System.out.println(greeting);
    }


    @Override
    public String toString() {
        return name;
    }
}