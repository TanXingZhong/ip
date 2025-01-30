package bobandsteve.command;

import bobandsteve.exception.BobAndSteveException;
import bobandsteve.exception.InvalidCommandFormatException;
import bobandsteve.storage.Storage;
import bobandsteve.task.Todo;
import bobandsteve.tasklist.TaskList;
import bobandsteve.ui.Ui;

public class TodoCommand extends Command {

    private final String description;

    public TodoCommand(String input) throws InvalidCommandFormatException {
        String[] split = input.split(" ", 2);
        if (split[1].isEmpty()) {
            throw new InvalidCommandFormatException("You must specify the task in the format: <task>");
        }
        this.description = split[1].trim();
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws BobAndSteveException {
        Todo todo = new Todo(description, "[ ]");
        taskList.addTask(todo);
        storage.writeFile(taskList);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
