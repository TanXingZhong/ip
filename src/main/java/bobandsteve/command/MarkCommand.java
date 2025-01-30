package bobandsteve.command;

import bobandsteve.exception.BobAndSteveException;
import bobandsteve.exception.InvalidCommandFormatException;
import bobandsteve.storage.Storage;
import bobandsteve.tasklist.TaskList;
import bobandsteve.ui.Ui;

public class MarkCommand extends Command {

    private int pos = 0;

    public MarkCommand(String input) throws InvalidCommandFormatException {
        String[] split = input.split(" ", 2);
        if (split.length < 2) {
            throw new InvalidCommandFormatException("You must specify the position of the task to mark.");
        }
        try {
            pos = Integer.parseInt(split[1]);
        } catch (NumberFormatException e) {
            throw new InvalidCommandFormatException("The position must be a valid integer.");
        }
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws BobAndSteveException {
        taskList.mark(pos);
        storage.writeFile(taskList);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}


