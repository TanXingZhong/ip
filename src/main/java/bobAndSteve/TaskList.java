package bobAndSteve;

import bobAndSteve.exception.ListIndexOutOfBoundException;
import bobAndSteve.task.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private final List<Task> tasks;
    public TaskList() {
        tasks = new ArrayList<>();
    }

    public int getSize() {
        return tasks.size();
    }

    public void mark(int pos) throws ListIndexOutOfBoundException {
        if (pos <= 0) {
            throw new ListIndexOutOfBoundException("You must enter a number greater than 0.");
        } else if (pos > this.getSize()) {
            throw new ListIndexOutOfBoundException("You only have " + this.getSize() + " tasks in the list.");
        }
        tasks.get(pos - 1).mark();
        System.out.println(tasks.get(pos - 1).toString());
    }

    public void unmark(int pos) throws ListIndexOutOfBoundException {
        if (pos <= 0) {
            throw new ListIndexOutOfBoundException("You must enter a number greater than 0.");
        } else if (pos > this.getSize()) {
            throw new ListIndexOutOfBoundException("You only have " + this.getSize() + " tasks in the list.");
        }
        tasks.get(pos - 1).unmark();
        System.out.println(tasks.get(pos - 1).toString());
    }

    public Task getTask(int pos) {
        return tasks.get(pos - 1);
    }

    public void addTask(Task t) {
        tasks.add(t);
        System.out.println("Got it. I've added this task:");
        System.out.println(t.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    public void deleteTask(int pos) throws ListIndexOutOfBoundException  {
        if (pos <= 0) {
            throw new ListIndexOutOfBoundException("You must enter a number greater than 0.");
        } else if (pos > this.getSize()) {
            throw new ListIndexOutOfBoundException("You only have " + this.getSize() + " tasks in the list.");
        }
        Task t = tasks.remove(pos - 1);
        System.out.println("Noted. I've removed this task:");
        System.out.println(t.toString());
        System.out.println("Now you have " + this.getSize() + " tasks in the list.");
    }

    public void getList() {
        System.out.println("Here are the tasks in your list:");
        for(int i = 0; i < tasks.size(); i++) {
            int index = i + 1;
            System.out.println(index + "." + tasks.get(i));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Task t : tasks) {
            sb.append(t.toSaveFormat()).append("\n");
        }
        return sb.toString();
    }
}
