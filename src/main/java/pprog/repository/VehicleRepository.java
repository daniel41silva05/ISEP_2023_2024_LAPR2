package pprog.repository;

import pprog.domain.Collaborator;
import pprog.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepository {

    private List<Vehicle> vehiclesList;

    public VehicleRepository() {
        this.vehiclesList = new ArrayList<>();
    }

    private void addVehicle (Vehicle vehicle) {
        this.vehiclesList.add(vehicle);
    }
    private boolean validateVehicle (Vehicle vehicle) {
        // falta me implementar as validações
        return true;
    }

    public void registerVehicle (Vehicle vehicle) {
        if (validateVehicle(vehicle)) {
            addVehicle(vehicle);
        }
    }

    public List<Vehicle> getVehiclesList() {
        return vehiclesList;
    }

}
