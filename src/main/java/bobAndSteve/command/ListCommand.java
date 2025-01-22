package bobAndSteve.command;

import bobAndSteve.TaskList;
import bobAndSteve.Ui;
import bobAndSteve.exception.BobAndSteveException;
import storage.Storage;

public class ListCommand extends Command {

    @Override
    public void execute(TaskList taskList, Ui ui, Storage fileHandler) throws BobAndSteveException {
        taskList.getList();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}


