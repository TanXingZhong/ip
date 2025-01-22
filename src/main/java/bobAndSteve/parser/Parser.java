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
        return switch (command) {
            case BYE -> new ByeCommand();
            case HELP -> new HelpCommand();
            case LIST -> new ListCommand();
            case TODO -> new TodoCommand(input);
            case DEADLINE -> new DeadlineCommand(input);
            case EVENT -> new EventCommand(input);
            case UNMARK -> new UnmarkCommand(input);
            case MARK -> new MarkCommand(input);
            case DELETE -> new DeleteCommand(input);
        };
    }
}
