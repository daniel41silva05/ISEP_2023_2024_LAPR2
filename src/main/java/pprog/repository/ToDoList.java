package pprog.repository;

import pprog.domain.Task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ToDoList implements Serializable {

    private final List<Task> tasksList;

    public ToDoList () {
        tasksList = new ArrayList<>();
    }

    public Task getTaskByReference(String reference) {
        for (Task task : tasksList) {
            if (task.getReference().equals(reference)) {
                return task;
            }
        }
        throw new IllegalArgumentException("Task with reference '" + reference + "' not found.");
    }

    public List<Task> getTasksList() {
        return tasksList;
    }
}
