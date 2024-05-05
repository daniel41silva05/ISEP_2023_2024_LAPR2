package pprog.repository;

import pprog.domain.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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

    public CheckUp registerCheckUp(Date date, Vehicle vehicle, int KMS) {
        CheckUp newCheckUp = null;
        CheckUp checkUp = new CheckUp(date, vehicle, KMS);

        if (addCheckUp(checkUp)) {
            newCheckUp = checkUp;
        }
        return newCheckUp;
    }

    private boolean addCheckUp(CheckUp checkUp) {
        boolean success = false;
        if (validateCheckUp(checkUp)) {
            success = checkUpList.add(checkUp.clone());
        }
        return success;
    }

    private boolean validateCheckUp(CheckUp checkUp) {
        return !checkUpList.contains(checkUp);
    }

    public List<CheckUp> getCheckUpList() {
        return checkUpList;
    }

    /**
     * Provides a string representation of the CheckUpRepository.
     *
     * @return A string representation of the CheckUpRepository.
     */
    @Override
    public String toString() {
        return "Check-ups=" + checkUpList+'}';
    }
}