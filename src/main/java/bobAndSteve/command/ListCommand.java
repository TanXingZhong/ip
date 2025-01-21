package bobAndSteve.command;

import bobAndSteve.TaskList;
import bobAndSteve.exception.BobAndSteveException;
import fileHandler.FileHandler;

import java.io.IOException;

public class ListCommand extends Command {

    @Override
    public void run(TaskList taskList, FileHandler fileHandler) throws BobAndSteveException, IOException {
        taskList.getList();
    }
}


