package pprog.domain.todolist;

import pprog.domain.agenda.Entry;
import pprog.domain.greenspace.GreenSpace;
import pprog.domain.users.GreenSpacesManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ToDoList implements Serializable {

    private final List<Task> tasksList;

    public ToDoList() {
        tasksList = new ArrayList<>();
    }

    public Task addTaskToDoList(String title, String description, int degreeOfUrgency, int expectedDurantionTime, int taskType, GreenSpace greenSpace, String gsmFromSession) {
        Task newTask = null;
        Task task = new Task(title, description, degreeOfUrgency, expectedDurantionTime, taskType, greenSpace);

        if (addTask(gsmFromSession, task)) {
            newTask = task;
        }

        return newTask;
    }

    public Task getTaskByIndex(int index) {
        if (index < 1 || index > tasksList.size()) {
            throw new IllegalArgumentException("Task not found in To-Do List.");
        }
        return tasksList.get(index - 1);
    }

    private boolean addTask(String gsmFromSession, Task task) {
        if (validateTask(task) && validateUser(gsmFromSession, task)) {
            return tasksList.add(task);
        } else {
            throw new IllegalArgumentException("Task already exists in the To-Do List.");
        }
    }

    private boolean validateTask(Task task) {
        return !tasksList.contains(task);
    }

    public boolean validateUser(String gsmFromSession, Task task) {
        if (task.getGreenSpacesManager().getEmail().equals(gsmFromSession)) {
            return true;
        } else {
            throw new IllegalArgumentException("The logged in Green Space Manager does not manage the green space associated with this task.");
        }
    }

    public List<Task> getTasksList() {
        return tasksList;
    }
}
