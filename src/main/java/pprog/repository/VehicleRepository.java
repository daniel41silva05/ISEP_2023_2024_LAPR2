package pprog.repository;

import pprog.domain.Collaborator;
import pprog.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepository {

    private List<Vehicle> vehicles;

    public VehicleRepository() {
        this.vehicles = new ArrayList<>();
    }

    public void save(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<Vehicle> getAllVehicle() {
        return vehicles;
    }

}
