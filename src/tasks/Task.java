package tasks;

import enums.Status;

import java.util.Objects;

public class Task {
    private static int nextId = 1;

    private Integer id;
    private String taskName;
    private String taskDescription;
    private Status status;

    public Task() {
        this.id = nextId++;
    }

    public Task(String taskName, String taskDescription, Status taskStatus) {
        this.id = nextId++;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.status = taskStatus;
    }

    public Integer getTaskId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                '}';
    }
}
