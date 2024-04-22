package task;

import java.util.HashMap;
import java.util.Map;

public class TaskManager {

    private Integer countId = 0;
    // Map для задачи:
    private final Map<Integer, Task> tasks = new HashMap<>();

    // Map для подзадач:
    private final Map<Integer, Subtask> subtasks = new HashMap<>();

    // Map для эпиков:
    private final Map<Integer, Epic> epics = new HashMap<>();


}
