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
        if (command == CommandEnum.BYE) {
            return new ByeCommand();
        } else if (command == CommandEnum.HELP) {
            return new HelpCommand();
        } else if (command == CommandEnum.LIST) {
            return new ListCommand();
        } else if (command == CommandEnum.TODO) {
            return new TodoCommand(input);
        } else if (command == CommandEnum.DEADLINE) {
            return new DeadlineCommand(input);
        } else if (command == CommandEnum.EVENT) {
            return new EventCommand(input);
        } else if (command == CommandEnum.UNMARK) {
            return new UnmarkCommand(input);
        } else if (command == CommandEnum.MARK) {
            return new MarkCommand(input);
        } else if (command == CommandEnum.DELETE) {
            return new DeleteCommand(input);
        } else {
            throw new InvalidCommandException("Invalid command, Enter help to view all commands");
        }
    }
}
