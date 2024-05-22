package pprog.controller.vehicle;

import pprog.domain.agenda.Entry;
import pprog.domain.vehicle.Vehicle;
import pprog.repository.Agenda;
import pprog.repository.Repositories;
import pprog.repository.VehicleRepository;

import java.util.ArrayList;
import java.util.List;

public class AssignVehiclesController {

    private Agenda agenda;
    private VehicleRepository vehicleRepository;

    public AssignVehiclesController () {
        getAgenda();
        getVehicleRepository();
    }

    public AssignVehiclesController (Agenda agenda, VehicleRepository vehicleRepository) {
        this.agenda = agenda;
        this.vehicleRepository = vehicleRepository;
    }

    private Agenda getAgenda() {
        if (agenda == null) {
            Repositories repositories = Repositories.getInstance();
            agenda = repositories.getAgenda();
        }
        return agenda;
    }

    private VehicleRepository getVehicleRepository() {
        if (vehicleRepository == null) {
            Repositories repositories = Repositories.getInstance();
            vehicleRepository = repositories.getVehicleRepository();
        }
        return vehicleRepository;
    }

    public boolean assignVehiclesToEntry(int agendaIndex, List<String> vehicles) {
        List<Vehicle> vehiclesToAssign = new ArrayList<>();
        try {
            for (String vehicle : vehicles) {
                vehiclesToAssign.add(getVehicleByPlateNumber(vehicle.trim()));
            }
            getEntryByIndex(agendaIndex).assignVehicles(vehiclesToAssign);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
            return false;
        }
    }

    private Entry getEntryByIndex(int index) {
        return getAgenda().getEntryByIndex(index);
    }

    private Vehicle getVehicleByPlateNumber (String vehiclePlateNumber) {
        return getVehicleRepository().getVehicleByPlateNumber(vehiclePlateNumber);
    }

    public List<Entry> getEntriesList() {
        return getAgenda().getEntriesList();
    }

    public List<Vehicle> getVehiclesList() {
        return getVehicleRepository().getVehiclesList();
    }

}
