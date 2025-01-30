import bobandsteve.BobAndSteve;

/**
 * The Main class is the entry point of the application.
 * It initializes the BobAndSteve class with a specific file
 * and runs the program.
 */
public class Main {

    /**
     * The main method is the entry point for the Java application.
     * It creates an instance of the BobAndSteve class and calls
     * the `run` method to execute the program logic.
     */
    public static void main(String[] args) {
        new BobAndSteve("data/bobAndSteve.txt").run();
    }
}
