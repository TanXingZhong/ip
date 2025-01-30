package bobandsteve.tasklist;

import bobandsteve.exception.BobAndSteveException;
import bobandsteve.exception.ListIndexOutOfBoundException;
import bobandsteve.task.Deadline;
import bobandsteve.task.Event;
import bobandsteve.task.Task;
import bobandsteve.task.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskList {
    private final List<Task> taskList = new ArrayList<>();

    public TaskList(File file) throws BobAndSteveException {
        load(file);
    }

    public TaskList() {
    }

    private void load(File file) throws BobAndSteveException {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String details = scanner.nextLine();
                String[] type = details.split("\\|");
                String isDone = type[1].trim().equals("1") ? "[X]" : "[ ]";
                if (type[0].trim().equals("T")) {
                    addTask(new Todo(type[2].trim(), isDone));
                } else if (type[0].trim().equals("D")) {
                    addTask(new Deadline(type[2].trim(), isDone, type[3].trim()));
                } else if (type[0].trim().equals("E")) {
                    addTask(new Event(type[2].trim(), isDone, type[3].trim(), type[4].trim()));
                } else {
                    throw new BobAndSteveException("Data file corrupted");
                }
            }
        } catch (BobAndSteveException | ArrayIndexOutOfBoundsException error) {
            throw new BobAndSteveException("Data file corrupted");
        } catch (FileNotFoundException error) {
            throw new BobAndSteveException("File not found");
        }
    }

    public int getSize() {
        return taskList.size();
    }

    public void mark(int pos) throws ListIndexOutOfBoundException {
        if (pos <= 0) {
            throw new ListIndexOutOfBoundException("You must enter a number greater than 0.");
        } else if (pos > this.getSize()) {
            throw new ListIndexOutOfBoundException("You only have " + this.getSize() + " tasks in the list.");
        }
        taskList.get(pos - 1).mark();
        System.out.println(taskList.get(pos - 1).toString());
    }

    public void unmark(int pos) throws ListIndexOutOfBoundException {
        if (pos <= 0) {
            throw new ListIndexOutOfBoundException("You must enter a number greater than 0.");
        } else if (pos > this.getSize()) {
            throw new ListIndexOutOfBoundException("You only have " + this.getSize() + " tasks in the list.");
        }
        taskList.get(pos - 1).unmark();
        System.out.println(taskList.get(pos - 1).toString());
    }

    public Task getTask(int pos) {
        return taskList.get(pos - 1);
    }

    public void addTask(Task t) {
        taskList.add(t);
        System.out.println("Got it. I've added this task:");
        System.out.println(t.toString());
        System.out.println("Now you have " + taskList.size() + " tasks in the list.");
    }

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

    public void getList() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            int index = i + 1;
            System.out.println(index + "." + taskList.get(i));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Task t : taskList) {
            sb.append(t.toSaveFormat()).append("\n");
        }
        return sb.toString();
    }
}
