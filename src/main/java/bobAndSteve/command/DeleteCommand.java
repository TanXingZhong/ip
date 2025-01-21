package bobAndSteve.command;

import bobAndSteve.TaskList;
import bobAndSteve.exception.BobAndSteveException;
import bobAndSteve.exception.InvalidCommandFormatException;
import fileHandler.FileHandler;

import java.io.IOException;

public class DeleteCommand extends Command {

    private int pos = 0;

    public DeleteCommand(String input) throws InvalidCommandFormatException{
        String[] split = input.split(" ", 2);
        if (split.length < 2) {
            throw new InvalidCommandFormatException("Deletes a task. Usage: delete <task number>");
        }
        try {
            pos = Integer.parseInt(split[1]);
        } catch (NumberFormatException e) {
            throw new InvalidCommandFormatException("The position must be a valid integer.");
        }
    }

    @Override
    public void run(TaskList taskList, FileHandler fileHandler) throws BobAndSteveException, IOException {
        taskList.deleteTask(pos);
        fileHandler.writeFile(taskList);
    }
}


