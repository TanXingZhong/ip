package bobAndSteve.command;

import bobAndSteve.TaskList;
import bobAndSteve.exception.BobAndSteveException;
import bobAndSteve.exception.InvalidCommandFormatException;
import bobAndSteve.task.Todo;
import fileHandler.FileHandler;

import java.io.IOException;

public class TodoCommand extends Command {

    private final String description;

    public TodoCommand(String input) throws InvalidCommandFormatException{
        String[] split = input.split(" ", 2);
        if (split[1].isEmpty()) {
            throw new InvalidCommandFormatException("You must specify the task in the format: <task>");
        }
        this.description = split[1].trim();
    }

    @Override
    public void run(TaskList taskList, FileHandler fileHandler) throws BobAndSteveException, IOException {
        Todo todo = new Todo(description,"[ ]");
        taskList.addTask(todo);
    }
}
