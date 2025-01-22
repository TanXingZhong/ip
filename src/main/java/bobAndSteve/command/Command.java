package bobAndSteve.command;

import bobAndSteve.exception.BobAndSteveException;
import bobAndSteve.storage.Storage;
import bobAndSteve.taskList.TaskList;
import bobAndSteve.ui.Ui;

public abstract class Command {

    public abstract void execute(TaskList taskList, Ui ui, Storage storage) throws BobAndSteveException;

    public abstract boolean isExit();
}
