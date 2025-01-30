package bobAndSteve.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import bobAndSteve.exception.InvalidCommandFormatException;

public class CommandTest {
    @Test
    public void TodoCommand_wrongInput_exceptionThrown() {
        try {
            assertEquals(2, new TodoCommand("todo "));
            fail();
        } catch (InvalidCommandFormatException error) {
            assertEquals("You must specify the task in the format: <task>", error.getMessage());
        }
    }

    @Test
    public void DeadlineCommand_wrongInput_exceptionThrown() {
        try {
            assertEquals(2, new DeadlineCommand("deadline test"));
            fail();
        } catch (InvalidCommandFormatException error) {
            assertEquals("Invalid format. Use: <task> /by <deadline>", error.getMessage());
        }
    }

    @Test
    public void EventCommand_wrongInput_exceptionThrown() {
        try {
            assertEquals(2, new EventCommand("event test /from test"));
            fail();
        } catch (InvalidCommandFormatException error) {
            assertEquals("Invalid format. Use: <task> /from <start> /to <end>", error.getMessage());
        }
    }

    @Test
    public void DeleteCommand_wrongInput_exceptionThrown() {
        try {
            assertEquals(0, new DeleteCommand("delete test"));
            fail();
        } catch (InvalidCommandFormatException error) {
            assertEquals("The position must be a valid integer.", error.getMessage());
        }
    }

    @Test
    public void MarkCommand_wrongInput_exceptionThrown() {
        try {
            assertEquals(0, new MarkCommand("mark test"));
            fail();
        } catch (InvalidCommandFormatException error) {
            assertEquals("The position must be a valid integer.", error.getMessage());
        }
    }

    @Test
    public void MarkCommand_wrongInput2_exceptionThrown() {
        try {
            assertEquals(0, new MarkCommand("mark"));
            fail();
        } catch (InvalidCommandFormatException error) {
            assertEquals("You must specify the position of the task to mark.", error.getMessage());
        }
    }
    @Test
    public void UnmarkCommand_wrongInput_exceptionThrown() {
        try {
            assertEquals(0, new UnmarkCommand("mark test"));
            fail();
        } catch (InvalidCommandFormatException error) {
            assertEquals("The position must be a valid integer.", error.getMessage());
        }
    }

    @Test
    public void UnmarkCommand_wrongInput2_exceptionThrown() {
        try {
            assertEquals(0, new UnmarkCommand("mark"));
            fail();
        } catch (InvalidCommandFormatException error) {
            assertEquals("You must specify the position of the task to mark.", error.getMessage());
        }
    }
}