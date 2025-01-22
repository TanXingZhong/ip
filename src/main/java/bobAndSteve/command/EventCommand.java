package bobAndSteve.command;

import bobAndSteve.exception.BobAndSteveException;
import bobAndSteve.exception.InvalidCommandFormatException;
import bobAndSteve.storage.Storage;
import bobAndSteve.task.Event;
import bobAndSteve.taskList.TaskList;
import bobAndSteve.ui.Ui;

/**
 * Command to create a new event task with a description, start time, and end time.
 * This command parses the user input to extract the task description, start time, and
 * end time, then creates an Event task and adds it to the task list.
 */
public class EventCommand extends Command {

    private final String description;  // The description of the event.
    private final String start;        // The start time of the event.
    private final String end;          // The end time of the event.

    /**
     * Constructs a new EventCommand by parsing the user input.
     * The input is expected to follow the format: "<task> /from <start> /to <end>".
     * If the format is invalid, an exception is thrown.
     *
     * @param input The user input string to be parsed.
     * @throws InvalidCommandFormatException If the input format is incorrect.
     */
    public EventCommand(String input) throws InvalidCommandFormatException {
        try {
            String[] split = input.split(" ", 2);
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
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidCommandFormatException("You must " +
                    "specify the task and deadline in the format: <task> /from <start> /to <end>");
        }

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
