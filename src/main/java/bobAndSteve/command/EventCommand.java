package bobAndSteve.command;

import bobAndSteve.exception.BobAndSteveException;
import bobAndSteve.exception.InvalidCommandFormatException;
import bobAndSteve.storage.Storage;
import bobAndSteve.task.Event;
import bobAndSteve.taskList.TaskList;
import bobAndSteve.ui.Ui;

public class EventCommand extends Command {

    private final String description;
    private final String start;
    private final String end;

    public EventCommand(String input) throws InvalidCommandFormatException {
        String[] split = input.split(" ", 2);
        if (split[0].isEmpty()) {
            throw new InvalidCommandFormatException("You must " +
                    "specify the task and deadline in the format: <task> /from <start> /to <end>");
        }
        String[] events = split[1].split("/from", 2);
        if (events.length < 2 || events[0].trim().isEmpty() || events[1].trim().isEmpty()) {
            throw new InvalidCommandFormatException("Invalid format. Use: <task> /from <start> /to <end>");
        }
        String[] startEnd = events[1].split("/to");
        if (startEnd.length < 2 || startEnd[0].trim().isEmpty() || startEnd[1].trim().isEmpty()) {
            throw new InvalidCommandFormatException("Invalid format. Use: <task> /from <start> /to <end>");
        }
        this.description = events[0].trim();
        this.start = startEnd[0].trim();
        this.end = startEnd[1].trim();
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws BobAndSteveException {
        Event event = new Event(description, "[ ]", start, end);
        taskList.addTask(event);
        storage.writeFile(taskList);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
