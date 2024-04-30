package pprog.controller;

import pprog.domain.CheckUp;
import pprog.repository.CheckUpRepository;
import pprog.repository.Repositories;
import pprog.domain.Date;


/**
 * Controller class responsible for registering check-ups.
 */
public class RegisterCheckUpController {

    /**
     * The repository where the check-up data is stored.
     */
    private CheckUpRepository checkUpRepository;

    /**
     * Default constructor. Retrieves the check-up repository instance.
     */
    public RegisterCheckUpController() {
        getCheckUpRepository();
    }

    /**
     * Constructor to set a specific check-up repository.
     * @param checkUpRepository The check-up repository to be set.
     */
    public RegisterCheckUpController(CheckUpRepository checkUpRepository) {
        this.checkUpRepository = checkUpRepository;
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

    /**
     * Registers a new check-up.
     * @param plate The plate number of the vehicle.
     * @param date The date of the check-up.
     * @param KMS The kilometers covered by the vehicle.
     * @return The registered check-up object.
     */
    public CheckUp registerCheckUp(String plate, Date date, double KMS) {
        return checkUpRepository.registerCheckUp( date, plate, KMS);
    }
}
