import bobandsteve.BobAndSteve;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private BobAndSteve bobAndSteve;

    private Image steveImage = new Image(this.getClass().getResourceAsStream("/images/steve.png"));
    private Image bobImage = new Image(this.getClass().getResourceAsStream("/images/bob.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /** Injects the Duke instance */
    public void setBobAndSteve(BobAndSteve bobAndSteve) {
        this.bobAndSteve = bobAndSteve;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = bobAndSteve.getResponse(input);
        String commandType = bobAndSteve.getCommandType();
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, steveImage),
                DialogBox.getDukeDialog(response, bobImage, commandType)
        );
        userInput.clear();
    }
}
