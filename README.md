classDiagram
    direction TB

    class Identifiable {
        <<interface>>
        +getId() : int
    }

    class AbstractTask {
        <<abstract>>
        -id: int
        -description: String
        -status: TaskStatus
        +getId() : int
        +getDescription() : String
        +getStatus() : TaskStatus
        +setDescription(desc: String) : void
        +setStatus(status: TaskStatus) : void
    }

    class Task {
        +Task(id: int, description: String)
    }

    class TaskStatus {
        <<enum>>
        PENDING
        COMPLETED
        CANCELLED
    }

    class TaskManager {
        -tasks: List~Task~
        +addTask(description: String) : void
        +removeTask(id: int) : void
        +markTaskCompleted(id: int) : void
        +getAllTasks() : List~Task~
    }

    class InputValidator {
        +validateDescription(input: String) : boolean
        +validateId(input: String) : boolean
    }

    class ToDoApp {
        -taskManager: TaskManager
        -inputValidator: InputValidator
        +run() : void
    }

    Identifiable <|.. AbstractTask
    AbstractTask <|-- Task
    Task --> TaskStatus
    TaskManager --> Task
    ToDoApp --> TaskManager
    ToDoApp --> InputValidator
