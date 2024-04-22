import model.*;
import enums.Status;
import model.Epic;
import model.Subtask;
import model.Task;
import service.TaskManager;

public class Main {

    private static final TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        Task task1 = new Task("Первая таска", "Описание к первому заданию");
        Task task2 = new Task("Вторая таска", "Описание к второму заданию");
        taskManager.createTask(task1);
        taskManager.createTask(task2);

        Epic epic1 = new Epic("Первый эпик", "Описание к эпику");
        taskManager.createEpic(epic1);

        Epic epic2 = new Epic("Второй эпик", "Описание к эпику");
        taskManager.createEpic(epic2);


        Subtask subtask1 = new Subtask("Первая суббтаска",
                "Описание первой подзадачи", epic1.getId());
        Subtask subtask2 = new Subtask("Вторая суббтаска",
                "Описание второй подзадачи", epic1.getId());

        taskManager.createSubtask(subtask1);
        taskManager.createSubtask(subtask2);

        Subtask subtask3 = new Subtask("Третья субтаска",
                "Описание третей подзадачи", epic2.getId());
        taskManager.createSubtask(subtask3);


       //change status

        task1.setStatus(Status.IN_PROGRESS);
        taskManager.createTask(task1);
        task2.setStatus(Status.DONE);
        taskManager.createTask(task2);

        subtask1.setStatus(Status.DONE);
        taskManager.createSubtask(subtask1);
        subtask2.setStatus(Status.NEW);
        taskManager.createSubtask(subtask2);
        subtask3.setStatus(Status.DONE);
        taskManager.createSubtask(subtask3);

       //Dell
        System.out.println("*************");
        taskManager.changeEpicById(task1.getId());
        taskManager.changeEpicById(epic1.getId());

        System.out.println("Список эпиков: ");
        System.out.println(taskManager.getAllEpics());
        System.out.println("Список задач: ");
        System.out.println(taskManager.getAllTasks());
        System.out.println("Список подзадач: ");
        System.out.println(taskManager.getAllSubtasks());
    }
}