import bobAndSteve.BobAndSteve;

/**
 * The Main class serves as the entry point for the application.
 * It initializes a new instance of the BobAndSteve class and runs it
 * using a specified file path for the data.
 */
public class Main {

    /**
     * The main method is the entry point of the program. It creates an instance
     * of the BobAndSteve class, passing a file path as a parameter, and then
     * runs the program.
     *
     * @param args Command-line arguments (unused in this program).
     */
    public static void main(String[] args) {
        new BobAndSteve("data/bobAndSteve.txt").run();
    }
}
