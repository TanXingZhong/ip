package bobAndSteve.command;

import bobAndSteve.exception.BobAndSteveException;
import bobAndSteve.storage.Storage;
import bobAndSteve.taskList.TaskList;
import bobAndSteve.ui.Ui;

/**
 * Represents a command that signals the end of the program.
 * This command is responsible for displaying a farewell message
 * and terminating the program when executed.
 */
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
