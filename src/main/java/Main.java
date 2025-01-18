import bobAndSteve.BobAndSteve;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final BobAndSteve bob = new BobAndSteve();
        bob.greeting();
        while(scanner.hasNext()) {
            bob.commands(scanner.nextLine());
        };
    }
}
