package pprog.domain.agenda;

import pprog.domain.gs.GreenSpace;

import java.io.Serializable;

public class Task implements Serializable {

    private String title;
    private String description;
    private EmergencyDegree degreeOfUrgency;
    private int expectedDuration;
    private TaskType type;
    private GreenSpace greenSpace;
    private TaskStatus status;

    // mudar os parametros que o construtor: EmergencyDegree e TaskType para int, quando já houver o método que vai buscar o objeto apartir do inteiro da classe enum
    public Task (String title, String description, EmergencyDegree degreeOfUrgency, int expectedDuration, TaskType type, GreenSpace greenSpace) {
        this.title = title;
        this.description = description;
        this.degreeOfUrgency = degreeOfUrgency;
        this.expectedDuration = expectedDuration;
        this.type = type;
        this.greenSpace = greenSpace;
        this.status = TaskStatus.PENDING;
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

    public Task clone() {
        return new Task(this.title, this.description, this.degreeOfUrgency, this.expectedDuration, this.type, this.greenSpace);
    }

    @Override
    public String toString() {
        return String.format("Title: %s\nDescription: %s\nDegree of Urgency: %s\nExpected Duration: %d\nType: %s\nGreen Space: %s", title, description, degreeOfUrgency, expectedDuration, type, greenSpace);
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return false;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }

        Task outraTask = (Task) outroObjeto;
        return title.equalsIgnoreCase(outraTask.title) &&
                description.equalsIgnoreCase(outraTask.description) &&
                degreeOfUrgency.equals(outraTask.degreeOfUrgency) &&
                expectedDuration == outraTask.expectedDuration &&
                type.equals(outraTask.type) &&
                greenSpace.equals(outraTask.greenSpace);
    }
}
