import bobAndSteve.BobAndSteve;
import bobAndSteve.TaskList;
import bobAndSteve.exception.BobAndSteveException;
import bobAndSteve.task.Deadline;
import bobAndSteve.task.Event;
import bobAndSteve.task.Todo;
import fileHandler.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        TaskList taskList = new TaskList();
        FileHandler fh = new FileHandler( "./data/bobAndSteve.txt");
        BobAndSteve bob = new BobAndSteve(taskList, fh);
        bob.greeting();
        File file = fh.loadFile();
        Scanner scanner = new Scanner(file);
        try {
            while(scanner.hasNext()) {
                String details = scanner.nextLine();
                String[] type = details.split("\\|");
                String isDone = type[1].trim().equals("1") ? "[X]" : "[ ]";
                switch (type[0].trim()) {
                    case "T" -> taskList.addTask(new Todo(type[2].trim(), isDone));
                    case "D" -> taskList.addTask(new Deadline(type[2].trim(), isDone, type[3].trim()));
                    case "E" -> taskList.addTask(new Event(type[2].trim(), isDone, type[3].trim(), type[4].trim()));
                }
            }
        } catch(BobAndSteveException error) {
            System.out.println(error.getMessage());
        }
        scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            try {
                bob.commands(scanner.nextLine());
            } catch(BobAndSteveException error) {
                System.out.println(error.getMessage());
            }
        }
    }
}
