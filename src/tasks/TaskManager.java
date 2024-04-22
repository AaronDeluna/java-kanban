package tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManager {

    private Integer countId = 0;
    // Map для задачи:
    private final Map<Integer, Task> tasks = new HashMap<>();
    // Map для подзадач:
    private final Map<Integer, Subtask> subtasks = new HashMap<>();
    // Map для эпиков:
    private final Map<Integer, Epic> epics = new HashMap<>();


    public List<Task> getAllTasks() {
        List<Task> allTasks = new ArrayList<>();
        allTasks.addAll(tasks.values());
        allTasks.addAll(epics.values());
        allTasks.addAll(subtasks.values());
        return allTasks;
    }

    public void removeAllTasks(){
        tasks.clear();
        subtasks.clear();
        epics.clear();
    }

    public Task getTaskById(int id){
        if (tasks.containsKey(id)) {
            return tasks.get(id);
        }else if (epics.containsKey(id)){
            return epics.get(id);
        }else if (subtasks.containsKey(id)){
            return subtasks.get(id);
        }
        return null;
    }

    public void createTask(Task task){
        tasks.put(task.getTaskId(), task);
    }

    public void createEpic(Epic epic){
        epics.put(epic.getTaskId(), epic);
    }

    public void createSubtask(Subtask subtask){
        subtasks.put(subtask.getTaskId(), subtask);
    }

    public void updateTask(Task task) {
        tasks.put(task.getTaskId(), task);
    }

    public void updateEpic(Epic epic) {
        epics.put(epic.getTaskId(), epic);
    }

    public void updateSubtask(Subtask subtask) {
        subtasks.put(subtask.getTaskId(), subtask);
    }

    public void removeTaskById(int id) {
        tasks.remove(id);
    }

    public void removeEpicById(int id) {
        epics.remove(id);
    }

    public void removeSubtaskById(int id) {
        subtasks.remove(id);
    }
}
