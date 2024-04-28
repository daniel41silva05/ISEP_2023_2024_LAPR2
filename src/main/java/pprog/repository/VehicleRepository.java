package pprog.repository;

import pprog.domain.Vehicle;
import pprog.domain.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VehicleRepository {

    private final List<Vehicle> vehiclesList;

    public VehicleRepository() {
        vehiclesList = new ArrayList<>();
    }

    public Optional<Vehicle> registerVehicle (String brand, String model, int tare, int grossWeight, int currentKm, String registerDate, String acquisitonDate, int maintenanceCheckUpFrequency, String idNumber, VehicleType type) {
        Optional<Vehicle> newVehicle = Optional.empty();
        Vehicle vehicle = new Vehicle(brand, model, tare, grossWeight, currentKm, registerDate, acquisitonDate, maintenanceCheckUpFrequency, idNumber, type);
        if (addVehicle(vehicle)) {
            newVehicle = Optional.of(vehicle);
        }
        return newVehicle;
    }

    private boolean addVehicle (Vehicle vehicle) {
        boolean success = false;
        if (validateVehicle(vehicle)) {
            success = vehiclesList.add(vehicle.clone());
        }
        return success;
    }

    private boolean validateVehicle (Vehicle vehicle) {
        boolean isValid = !vehiclesList.contains(vehicle);
        return isValid;
    }

    public List<Vehicle> getVehiclesList() {
        return vehiclesList;
    }

    @Override
    public String toString() {
        return "Vehicles=" + vehiclesList + '}';
    }
}
