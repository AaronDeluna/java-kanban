package tasks;

import enums.Status;

public class Subtask extends Task {
    private Integer epicId;
    private Status subtaskStatus;

    public Subtask() {
    }

    public Subtask(Integer epicId, Status subtaskStatus) {
        this.epicId = epicId;
        this.subtaskStatus = subtaskStatus;
    }

    public Subtask(String taskName, String taskDescription, Status taskStatus, Integer epicId, Status subtaskStatus) {
        super(taskName, taskDescription, taskStatus);
        this.epicId = epicId;
        this.subtaskStatus = subtaskStatus;
    }

    public Integer getEpicId() {
        return epicId;
    }

    public void setEpicId(Integer epicId) {
        this.epicId = epicId;
    }

    public Status getSubtaskStatus() {
        return subtaskStatus;
    }

    public void setSubtaskStatus(Status subtaskStatus) {
        this.subtaskStatus = subtaskStatus;
    }
}
