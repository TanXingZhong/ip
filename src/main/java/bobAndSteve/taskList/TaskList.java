package bobAndSteve.taskList;

import bobAndSteve.exception.BobAndSteveException;
import bobAndSteve.exception.ListIndexOutOfBoundException;
import bobAndSteve.task.Deadline;
import bobAndSteve.task.Event;
import bobAndSteve.task.Task;
import bobAndSteve.task.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a list of tasks in the BobAndSteve application.
 * The TaskList is used to manage, load, mark, unmark, delete, find and retrieve tasks.
 */
public class TaskList {
    private final List<Task> taskList = new ArrayList<>();

    /**
     * Constructs a TaskList and loads tasks from the specified file.
     *
     * @param file The file containing saved task data.
     * @throws BobAndSteveException If there is an error loading the tasks from the file.
     */
    public TaskList(File file) throws BobAndSteveException {
        load(file);
    }

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {
    }

    /**
     * Loads tasks from a file into the task list.
     *
     * @param file The file containing saved task data.
     * @throws BobAndSteveException If there is an error loading the tasks from the file.
     */
    private void load(File file) throws BobAndSteveException {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String details = scanner.nextLine();
                String[] type = details.split("\\|");
                String isDone = type[1].trim().equals("1") ? "[X]" : "[ ]";
                switch (type[0].trim()) {
                    case "T" -> addTask(new Todo(type[2].trim(), isDone));
                    case "D" -> addTask(new Deadline(type[2].trim(), isDone, type[3].trim()));
                    case "E" ->
                            addTask(new Event(type[2].trim(), isDone, type[3].trim(), type[4].trim()));
                }
            }
        } catch (BobAndSteveException | ArrayIndexOutOfBoundsException error) {
            throw new BobAndSteveException("Data file corrupted");
        } catch (FileNotFoundException error) {
            throw new BobAndSteveException("File not found");
        }
    }


    /**
     * Marks a task as done at the specified position.
     *
     * @param pos The position of the task to mark.
     * @throws ListIndexOutOfBoundException If the position is out of bounds.
     */
    public void mark(int pos) throws ListIndexOutOfBoundException {
        if (pos <= 0) {
            throw new ListIndexOutOfBoundException("You must enter a number greater than 0.");
        } else if (pos > this.getSize()) {
            throw new ListIndexOutOfBoundException("You only have " + this.getSize() + " tasks in the list.");
        }
        taskList.get(pos - 1).mark();
        System.out.println(taskList.get(pos - 1).toString());
    }

    /**
     * Unmarks a task as not done at the specified position.
     *
     * @param pos The position of the task to unmark.
     * @throws ListIndexOutOfBoundException If the position is out of bounds.
     */
    public void unmark(int pos) throws ListIndexOutOfBoundException {
        if (pos <= 0) {
            throw new ListIndexOutOfBoundException("You must enter a number greater than 0.");
        } else if (pos > this.getSize()) {
            throw new ListIndexOutOfBoundException("You only have " + this.getSize() + " tasks in the list.");
        }
        taskList.get(pos - 1).unmark();
        System.out.println(taskList.get(pos - 1).toString());
    }

    /**
     * Adds a task to the task list.
     *
     * @param t The task to add.
     */
    public void addTask(Task t) {
        taskList.add(t);
        System.out.println("Got it. I've added this task:");
        System.out.println(t.toString());
        System.out.println("Now you have " + taskList.size() + " tasks in the list.");
    }

    /**
     * Deletes a task at the specified position.
     *
     * @param pos The position of the task to delete.
     * @throws ListIndexOutOfBoundException If the position is out of bounds.
     */
    public void deleteTask(int pos) throws ListIndexOutOfBoundException {
        if (pos <= 0) {
            throw new ListIndexOutOfBoundException("You must enter a number greater than 0.");
        } else if (pos > this.getSize()) {
            throw new ListIndexOutOfBoundException("You only have " + this.getSize() + " tasks in the list.");
        }
        Task t = taskList.remove(pos - 1);
        System.out.println("Noted. I've removed this task:");
        System.out.println(t.toString());
        System.out.println("Now you have " + this.getSize() + " tasks in the list.");
    }

    /**
     * Displays the list of tasks.
     */
    public void getList() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            int index = i + 1;
            System.out.println(index + "." + taskList.get(i));
        }
    }

    /**
     * Search and display the list of task based on matching keywords.
     */
    public void find(String keyword) {
        System.out.println("Here are the matching tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            if(task.toString().contains(keyword)) {
                int index = i + 1;
                System.out.println(index + "." + taskList.get(i));
            }
        }
    }

    /**
     * Returns the size of the task list.
     *
     * @return The number of tasks in the list.
     */
    public int getSize() {
        return taskList.size();
    }

    /**
     * Retrieves a task at the specified position.
     *
     * @param pos The position of the task to retrieve.
     * @return The task at the specified position.
     */
    public Task getTask(int pos) {
        return taskList.get(pos - 1);
    }

    /**
     * Returns a string representation of the task list in a format suitable for saving to a file.
     *
     * @return A string representing the task list in save format.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Task t : taskList) {
            sb.append(t.toSaveFormat()).append("\n");
        }
        return sb.toString();
    }
}
