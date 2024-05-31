package pprog.domain.agenda;

import pprog.domain.Team;
import pprog.domain.todolist.Task;
import pprog.domain.users.GreenSpacesManager;
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
    private GreenSpacesManager greenSpacesManager;
    private List<Vehicle> vehiclesAssign;

    public Entry (Date startingDate, Task task) {
        this.startingDate = startingDate;
        this.status = AgendaStatus.PLANNED;
        this.task = task;
        this.greenSpacesManager = task.getGreenSpacesManager();
        this.teamAssign = null;
        this.vehiclesAssign = new ArrayList<>();
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Entry outroEntry = (Entry) outroObjeto;
        return task.equals(outroEntry.task);
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

    public GreenSpacesManager getGreenSpacesManager() {
        return greenSpacesManager;
    }

    public void setGreenSpacesManager(GreenSpacesManager greenSpacesManager) {
        this.greenSpacesManager = greenSpacesManager;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Starting Date: %s\n%sStatus: %s", startingDate, task, status));

        if (teamAssign != null) {
            sb.append(String.format("\nTeam Assigned: %s\n", teamAssign));
        }

        if (vehiclesAssign != null && !vehiclesAssign.isEmpty()) {
            sb.append("\nVehicles Assigned:\n");
            for (Vehicle vehicle : vehiclesAssign) {
                sb.append(String.format("%s\n", vehicle));
            }
        }

        return sb.toString();
    }
}
