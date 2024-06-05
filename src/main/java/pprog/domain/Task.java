package pprog.domain;

import java.io.Serializable;

public class Task implements Serializable {

    private String title;
    private String description;
    private EmergencyDegree degreeOfUrgency;
    private int expectedDuration;
    private TaskType type;
    private GreenSpace greenSpace;
    private TaskStatus status;
    private GreenSpacesManager greenSpacesManager;

    public Task (String title, String description, int degreeOfUrgency, int expectedDuration, int type, GreenSpace greenSpace) {
        this.title = title;
        this.description = description;
        this.degreeOfUrgency = EmergencyDegree.fromInt(degreeOfUrgency);
        this.expectedDuration = expectedDuration;
        this.type = TaskType.fromInt(type);
        this.greenSpace = greenSpace;
        this.status = TaskStatus.PENDING;
        this.greenSpacesManager = greenSpace.getGreenSpacesManager();
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }

        Task outraTask = (Task) otherObject;
        return title.equalsIgnoreCase(outraTask.title) && greenSpace.equals(outraTask.greenSpace);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EmergencyDegree getDegreeOfUrgency() {
        return degreeOfUrgency;
    }

    public void setDegreeOfUrgency(EmergencyDegree degreeOfUrgency) {
        this.degreeOfUrgency = degreeOfUrgency;
    }

    public int getExpectedDuration() {
        return expectedDuration;
    }

    public void setExpectedDuration(int expectedDuration) {
        this.expectedDuration = expectedDuration;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public GreenSpace getGreenSpace() {
        return greenSpace;
    }

    public void setGreenSpace(GreenSpace greenSpace) {
        this.greenSpace = greenSpace;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void changeStatus(TaskStatus status) {
        this.status = status;
    }

    public GreenSpacesManager getGreenSpacesManager() {
        return greenSpacesManager;
    }

    public void setGreenSpacesManager(GreenSpacesManager greenSpacesManager) {
        this.greenSpacesManager = greenSpacesManager;
    }

    @Override
    public String toString() {
        return String.format("Title: %s\nDescription: %s\nDegree of Urgency: %s\nExpected Duration: %d\nType: %s\nGreen Space: %s\nManaged by: %s\n", title, description, degreeOfUrgency, expectedDuration, type, greenSpace.getName(), greenSpacesManager);
    }
}
