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

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws BobAndSteveException {
        taskList.getList();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}


