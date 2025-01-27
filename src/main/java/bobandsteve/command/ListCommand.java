package bobandsteve.command;

import bobandsteve.exception.BobAndSteveException;
import bobandsteve.storage.Storage;
import bobandsteve.tasklist.TaskList;
import bobandsteve.ui.Ui;

/**
 * Command to display the list of all tasks in the task list.
 * This command retrieves and displays all the tasks currently stored.
 */
public class ListCommand extends Command {

    private String output;

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws BobAndSteveException {
        output = taskList.getList();
        ui.printOutput(output);
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public String getString() {
        return output;
    }
}


