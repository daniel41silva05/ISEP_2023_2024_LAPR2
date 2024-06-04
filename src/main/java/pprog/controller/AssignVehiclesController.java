package pprog.controller;

import pprog.domain.Entry;
import pprog.domain.Vehicle;
import pprog.domain.Agenda;
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

    public String assignVehiclesToEntry(int agendaIndex, List<String> vehiclesPlateNumbers) {
        List<Vehicle> vehiclesToAdd = new ArrayList<>();
        try {
            for (String vehiclePlateNumber : vehiclesPlateNumbers) {
                vehiclesToAdd.add(getVehicleByPlateNumber(vehiclePlateNumber.trim()));
            }
            getEntryByIndex(agendaIndex).assignVehicles(vehiclesToAdd);
            return null;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    private Entry getEntryByIndex(int index) {
        return getAgenda().getEntryByIndex(index);
    }

    public Vehicle getVehicleByPlateNumber (String vehiclePlateNumber) {
        return getVehicleRepository().getVehicleByPlateNumber(vehiclePlateNumber);
    }

    public List<Entry> getEntriesList() {
        return getAgenda().getEntriesList();
    }

    public List<Vehicle> getVehiclesList() {
        return getVehicleRepository().getVehiclesList();
    }

    public Entry getEntryWithVehicles(int index) {
        return getEntryByIndex(index);
    }

}
