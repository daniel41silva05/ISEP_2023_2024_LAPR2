package pprog.controller;

import pprog.domain.CheckUp;
import pprog.domain.Vehicle;
import pprog.repository.*;

import java.util.Date;
import java.util.List;


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

    public CheckUp registerCheckUp(String vehiclePlateNumber, Date date, int KMS) {
        Vehicle vehicle = getVehicleByPlateNumber(vehiclePlateNumber);
        return checkUpRepository.registerCheckUp(date, vehicle, KMS);
    }

    private Vehicle getVehicleByPlateNumber (String vehiclePlateNumber) {
        VehicleRepository vehicleRepository = getVehicleRepository();
        return vehicleRepository.getVehicleByPlateNumber(vehiclePlateNumber);
    }

    public List<CheckUp> getCheckUpList() {
        CheckUpRepository checkUpRepository = getCheckUpRepository();
        return checkUpRepository.getCheckUpList();
    }
}