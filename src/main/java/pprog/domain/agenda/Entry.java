package pprog.domain.agenda;

import pprog.domain.Team;
import pprog.domain.vehicle.Vehicle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Entry implements Serializable {

    private Date startingDate;
    private AgendaStatus status;
    private Task task;
    private Team teamAssign;
    private List<Vehicle> vehiclesAssign;

    public Entry (Date startingDate, Task task) {
        this.startingDate = startingDate;
        this.status = AgendaStatus.PLANNED;
        this.task = task;
        this.teamAssign = null;
        this.vehiclesAssign = new ArrayList<>();
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

    public Team getTeamAssign() {
        return teamAssign;
    }

    public void assignTeam(Team teamAssign) {
        this.teamAssign = teamAssign;
    }

    public List<Vehicle> getVehiclesAssign() {
        return vehiclesAssign;
    }

    public void assignVehicles(List<Vehicle> vehiclesAssign) {
        this.vehiclesAssign = vehiclesAssign;
    }

    public void cancelEntry() { this.status = AgendaStatus.CANCELED; }
}
