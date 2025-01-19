package bobAndSteve.command;

public class HelpCommand {
    public void help() {
        System.out.println("Available Commands:");
        System.out.println("-------------------");
        System.out.println("help      - Displays the list of all commands.");
        System.out.println("mark      - Marks a task as completed. Usage: mark <task number>");
        System.out.println("unmark    - Unmarks a completed task. Usage: unmark <task number>");
        System.out.println("todo      - Adds a todo. Usage: todo <task>");
        System.out.println("deadline  - Adds a deadline. Usage: deadline <task> /by <date>");
        System.out.println("event     - Adds an event. Usage: event <task> /from <start> /to <end>");
        System.out.println("list      - Displays all tasks.");
        System.out.println("delete    - Deletes a task. Usage: delete <task number>");
        System.out.println("bye       - Exits the program.");
        System.out.println("-------------------");
    }
}
