package bobAndSteve.command;

import bobAndSteve.TaskList;
import bobAndSteve.Ui;
import bobAndSteve.exception.BobAndSteveException;
import bobAndSteve.exception.InvalidCommandFormatException;
import bobAndSteve.task.Deadline;
import storage.Storage;

public class DeadlineCommand extends Command {

    private final String description;
    private final String by;

    public DeadlineCommand(String input) throws InvalidCommandFormatException {
        String[] split = input.split(" ", 2);
        if (split[1].isEmpty()) {
            throw new InvalidCommandFormatException("You must specify the task and deadline in the format: <task> /by <deadline>");
        }
        String[] by = split[1].split("/by", 2);
        if (by.length < 2 || by[0].trim().isEmpty() || by[1].trim().isEmpty()) {
            throw new InvalidCommandFormatException("Invalid format. Use: <task> /by <deadline>");
        }
        this.description = by[0].trim();
        this.by = by[1].trim();
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage fileHandler) throws BobAndSteveException {
        Deadline deadline = new Deadline(description, "[ ]", by);
        taskList.addTask(deadline);
        fileHandler.writeFile(taskList);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
