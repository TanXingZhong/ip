package bobAndSteve.command;

import bobAndSteve.exception.BobAndSteveException;
import bobAndSteve.exception.InvalidCommandFormatException;
import bobAndSteve.storage.Storage;
import bobAndSteve.task.Todo;
import bobAndSteve.taskList.TaskList;
import bobAndSteve.ui.Ui;

public class TodoCommand extends Command {

    private final String description;

    public TodoCommand(String input) throws InvalidCommandFormatException {
        try {
            String[] split = input.split(" ", 2);
            if (split[1].isEmpty()) {
                throw new InvalidCommandFormatException("You must specify the task in the format: <task>");
            }
            this.description = split[1].trim();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidCommandFormatException("You must specify the task in the format: <task>");
        }
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
