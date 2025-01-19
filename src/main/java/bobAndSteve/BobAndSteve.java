package bobAndSteve;

import bobAndSteve.command.ByeCommand;
import bobAndSteve.command.HelpCommand;
import bobAndSteve.exception.InvalidCommandException;
import bobAndSteve.exception.InvalidCommandFormatException;
import bobAndSteve.exception.ListIndexOutOfBoundException;
import bobAndSteve.task.Event;
import bobAndSteve.task.Todo;
import bobAndSteve.task.Deadline;

public class BobAndSteve {
    private final String name = "Bob and Steve";
    private final ByeCommand byeCommand = new ByeCommand();
    private final HelpCommand helpCommand = new HelpCommand();
    private final TaskList taskList;

    public BobAndSteve(TaskList taskList) {
        this.taskList = taskList;
    }

    public void commands(String input) throws InvalidCommandFormatException, ListIndexOutOfBoundException, InvalidCommandException {
        String[] split = input.split(" ", 2);
        String command = split[0];
        switch (command) {
            case "bye" -> {
                byeCommand.end();
            }
            case "help" -> {
                helpCommand.help();
            }
            case "list" -> this.taskList.getList();
            case "todo" -> {
                if (split.length < 2 || split[1].isEmpty()) {
                    throw new InvalidCommandFormatException("You must specify the task in the format: <task>");
                }
                this.taskList.addTask(new Todo(split[1]));
            }
            case "deadline" -> {
                if (split.length < 2) {
                    throw new InvalidCommandFormatException("You must specify the task and deadline in the format: <task> /by <deadline>");
                }
                String[] by = split[1].split("/by", 2);
                if(by.length < 2 || by[0].trim().isEmpty() || by[1].trim().isEmpty()) {
                    throw new InvalidCommandFormatException("Invalid format. Use: <task> /by <deadline>");
                }
                this.taskList.addTask(new Deadline(by[0].trim(), by[1].trim()));
            }
            case "event" -> {
                if (split.length < 2) {
                    throw new InvalidCommandFormatException("You must specify the task and deadline in the format: <task> /from <start> /to <end>");
                }
                String[] events = split[1].split("/from");
                if(events.length < 2 || events[0].trim().isEmpty() || events[1].trim().isEmpty()) {
                    throw new InvalidCommandFormatException("Invalid format. Use: <task> /from <start> /to <end>");
                }
                String[] startEnd = events[1].split("/to");
                if(startEnd.length < 2 || startEnd[0].trim().isEmpty() || startEnd[1].trim().isEmpty()) {
                    throw new InvalidCommandFormatException("Invalid format. Use: <task> /from <start> /to <end>");
                }
                this.taskList.addTask(new Event(events[0].trim(), startEnd[0].trim(), startEnd[1].trim()));
            }
            case "unmark" -> {
                if (split.length < 2) {
                    throw new InvalidCommandFormatException("You must specify the position of the task to mark.");
                }
                int pos;
                try {
                    pos = Integer.parseInt(split[1]);
                } catch (NumberFormatException e) {
                    throw new InvalidCommandFormatException("The position must be a valid integer.");
                }
                this.taskList.unmark(pos);
                System.out.println(this.taskList.getTask(pos).toString());
            }
            case "mark" -> {
                if (split.length < 2) {
                    throw new InvalidCommandFormatException("You must specify the position of the task to mark.");
                }
                int pos;
                try {
                    pos = Integer.parseInt(split[1]);
                } catch (NumberFormatException e) {
                    throw new InvalidCommandFormatException("The position must be a valid integer.");
                }
                this.taskList.mark(pos);
                System.out.println(this.taskList.getTask(pos).toString());
            }
            case "delete" -> {
                if (split.length < 2) {
                    throw new InvalidCommandFormatException("Deletes a task. Usage: delete <task number>");
                }
                int pos;
                try {
                    pos = Integer.parseInt(split[1]);
                } catch (NumberFormatException e) {
                    throw new InvalidCommandFormatException("The position must be a valid integer.");
                }
                this.taskList.deleteTask(pos);
            }
            default -> throw new InvalidCommandException("Invalid command, Enter help to view all commands");
        }
    }

    public void greeting() {
        String greeting = "Hello! I'm " + name + " \n" +
                "What can I do for you?\n";
        System.out.println(greeting);
    }

    @Override
    public String toString() {
        return name;
    }
}