package task;

import enums.Status;

import java.util.Objects;

public class Task {
    private Integer id;
    private String taskName;
    private String taskDescription;
    private Status status;

    public Task(){

    }

    public Task(String taskName, String taskDescription, Status taskStatus){
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }


    public int getTaskId() {
        return id;
    }

    public void setTaskId(int taskId) {
        this.id = taskId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
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
