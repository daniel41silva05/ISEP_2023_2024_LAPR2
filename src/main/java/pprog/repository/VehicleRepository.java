package pprog.repository;

import pprog.domain.Vehicle;
import pprog.domain.VehicleType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    /**
     * Registers a new vehicle in the repository.
     *
     * @param brand                  The brand of the vehicle.
     * @param model                  The model of the vehicle.
     * @param tare                   The tare weight of the vehicle.
     * @param grossWeight            The gross weight of the vehicle.
     * @param currentKm              The current kilometers of the vehicle.
     * @param registerDate           The registration date of the vehicle.
     * @param acquisitonDate        The acquisition date of the vehicle.
     * @param maintenanceCheckUpFrequency The maintenance check-up frequency of the vehicle.
     * @param idNumber               The ID number of the vehicle.
     * @param type                   The type of the vehicle.
     * @return                       The newly registered vehicle, or null if registration fails.
     */
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
        throw new IllegalArgumentException("Vehicle with plate number '" + plateNumber + "' not found.");
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
