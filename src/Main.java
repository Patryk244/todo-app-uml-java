import java.util.List;

public class Main {
    public static void main(String[] args) {
        UniqueIdGenerator idGenerator = new UniqueIdGenerator();
        TaskManager taskManager = new TaskManager(idGenerator);
        InputValidator inputValidator = new InputValidator();

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Dodaj zadanie");
            System.out.println("2. Wyświetl zadania");
            System.out.println("3. Oznacz jako ukończone");
            System.out.println("4. Usuń zadanie");
            System.out.println("5. Zakończ");
            System.out.print("Twój wybór: ");

            int option = inputValidator.getValidId();

            switch (option) {
                case 1 -> {
                    String description = inputValidator.getValidDescription("Typing your description");
                    taskManager.addTask(description);
                    System.out.println("✅ Zadanie dodane.");
                }
                case 2 -> {
                    List<Task> tasks = taskManager.getAllTasks();
                    if (tasks.isEmpty()) {
                        System.out.println("Brak zadań.");
                    } else {
                        for (Task task : tasks) {
                            System.out.println("ID: " + task.getId() +
                                    " | Opis: " + task.getDescription() +
                                    " | Status: " + task.getStatus());
                        }
                    }
                }
                case 3 -> {
                    int id = inputValidator.getValidId();
                    taskManager.markTaskCompleted(id);
                    System.out.println("🟢 Zadanie oznaczone jako ukończone.");
                }
                case 4 -> {
                    int id = inputValidator.getValidId();
                    taskManager.removeTask(id);
                }
                case 5 -> {
                    System.out.println("Zamykanie programu...");
                    isRunning = false;
                }
                default -> System.out.println("Nieprawidłowa opcja.");
            }
        }
    }
}
