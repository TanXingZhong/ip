import bobAndSteve.BobAndSteve;
import bobAndSteve.TaskList;
import bobAndSteve.exception.BobAndSteveException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final BobAndSteve bob = new BobAndSteve(new TaskList());
        bob.greeting();
        while(scanner.hasNext()) {
            try {
                bob.commands(scanner.nextLine());
            } catch(BobAndSteveException error) {
                System.out.println(error.getMessage());
            }

        };
    }
}
