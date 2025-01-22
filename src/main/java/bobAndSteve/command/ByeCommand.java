package bobAndSteve.command;

import bobAndSteve.exception.BobAndSteveException;
import bobAndSteve.storage.Storage;
import bobAndSteve.taskList.TaskList;
import bobAndSteve.ui.Ui;

public class ByeCommand extends Command {

    public void end() {
        String bye = "Bye. Hope to see you again soon!";
        System.out.println(bye);
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws BobAndSteveException {
        this.end();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
