package bobAndSteve.task;

public class Event extends Task {

    protected String start ;
    protected String end ;

    public Event(String description, String isDone, String start, String end ) {
        super(description, isDone);
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from : " + start + " to: " + end + ")";
    }


    @Override
    public String toSaveFormat() {
        return "E" +  " | " + super.toSaveFormat() + " | " + this.start + " | " + this.end;
    }
}
