package tasks;

import enums.Status;

import java.util.HashMap;
import java.util.Map;

public class Epic extends Task {
    private Status epicStatus;
    private final Map<Integer, Subtask> epicMap = new HashMap<>();

    public Epic(Status epicStatus) {
        this.epicStatus = epicStatus;
    }

    public Epic(String taskName, String taskDescription, Status taskStatus, Status epicStatus) {
        super(taskName, taskDescription, taskStatus);
        this.epicStatus = epicStatus;
    }

    public Status getEpicStatus() {
        return epicStatus;
    }

    public void setEpicStatus(Status epicStatus) {
        this.epicStatus = epicStatus;
    }

    public Map<Integer, Subtask> getEpicMap() {
        return epicMap;
    }
}
