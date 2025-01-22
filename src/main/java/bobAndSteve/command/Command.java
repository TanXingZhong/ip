package bobAndSteve.command;

import bobAndSteve.TaskList;
import bobAndSteve.Ui;
import bobAndSteve.exception.BobAndSteveException;
import storage.Storage;

public abstract class Command {

    public abstract void execute(TaskList taskList, Ui ui, Storage fileHandler) throws BobAndSteveException;

    public abstract boolean isExit();
}
