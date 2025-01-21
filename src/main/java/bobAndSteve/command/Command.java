package bobAndSteve.command;

import bobAndSteve.TaskList;
import bobAndSteve.exception.BobAndSteveException;
import bobAndSteve.exception.InvalidCommandFormatException;
import fileHandler.FileHandler;

import java.io.IOException;

public abstract class Command {

    public abstract void run(TaskList taskList, FileHandler fileHandler) throws BobAndSteveException, IOException;
}
