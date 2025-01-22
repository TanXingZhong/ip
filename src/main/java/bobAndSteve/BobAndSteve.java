package bobAndSteve;

import bobAndSteve.command.Command;
import bobAndSteve.exception.BobAndSteveException;
import storage.Storage;

import java.io.IOException;

public class BobAndSteve {

    private TaskList taskList;
    private final Storage storage;
    private final Ui ui;

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
            } catch (BobAndSteveException | IOException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }
}