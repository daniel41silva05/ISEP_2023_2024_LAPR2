package pprog.repository;

import pprog.domain.CheckUp;
import pprog.domain.Date;
import java.util.ArrayList;
import java.util.List;

public class CheckUpRepository {

    private List<CheckUp> checkUpList;

    public CheckUpRepository() {
        checkUpList = new ArrayList<>();
    }

    @Override
    public void addCheckUp(CheckUp checkUp) {
        checkUpList.add(checkUp);
    }
}
