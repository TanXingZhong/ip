package bobAndSteve.parser;

import bobAndSteve.command.ByeCommand;
import bobAndSteve.exception.BobAndSteveException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ParserTest {
    @Test
    public void Parser_wrongInput_exceptionThrown() {
        try {
            assertEquals(new ByeCommand(), Parser.parse("test"));
            fail();
        } catch (BobAndSteveException error) {
            assertEquals("Invalid command, Enter help to view all commands", error.getMessage());
        }
    }
}