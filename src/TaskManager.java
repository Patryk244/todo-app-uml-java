import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private UniqueIdGenerator idGenerator;

    public TaskManager(UniqueIdGenerator idGenerator) {
        tasks = new ArrayList<>();
        this.idGenerator = idGenerator;
    }

    public void addTask(String description) {
        int genId = idGenerator.generate();

        tasks.add(new Task(genId, description));
    }

    public void removeTask(int id) {
        Iterator<Task> iterator = tasks.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Task i = iterator.next();
            if (i.getId() == id) {
                iterator.remove();
                idGenerator.release(id);
                found = true;
                System.out.println("Removing successful");
            }
        }
        if (!found) {
            System.out.println("Element not found!");
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

    public List<Task> getAllTasks() {
        return tasks;
    }
}
