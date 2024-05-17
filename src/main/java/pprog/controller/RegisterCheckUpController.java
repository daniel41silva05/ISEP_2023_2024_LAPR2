package pprog.controller;

import pprog.domain.Vehicle;
import pprog.repository.*;

import java.util.Date;


/**
 * Controller class responsible for registering check-ups.
 */
public class RegisterCheckUpController {

    /**
     * The repository where the check-up data is stored.
     */
    private CheckUpRepository checkUpRepository;

    private VehicleRepository vehicleRepository;

    /**
     * Default constructor. Retrieves the check-up repository instance.
     */
    public RegisterCheckUpController() {
        getCheckUpRepository();
        getVehicleRepository();
    }

    /**
     * Constructor to set a specific check-up repository.
     * @param checkUpRepository The check-up repository to be set.
     */
    public RegisterCheckUpController(CheckUpRepository checkUpRepository, VehicleRepository vehicleRepository) {
        this.checkUpRepository = checkUpRepository;
        this.vehicleRepository = vehicleRepository;
    }

    /**
     * Retrieves the check-up repository instance if not already set.
     * @return The check-up repository instance.
     */
    private CheckUpRepository getCheckUpRepository() {
        if (checkUpRepository == null) {
            Repositories repositories = Repositories.getInstance();
            checkUpRepository = repositories.getCheckUpRepository();
        }
        return checkUpRepository;
    }

    private VehicleRepository getVehicleRepository () {
        if (vehicleRepository == null) {
            Repositories repositories = Repositories.getInstance();
            vehicleRepository = repositories.getVehicleRepository();
        }
        return vehicleRepository;
    }

    public boolean registerCheckUp(String vehiclePlateNumber, Date date, int KMS) {
        try {
            getCheckUpRepository().registerCheckUp(date, getVehicleByPlateNumber(vehiclePlateNumber), KMS);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
            return false;
        }
    }

    private Vehicle getVehicleByPlateNumber (String vehiclePlateNumber) {
        return getVehicleRepository().getVehicleByPlateNumber(vehiclePlateNumber);
    }

}