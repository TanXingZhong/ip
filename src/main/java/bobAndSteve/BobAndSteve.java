package bobAndSteve;
import java.util.ArrayList;
import java.util.List;

public class BobAndSteve {
    private final String name = "Bob and Steve";
    private List<String> lst = new ArrayList<>();

    public BobAndSteve() {

    }

    public void commands(String command) {
        if (command.equals("bye")) {
            bye();
            System.exit(0);
        } else if (command.equals("list")) {
            list();
        } else if (command.equals("blah")) {
            System.out.println("   ____________________________________________________________\n" +
                    "     blah\n" +
                    "    ____________________________________________________________");
        } else {
            addList(command);
        }
    }

    public void greeting() {
        String greeting = "____________________________________________________________\n" +
                "Hello! I'm " + name + " \n" +
                "What can I do for you?\n" +
                "____________________________________________________________\n";
        System.out.println(greeting);
    }

    public void bye() {
        String bye = "Bye. Hope to see you again soon!\n" +
                "____________________________________________________________\n";
        System.out.println(bye);
    }

    public void addList(String task) {
        lst.add(task);
        System.out.println("added: " + task);
    }

    public void list() {
        for (int i = 0; i < lst.size(); i++) {
            System.out.println(i + 1 + ". " + lst.get(i));
        }
    }

    @Override
    public String toString() {
        return name;
    }
}