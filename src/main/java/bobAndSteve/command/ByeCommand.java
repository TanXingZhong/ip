package bobAndSteve.command;

import bobAndSteve.TaskList;
import bobAndSteve.exception.BobAndSteveException;
import fileHandler.FileHandler;

import java.io.IOException;

public class ByeCommand extends Command {
    public void end() {
        String bye ="Bye. Hope to see you again soon!";
        System.out.print(bye);
        System.exit(0);
    }

    @Override
    public void run(TaskList taskList, FileHandler fileHandler) throws BobAndSteveException, IOException {
        this.end();
    }
}
