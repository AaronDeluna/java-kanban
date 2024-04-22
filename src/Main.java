import enums.Status;
import tasks.Epic;
import tasks.Subtask;
import tasks.Task;
import tasks.TaskManager;

public class Main {
    public static void main(String[] args) {
        // Создаем экземпляр менеджера задач
        TaskManager taskManager = new TaskManager();

        // Создаем задачи
        Task task1 = new Task("Task 1", "Description 1", Status.NEW);
        Task task2 = new Task("Task 2", "Description 2", Status.IN_PROGRESS);

        // Создаем подзадачи
        Subtask subtask1 = new Subtask("Subtask 1", "Subtask Description 1", Status.NEW, 1, Status.NEW);
        Subtask subtask2 = new Subtask("Subtask 2", "Subtask Description 2", Status.NEW, 1, Status.IN_PROGRESS);

        // Создаем эпики
        Epic epic1 = new Epic("Epic 1", "Epic Description 1", Status.NEW, Status.NEW);
        epic1.getEpicMap().put(subtask1.getTaskId(), subtask1);
        epic1.getEpicMap().put(subtask2.getTaskId(), subtask2);

        Epic epic2 = new Epic("Epic 2", "Epic Description 2", Status.NEW, Status.IN_PROGRESS);
        epic2.getEpicMap().put(subtask1.getTaskId(), subtask1);

        // Добавляем задачи, подзадачи и эпики в менеджер задач
        taskManager.createTask(task1);
        taskManager.createTask(task2);
        taskManager.createSubtask(subtask1);
        taskManager.createSubtask(subtask2);
        taskManager.createEpic(epic1);
        taskManager.createEpic(epic2);

        // Выводим списки задач, подзадач и эпиков
        System.out.println("All Tasks:");
        taskManager.getAllTasks().forEach(System.out::println);

        // Меняем статусы задач и эпиков
        task1.setStatus(Status.DONE);
        subtask1.setSubtaskStatus(Status.DONE);
        epic1.setEpicStatus(Status.DONE);

        // Выводим обновленные списки задач, подзадач и эпиков
        System.out.println("\nAll Tasks after status update:");
        taskManager.getAllTasks().forEach(System.out::println);

        // Удаляем задачу и эпик
        taskManager.removeTaskById(task2.getTaskId());
        taskManager.removeEpicById(epic2.getTaskId());

        // Выводим списки задач, подзадач и эпиков после удаления
        System.out.println("\nAll Tasks after removal:");
        taskManager.getAllTasks().forEach(System.out::println);
    }
}
