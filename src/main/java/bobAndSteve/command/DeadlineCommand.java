package bobAndSteve.command;

import bobAndSteve.TaskList;
import bobAndSteve.exception.InvalidCommandFormatException;
import bobAndSteve.task.Deadline;
import fileHandler.FileHandler;

import java.io.IOException;

public class DeadlineCommand extends Command {

    private final String description;
    private final String by;

    public DeadlineCommand(String input) throws InvalidCommandFormatException{
        String[] split = input.split(" ", 2);
        if (split[1].isEmpty()) {
            throw new InvalidCommandFormatException("You must specify the task and deadline in the format: <task> /by <deadline>");
        }
        String[] by = split[1].split("/by", 2);
        if (by.length < 2 || by[0].trim().isEmpty() || by[1].trim().isEmpty()) {
            throw new InvalidCommandFormatException("Invalid format. Use: <task> /by <deadline>");
        }
        this.description = by[0].trim();
        this.by = by[1].trim();
    }

    @Override
    public void run(TaskList taskList, FileHandler fileHandler) throws IOException {
        Deadline deadline = new Deadline(description, "[ ]", by);
        taskList.addTask(deadline);
        fileHandler.writeFile(taskList);
    }
}
