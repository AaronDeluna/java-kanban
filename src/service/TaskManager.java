package service;

import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManager {
    private Integer counterId = 0;
    private final Map<Integer, Task> tasks = new HashMap<>();
    private final Map<Integer, Epic> epics = new HashMap<>();
    private final Map<Integer, Subtask> subtasks = new HashMap<>();


    public Integer getCounterId(){
        return counterId++;
    }

    public List<Task> getAllTasks(){
        return new ArrayList<>(tasks.values());
    }

    public List<Epic> getAllEpics(){
        return new ArrayList<>(epics.values());
    }

    public List<Subtask> getAllSubtasks(){
        return new ArrayList<>(subtasks.values());
    }

    public void dellAllTasks(){
        tasks.clear();
    }

    public void dellAllEpics(){
        epics.clear();
        subtasks.clear();
    }

    public void dellAllSubtasks() {
        for (Epic epic: epics.values()) {
            epic.changeAllSubtasks();
            epic.changeStatus();
        }
        subtasks.clear();
    }


    public Task getTaskById(Integer id) {
        return tasks.get(id);
    }

    public Epic getEpicById(Integer id) {
        return epics.get(id);
    }

    public Subtask getSubtaskById(Integer id) {
        return subtasks.get(id);
    }

    public void createTask(Task createNewTask) {
        createNewTask.setId(getCounterId());
        tasks.put(createNewTask.getId(), createNewTask);
    }

    public void createEpic(Epic createNewEpic) {
        createNewEpic.setId(getCounterId());
        epics.put(createNewEpic.getId(), createNewEpic);
    }

    public void createSubtask(Subtask createNewSubtask) {
        if (epics.containsKey(createNewSubtask.getEpicId())) {
            createNewSubtask.setId(getCounterId());
            subtasks.put(createNewSubtask.getId(), createNewSubtask);
            Epic epic = epics.get(createNewSubtask.getEpicId());
            epic.addSubtask(createNewSubtask);
            epic.changeStatus();
        }
    }

    public ArrayList<Subtask> getAllSubtasksAndEpic(Epic epic) {
        if (epics.containsKey(epic.getId())) {
            return epic.getSubtasks();
        }

        return new ArrayList<>();
    }

    public void changeTaskById(Integer id) {
        tasks.remove(id);
    }

    public void changeEpicById(Integer id) {
        if (epics.containsKey(id)) {
            for (Subtask subtask: epics.get(id).getSubtasks()) {
                subtasks.remove(subtask.getId());
            }
            epics.remove(id);
        }
    }

    public void changeSubtaskById(Integer id) {
        if (subtasks.containsKey(id)) {
            Epic epic = getEpicById(subtasks.get(id).getEpicId());
            epic.changeSubtask(id);
            epic.changeStatus();
            subtasks.remove(id);
        }
    }

}
