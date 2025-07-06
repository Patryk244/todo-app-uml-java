public class Task extends AbstractTask {
    int id;
    String description;
    Task(int id, String description) {
        super(id, description);
    }

    public String toString() {
        return "Id: " + id + " description: " + description;
    }
}
