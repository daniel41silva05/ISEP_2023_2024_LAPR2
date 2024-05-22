package pprog.repository;

import pprog.domain.agenda.EmergencyDegree;
import pprog.domain.gs.GreenSpace;
import pprog.domain.agenda.Task;
import pprog.domain.agenda.TaskType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ToDoList implements Serializable {

    private final List<Task> tasksList;

    public ToDoList() {
        tasksList = new ArrayList<>();
    }

    public Task addTaskToDoList(String title, String descritpion, EmergencyDegree degreeOfUrgency, int expectedDurantionTime, TaskType taskType, GreenSpace greenSpace) {
        Task newTask = null;
        Task task = new Task(title, descritpion, degreeOfUrgency, expectedDurantionTime, taskType, greenSpace);

        if (addTask(task)) {
            newTask = task;
        }

        return newTask;
    }

    public Task getTaskByTitle(String title) {
        for (Task task : tasksList) {
            if (task.getTitle().equals(title)) {
                return task;
            }
        }
        throw new IllegalArgumentException("Task with title '" + title + "' not found.");
    }

    private boolean addTask(Task task) {
        if (validateTask(task)) {
            return tasksList.add(task);
        } else {
            throw new IllegalArgumentException("Task already exists in the To-Do List.");
        }
    }

    private boolean validateTask(Task task) {
        return !tasksList.contains(task);
    }

    public List<Task> getTasksList() {
        return tasksList;
    }
}
