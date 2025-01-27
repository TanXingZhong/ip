package bobandsteve.tasklist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bobandsteve.exception.BobAndSteveException;
import bobandsteve.exception.ListIndexOutOfBoundException;
import bobandsteve.task.Deadline;
import bobandsteve.task.Event;
import bobandsteve.task.Task;
import bobandsteve.task.Todo;
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
                case "E" -> addTask(new Event(type[2].trim(), isDone, type[3].trim(), type[4].trim()));
                default -> throw new BobAndSteveException("Data file corrupted");
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
     * @return A formatted string for marking the task.
     * @throws ListIndexOutOfBoundException If the position is out of bounds.
     */
    public String mark(int pos) throws ListIndexOutOfBoundException {
        if (pos <= 0) {
            throw new ListIndexOutOfBoundException("You must enter a number greater than 0.");
        } else if (pos > this.getSize()) {
            throw new ListIndexOutOfBoundException("You only have " + this.getSize() + " tasks in the list.");
        }
        taskList.get(pos - 1).mark();
        return "Nice! I've marked this task as done:\n" + taskList.get(pos - 1).toString();
    }

    /**
     * Unmarks a task as not done at the specified position.
     *
     * @param pos The position of the task to unmark.
     * @return A formatted string for unmarking the task.
     * @throws ListIndexOutOfBoundException If the position is out of bounds.
     */
    public String unmark(int pos) throws ListIndexOutOfBoundException {
        if (pos <= 0) {
            throw new ListIndexOutOfBoundException("You must enter a number greater than 0.");
        } else if (pos > this.getSize()) {
            throw new ListIndexOutOfBoundException("You only have " + this.getSize() + " tasks in the list.");
        }
        taskList.get(pos - 1).unmark();
        return "OK, I've marked this task as not done yet:\n" + taskList.get(pos - 1).toString();
    }

    /**
     * Adds a task to the task list.
     *
     * @param t The task to add.
     * @return A formatted string for adding task.
     */
    public String addTask(Task t) {
        taskList.add(t);
        return "Got it. I've added this task:\n"
                + t.toString() + "\n" + "Now you have " + getSize() + " tasks in the list.";
    }

    /**
     * Deletes a task at the specified position.
     *
     * @param pos The position of the task to delete.
     * @return A formatted string for deleting task.
     * @throws ListIndexOutOfBoundException If the position is out of bounds.
     */
    public String deleteTask(int pos) throws ListIndexOutOfBoundException {
        if (pos <= 0) {
            throw new ListIndexOutOfBoundException("You must enter a number greater than 0.");
        } else if (pos > this.getSize()) {
            throw new ListIndexOutOfBoundException("You only have " + this.getSize() + " tasks in the list.");
        }
        Task t = taskList.remove(pos - 1);
        return "Noted. I've removed this task:\n"
                + t.toString() + "\n" + "Now you have " + this.getSize() + " tasks in the list.";
    }

    /**
     * Displays the list of tasks.
     * @return A formatted string of a list of tasks.
     */
    public String getList() {
        StringBuilder output = new StringBuilder("Here are the tasks in your list:");
        if (getSize() > 0) {
            output.append("\n");
        }
        for (int i = 0; i < taskList.size(); i++) {
            int index = i + 1;
            output.append(index).append(".").append(taskList.get(i));
            if (i < taskList.size() - 1) {
                output.append("\n");
            }
        }
        return output.toString();
    }

    /**
     * Search and display the list of task based on matching keywords.
     * @return A formatted string of a list of tasks with matching keyword.
     */
    public String find(String keyword) {
        StringBuilder output = new StringBuilder("Here are the matching tasks in your list:\n");
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            if (task.toString().contains(keyword)) {
                int index = i + 1;
                output.append(index).append(".").append(taskList.get(i));
                if (i < taskList.size() - 1) {
                    output.append("\n");
                }
            }
        }
        return output.toString();
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
        int size = taskList.size();
        for (int i = 0; i < size; i++) {
            Task t = taskList.get(i);
            sb.append(t.toSaveFormat());
            if (i < size - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
