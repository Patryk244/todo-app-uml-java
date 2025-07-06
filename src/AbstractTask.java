public abstract class AbstractTask implements Identifiable {
    private int id;
    private String description;
    private TaskStatus status;
    AbstractTask(int id, String description) {
        this.id = id;
        this.description = description;
        status = TaskStatus.PENDING;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
