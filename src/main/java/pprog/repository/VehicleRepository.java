package pprog.repository;

import pprog.domain.Date;
import pprog.domain.Job;
import pprog.domain.Vehicle;
import pprog.domain.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Repository class to manage vehicles.
 */
public class VehicleRepository {

    /**
     * List to store vehicles.
     */
    private final List<Vehicle> vehiclesList;

    /**
     * Constructs a new VehicleRepository with an empty list of vehicles.
     */
    public VehicleRepository() {
        vehiclesList = new ArrayList<>();
    }



    public Vehicle registerVehicle (String brand, String model, int tare, int grossWeight, int currentKm, Date registerDate, Date acquisitonDate, int maintenanceCheckUpFrequency, String idNumber, VehicleType type) {
        Vehicle newVehicle = null;
        Vehicle vehicle = new Vehicle(brand, model, tare, grossWeight, currentKm, registerDate, acquisitonDate, maintenanceCheckUpFrequency, idNumber, type);
        if (addVehicle(vehicle)) {
            newVehicle = vehicle;
        }
        return newVehicle;
    }

    /**
     * Adds a vehicle to the repository.
     *
     * @param vehicle   The vehicle to be added.
     * @return          True if the vehicle is successfully added, false otherwise.
     */
    private boolean addVehicle (Vehicle vehicle) {
        boolean success = false;
        if (validateVehicle(vehicle)) {
            success = vehiclesList.add(vehicle.clone());
        }
        return success;
    }

    /**
     * Validates a vehicle before adding it to the repository.
     *
     * @param vehicle   The vehicle to be validated.
     * @return          True if the vehicle is valid (not already in the repository), false otherwise.
     */
    private boolean validateVehicle (Vehicle vehicle) {
        boolean isValid = !vehiclesList.contains(vehicle);
        return isValid;
    }

    public Vehicle getVehicleByPlateNumber(String plateNumber) {
        for (Vehicle vehicle : vehiclesList) {
            if (vehicle.getPlateNumber().equals(plateNumber)) {
                return vehicle;
            }
        }
        return null;
    }

    /**
     * Retrieves the list of vehicles.
     *
     * @return  The list of vehicles.
     */
    public List<Vehicle> getVehiclesList() {
        return vehiclesList;
    }

    /**
     * Provides a string representation of the VehicleRepository.
     *
     * @return  A string representation of the VehicleRepository.
     */
    @Override
    public String toString() {
        return "Vehicles=" + vehiclesList + '}';
    }
}
