package bobAndSteve;

import bobAndSteve.command.Command;
import bobAndSteve.exception.BobAndSteveException;
import bobAndSteve.parser.Parser;
import bobAndSteve.storage.Storage;
import bobAndSteve.taskList.TaskList;
import bobAndSteve.ui.Ui;

/**
 * Represents the main entry point for the Bob and Steve task management application.
 * This class handles the initialization of the application, processes user commands,
 * and interacts with the task list, storage, and UI components.
 */
public class BobAndSteve {

    private TaskList taskList;
    private final Storage storage;
    private final Ui ui;

    /**
     * Constructs a new BobAndSteve application with a specified file path for storage.
     * Initializes the UI and storage components, and attempts to load the task list.
     *
     * @param filePath The path to the file where tasks are stored.
     */
    public BobAndSteve(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            taskList = new TaskList(storage.load());
        } catch (BobAndSteveException e) {
            ui.showLoadingError();
            taskList = new TaskList();
        }
    }

    /**
     * Runs the application, displaying the welcome message and processing user commands
     * in a loop until the exit command is issued.
     * <p>
     * The user input is parsed and executed, with errors displayed when they occur.
     * </p>
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(taskList, ui, storage);
                isExit = c.isExit();
            } catch (BobAndSteveException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }
}