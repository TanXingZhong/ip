package bobandsteve.command;

import bobandsteve.exception.BobAndSteveException;
import bobandsteve.storage.Storage;
import bobandsteve.tasklist.TaskList;
import bobandsteve.ui.Ui;

/**
 * Represents a command that signals the end of the program.
 * This command is responsible for displaying a farewell message
 * and terminating the program when executed.
 */
public class ByeCommand extends Command {
    /**
     * Prints a goodbye message when the user exits the program.
     */
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
