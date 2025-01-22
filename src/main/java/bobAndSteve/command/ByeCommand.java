package bobAndSteve.command;

import bobAndSteve.TaskList;
import bobAndSteve.Ui;
import bobAndSteve.exception.BobAndSteveException;
import storage.Storage;

public class ByeCommand extends Command {

    public void end() {
        String bye = "Bye. Hope to see you again soon!";
        System.out.print(bye);
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage fileHandler) throws BobAndSteveException {
        this.end();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
