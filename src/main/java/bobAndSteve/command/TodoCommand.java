package bobAndSteve.command;

import bobAndSteve.TaskList;
import bobAndSteve.Ui;
import bobAndSteve.exception.BobAndSteveException;
import bobAndSteve.exception.InvalidCommandFormatException;
import bobAndSteve.task.Todo;
import storage.Storage;

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
    public void execute(TaskList taskList, Ui ui, Storage fileHandler) throws BobAndSteveException {
        Todo todo = new Todo(description, "[ ]");
        taskList.addTask(todo);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
