package bobAndSteve.parser;

import bobAndSteve.command.*;
import bobAndSteve.exception.BobAndSteveException;
import bobAndSteve.exception.InvalidCommandException;

public class Parser {

    public static Command parse(String input) throws BobAndSteveException {
        String[] split = input.split(" ", 2);
        CommandEnum command;
        try {
            command = CommandEnum.valueOf(split[0].trim().toUpperCase());
        } catch (IllegalArgumentException err) {
            throw new InvalidCommandException("Invalid command, Enter help to view all commands");
        }
        switch (command) {
            case BYE -> {
                return new ByeCommand();
            }
            case HELP -> {
                return new HelpCommand();
            }
            case LIST -> {
                return new ListCommand();
            }
            case TODO -> {
                return new TodoCommand(input);
            }
            case DEADLINE -> {
                return new DeadlineCommand(input);
            }
            case EVENT -> {
                return new EventCommand(input);
            }
            case UNMARK -> {
                return new UnmarkCommand(input);
            }
            case MARK -> {
                return new MarkCommand(input);
            }
            case DELETE -> {
                return new DeleteCommand(input);
            }
        }
        return new HelpCommand();
    }
}
