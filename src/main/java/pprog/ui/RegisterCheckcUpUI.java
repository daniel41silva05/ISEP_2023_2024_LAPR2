package pprog.ui;
import pprog.domain.CheckUp;

import java.util.ArrayList;
import java.util.List;

public class RegisterCheckcUpUI {

    private List<CheckUp> checkup;

    public CheckUpRepository() {
        this.checkup = new ArrayList<>();
    }

    public void save(CheckUp checkUp) {
        checkup.add(checkup);
    }

    public List<CheckUp> getAllVehicle() {
        return checkup;
    }

}
