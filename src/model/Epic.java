package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Epic extends Task{
    private final HashMap<Integer, Subtask> subtasksMap = new HashMap<>();

    public Epic(String taskName, String description){
        super(taskName, description);
    }

    public void addSubtask(Subtask newSubtasks){
        this.subtasksMap.putIfAbsent(newSubtasks.getId(), newSubtasks);
    }

    public void updateSubtask(Subtask newSubtasks){
        if (subtasksMap.containsKey(newSubtasks.getId())){
            subtasksMap.put(newSubtasks.getId(), newSubtasks);
        }
    }

    public ArrayList<Subtask> getSubtasks() {
        return new ArrayList<>(subtasksMap.values());
    }

    public void changeSubtask(int id){
        subtasksMap.remove(id);
    }

    public void changeAllSubtasks(){
        subtasksMap.clear();
    }

    public void changeStatus(){
        int counterDone = 0;
        int counterNew = 0;

        if (subtasksMap.isEmpty()){
            status = Status.NEW;
        }

        for (Subtask subtasks: subtasksMap.values()) {
            if (subtasks.getStatus() == Status.NEW) {
                counterNew++;
            } else if (subtasks.getStatus() == Status.DONE) {
                counterDone++;
            }
        }

        if (counterDone == subtasksMap.size()) {
            status = Status.DONE;
        } else if (counterNew == subtasksMap.size()) {
            status = Status.NEW;
        } else {
            status = Status.IN_PROGRESS;
        }
    }


    @Override
    public String toString() {
        return "Epic{" +
                "subtasksMap=" + subtasksMap +
                ", id=" + id +
                ", taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
