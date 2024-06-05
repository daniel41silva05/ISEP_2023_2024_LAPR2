package pprog.domain;

import java.io.Serializable;

/**
 * Represents a task to be performed.
 */
public class Task implements Serializable {

    private String title;
    private String description;
    private EmergencyDegree degreeOfUrgency;
    private int expectedDuration;
    private TaskType type;
    private GreenSpace greenSpace;
    private TaskStatus status;
    private GreenSpacesManager greenSpacesManager;

    /**
     * Constructs a Task object with the specified parameters.
     *
     * @param title            the title of the task
     * @param description      the description of the task
     * @param degreeOfUrgency  the degree of urgency of the task
     * @param expectedDuration the expected duration of the task
     * @param type             the type of the task
     * @param greenSpace       the green space associated with the task
     */
    public Task(String title, String description, int degreeOfUrgency, int expectedDuration, int type, GreenSpace greenSpace) {
        this.title = title;
        this.description = description;
        this.degreeOfUrgency = EmergencyDegree.fromInt(degreeOfUrgency);
        this.expectedDuration = expectedDuration;
        this.type = TaskType.fromInt(type);
        this.greenSpace = greenSpace;
        this.status = TaskStatus.PENDING;
        this.greenSpacesManager = greenSpace.getGreenSpacesManager();
    }

    /**
     * Checks if two tasks are equal.
     *
     * @param otherObject the other task to compare
     * @return true if the tasks are equal, false otherwise
     */
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }

        Task otherTask = (Task) otherObject;
        return title.equalsIgnoreCase(otherTask.title) && greenSpace.equals(otherTask.greenSpace);
    }

    // Getters and setters

    /**
     * Returns the title of the task.
     *
     * @return the title of the task
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the task.
     *
     * @param title the title of the task
     */
    public void setTitle(String title) {
        this.title = title;
    }

    // Other getters and setters...

    /**
     * Returns a string representation of the task.
     *
     * @return a string representation of the task
     */
    @Override
    public String toString() {
        return String.format("Title: %s\nDescription: %s\nDegree of Urgency: %s\nExpected Duration: %d\nType: %s\nGreen Space: %s\nManaged by: %s\n", title, description, degreeOfUrgency, expectedDuration, type, greenSpace.getName(), greenSpacesManager);
    }
}
