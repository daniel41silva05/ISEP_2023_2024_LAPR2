package pprog.domain;

import java.util.Date;

public class Entry {

    private Date startingDate;
    private AgendaStatus status;
    private Task task;

    public Entry (Date startingDate, Task task) {
        this.startingDate = startingDate;
        this.status = AgendaStatus.PLANNED;
        this.task = task;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public AgendaStatus getStatus() {
        return status;
    }

    public void changeStatus(AgendaStatus status) {
        this.status = status;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
