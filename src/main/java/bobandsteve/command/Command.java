package bobandsteve.command;

import bobandsteve.exception.BobAndSteveException;
import bobandsteve.storage.Storage;
import bobandsteve.tasklist.TaskList;
import bobandsteve.ui.Ui;

public abstract class Command {

    public abstract void execute(TaskList taskList, Ui ui, Storage storage) throws BobAndSteveException;

    public abstract boolean isExit();
}
