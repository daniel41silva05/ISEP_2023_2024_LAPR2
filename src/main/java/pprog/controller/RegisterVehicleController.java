package pprog.controller;

import pprog.domain.Vehicle;
import pprog.domain.VehicleType;
import pprog.repository.Repositories;
import pprog.repository.VehicleRepository;

import java.util.Date;
import java.util.List;

/**
 * Controller class responsible for registering vehicles.
 */
public class RegisterVehicleController {

    /**
     * The repository where the vehicle data is stored.
     */
    private VehicleRepository vehicleRepository;

    /**
     * Default constructor. Retrieves the vehicle repository instance.
     */
    public RegisterVehicleController() {
        getVehicleRepository();
    }

    /**
     * Constructor to set a specific vehicle repository.
     * @param vehicleRepository The vehicle repository to be set.
     */
    public RegisterVehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    /**
     * Retrieves the vehicle repository instance if not already set.
     * @return The vehicle repository instance.
     */
    private VehicleRepository getVehicleRepository() {
        if (vehicleRepository == null) {
            Repositories repositories = Repositories.getInstance();
            vehicleRepository = repositories.getVehicleRepository();
        }
        return vehicleRepository;
    }

    /**
     * Registers a new vehicle.
     * @param brand The brand of the vehicle.
     * @param model The model of the vehicle.
     * @param tare The tare weight of the vehicle.
     * @param grossWeight The gross weight of the vehicle.
     * @param currentKm The current kilometers of the vehicle.
     * @param registerDate The date when the vehicle was registered.
     * @param acquisitionDate The date when the vehicle was acquired.
     * @param maintenanceCheckUpFrequency The frequency of maintenance check-ups.
     * @param plateNumber The plate number of the vehicle.
     * @param type The type of the vehicle.
     * @return The registered vehicle object.
     */
    public Vehicle registerVehicle(String brand, String model, int tare, int grossWeight, int currentKm, Date registerDate, Date acquisitionDate, int maintenanceCheckUpFrequency, String plateNumber, VehicleType type) {
        return vehicleRepository.registerVehicle(brand, model, tare, grossWeight, currentKm, registerDate, acquisitionDate, maintenanceCheckUpFrequency, plateNumber, type);
    }

    public List<Vehicle> getVehiclesList() {
        VehicleRepository vehicleRepository = getVehicleRepository();
        return vehicleRepository.getVehiclesList();
    }
}
