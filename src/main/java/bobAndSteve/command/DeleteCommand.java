package bobAndSteve.command;

import bobAndSteve.exception.BobAndSteveException;
import bobAndSteve.exception.InvalidCommandFormatException;
import bobAndSteve.storage.Storage;
import bobAndSteve.taskList.TaskList;
import bobAndSteve.ui.Ui;

public class DeleteCommand extends Command {

    private int pos = 0;

    public DeleteCommand(String input) throws InvalidCommandFormatException {
        String[] split = input.split(" ", 2);
        if (split.length < 2) {
            throw new InvalidCommandFormatException("Deletes a task. Usage: delete <task number>");
        }
        try {
            pos = Integer.parseInt(split[1]);
        } catch (NumberFormatException e) {
            throw new InvalidCommandFormatException("The position must be a valid integer.");
        }
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws BobAndSteveException {
        taskList.deleteTask(pos);
        storage.writeFile(taskList);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}


