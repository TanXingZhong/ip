package bobandsteve.ui;

import java.util.Scanner;

public class Ui {

    private final Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public void showWelcome() {
        String name = "Bob and Steve";
        String greeting = "Hello! I'm " + name + " \n" +
                "What can I do for you?\n";
        System.out.println(greeting);
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showLine() {
        System.out.println("_______");
    }

    public void showError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }

    public void showLoadingError() {
        System.out.println("Error: Failed to load resources. Please try again.");
    }


}
