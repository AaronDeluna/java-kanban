package model;

public class Subtask extends Task{
    private final Integer epicId;

    public Subtask(String taskName, String description, Integer epicId){
        super(taskName, description);
        this.epicId = epicId;
    }

    public Integer getEpicId() {
        return epicId;
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "epicId=" + epicId +
                ", id=" + id +
                ", taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
