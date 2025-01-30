package bobandsteve.command;

import bobandsteve.exception.BobAndSteveException;
import bobandsteve.storage.Storage;
import bobandsteve.tasklist.TaskList;
import bobandsteve.ui.Ui;

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


