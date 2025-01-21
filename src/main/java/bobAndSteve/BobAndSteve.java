package bobAndSteve;

import bobAndSteve.command.*;
import bobAndSteve.exception.BobAndSteveException;
import bobAndSteve.exception.InvalidCommandException;
import bobAndSteve.exception.InvalidCommandFormatException;
import bobAndSteve.exception.ListIndexOutOfBoundException;
import fileHandler.FileHandler;

import java.io.IOException;

public class BobAndSteve {
    private final String name = "Bob and Steve";
    private final ByeCommand byeCommand = new ByeCommand();
    private final HelpCommand helpCommand = new HelpCommand();
    private final TaskList taskList;
    private final FileHandler fh;

    public BobAndSteve(TaskList taskList, FileHandler fh) {
        this.fh = fh;
        this.taskList = taskList;
    }

    public void commands(String input) throws InvalidCommandFormatException, ListIndexOutOfBoundException, InvalidCommandException {
        String[] split = input.split(" ", 2);
        CommandEnum command;
        try {
            command = CommandEnum.valueOf(split[0].trim().toUpperCase());
        }
        catch(IllegalArgumentException err) {
            throw new InvalidCommandException("Invalid command, Enter help to view all commands");
        }
        try {
            switch (command) {
                case BYE ->{
                    fh.writeFile(taskList);
                    new ByeCommand().run(taskList, fh);
                }
                case HELP -> new HelpCommand().run(taskList, fh);
                case LIST -> new ListCommand().run(taskList, fh);
                case TODO -> new TodoCommand(input).run(taskList, fh);
                case DEADLINE -> new DeadlineCommand(input).run(taskList, fh);
                case EVENT -> new EventCommand(input).run(taskList, fh);
                case UNMARK -> new UnmarkCommand(input).run(taskList, fh);
                case MARK -> new MarkCommand(input).run(taskList, fh);
                case DELETE -> new DeleteCommand(input).run(taskList, fh);
            }
        } catch(BobAndSteveException | IOException err) {
            System.out.println(err.getMessage());
        }
    }

    public void greeting() {
        String greeting = "Hello! I'm " + name + " \n" +
                "What can I do for you?\n";
        System.out.println(greeting);
    }

    @Override
    public String toString() {
        return name;
    }
}