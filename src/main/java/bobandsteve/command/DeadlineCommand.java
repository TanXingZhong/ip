package bobandsteve.command;

import bobandsteve.exception.BobAndSteveException;
import bobandsteve.exception.InvalidCommandFormatException;
import bobandsteve.storage.Storage;
import bobandsteve.task.Deadline;
import bobandsteve.tasklist.TaskList;
import bobandsteve.ui.Ui;

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
    public void execute(TaskList taskList, Ui ui, Storage storage) throws BobAndSteveException {
        Deadline deadline = new Deadline(description, "[ ]", by);
        taskList.addTask(deadline);
        storage.writeFile(taskList);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
