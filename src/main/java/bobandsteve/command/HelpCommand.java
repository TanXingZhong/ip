package bobandsteve.command;

import bobandsteve.exception.BobAndSteveException;
import bobandsteve.storage.Storage;
import bobandsteve.tasklist.TaskList;
import bobandsteve.ui.Ui;

public class HelpCommand extends Command {
    public void help() {
        System.out.println("Available Commands:");
        System.out.println("-------------------");
        System.out.println("HELP      - Displays the list of all commands.");
        System.out.println("MARK      - Marks a task as completed. Usage: mark <task number>");
        System.out.println("UNMARK    - Unmarks a completed task. Usage: unmark <task number>");
        System.out.println("TODO      - Adds a todo. Usage: todo <task>");
        System.out.println("DEADLINE  - Adds a deadline. Usage: deadline <task> /by <date>");
        System.out.println("EVENT     - Adds an event. Usage: event <task> /from <start> /to <end>");
        System.out.println("LIST      - Displays all tasks.");
        System.out.println("DELETE    - Deletes a task. Usage: delete <task number>");
        System.out.println("BYE       - Exits the program.");
        System.out.println("-------------------");
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws BobAndSteveException {
        this.help();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
