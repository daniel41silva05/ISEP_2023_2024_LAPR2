package pprog.domain;

import java.io.Serializable;

public class Task implements Serializable {

    private String reference;
    private String description;
    private EmergencyDegree degreeOfUrgency;
    private int expectedDuration;
    private TaskType type;
    private GreenSpace greenSpace;
    private TaskStatus status;

    // mudar os parametros que o construtor: EmergencyDegree e TaskType para int, quando já houver o método que vai buscar o objeto apartir do inteiro da classe enum
    public Task (String reference, String description, EmergencyDegree degreeOfUrgency, int expectedDuration, TaskType type, GreenSpace greenSpace) {
        this.reference = reference;
        this.description = description;
        this.degreeOfUrgency = degreeOfUrgency;
        this.expectedDuration = expectedDuration;
        this.type = type;
        this.greenSpace = greenSpace;
        this.status = TaskStatus.PENDING;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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

    public void chanceStatus(TaskStatus status) {
        this.status = status;
    }
}
