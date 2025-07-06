import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private UniqueIdGenerator idGenerator;

    public TaskManager(UniqueIdGenerator idGenerator) {
        tasks = new ArrayList<>();
        this.idGenerator = idGenerator;
    }

    public void addTask(String description) {
        int genId = idGenerator.generate();
        Task task = new Task(genId, description);
        tasks.add(task);
    }

    public void removeTask(int id) {
        for (Task i: tasks) {
            if (i.getId() == id) {
                tasks.remove(i);
                idGenerator.release(id);
            } else {
                System.out.println("Element not found!");
            }
        }
    }

    public void markTaskCompleted(int id) {
        for (Task i : tasks) {
            if (i.getId() == id) {
                i.setStatus(TaskStatus.COMPLETED);
            } else {
                System.out.println("Element not found!");
            }
        }
    }
}
