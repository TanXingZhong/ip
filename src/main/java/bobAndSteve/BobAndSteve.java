package bobAndSteve;

public class BobAndSteve {

    private final String name = "Bob and Steve";

    public BobAndSteve() {

    }

    public void greeting() {
        String greeting = "____________________________________________________________\n" +
                "Hello! I'm " + name + " \n" +
                "What can I do for you?\n" +
                "____________________________________________________________\n" +
                "Bye. Hope to see you again soon!\n" +
                "____________________________________________________________\n";
        System.out.println(greeting);
    }

    @Override
    public String toString() {
        return name;
    }
}