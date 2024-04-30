package pprog.repository;

import pprog.domain.CheckUp;
import java.util.ArrayList;
import java.util.List;
import pprog.domain.Date;


/**
 * Repository class to manage check-ups.
 */
public class CheckUpRepository {

    /**
     * List to store check-ups.
     */
    private final List<CheckUp> checkUpList;

    /**
     * Constructs a new CheckUpRepository with an empty list of check-ups.
     */
    public CheckUpRepository() {
        checkUpList = new ArrayList<>();
    }

    /**
     * Registers a new check-up in the repository.
     *
     * @param plate The plate number of the vehicle.
     * @param date  The date of the check-up.
     * @param KMS   The kilometers covered by the vehicle.
     * @return The newly registered check-up, or null if registration fails.
     */
    public CheckUp registerCheckUp(Date date,String plate,  double KMS) {
        CheckUp newCheckUp = new CheckUp(date, plate, KMS);
        if (addCheckUp(newCheckUp)) {
            return newCheckUp;
        } else {
            return null;
        }
    }

    /**
     * Adds a check-up to the repository.
     *
     * @param checkUp The check-up to be added.
     * @return True if the check-up is successfully added, false otherwise.
     */
    private boolean addCheckUp(CheckUp checkUp) {
        return checkUpList.add(checkUp);
    }

    /**
     * Provides a string representation of the CheckUpRepository.
     *
     * @return A string representation of the CheckUpRepository.
     */
    @Override
    public String toString() {
        return "Check-ups=" + checkUpList + '}';
    }
}
