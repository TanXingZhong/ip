package bobAndSteve.task;

public class Todo extends Task {

    protected String by;

    public Todo(String description, String isDone) {
        super(description, isDone);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }


    @Override
    public String toSaveFormat() {
        return "T" +  " | " + super.toSaveFormat();
    }
}
