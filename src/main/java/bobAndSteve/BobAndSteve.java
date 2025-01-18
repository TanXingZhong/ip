package bobAndSteve;

public class BobAndSteve {
    private final String name = "Bob and Steve";

    public BobAndSteve() {

    }

    public void commands(String command) {
        if(command.equals("bye")) {
            bye();
            System.exit(0);
        } else if(command.equals("list")) {
            System.out.println("   ____________________________________________________________\n" +
                    "     list\n" +
                    "    ____________________________________________________________");
        } else if(command.equals("blah")) {
            System.out.println("   ____________________________________________________________\n" +
                    "     blah\n" +
                    "    ____________________________________________________________");
        } else {
            System.out.println("Unknown command");
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
        String bye ="Bye. Hope to see you again soon!\n" +
                    "____________________________________________________________\n";
        System.out.println(bye);
    }

    @Override
    public String toString() {
        return name;
    }
}