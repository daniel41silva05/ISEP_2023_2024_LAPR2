package pprog.repository;

import pprog.domain.GreenSpace;

import java.util.ArrayList;
import java.util.List;

public class GreenSpaceRepository {

    private final List<GreenSpace> greenSpacesList;

    public GreenSpaceRepository() {
        greenSpacesList = new ArrayList<>();
    }

    public GreenSpace registerGreenSpace (String name, String address, int type, double area) {
        GreenSpace newGreenSpace = null;
        GreenSpace greenSpace = new GreenSpace (name, address, type, area);
        if (addGreenSpace(greenSpace)) {
            newGreenSpace = greenSpace;
        }
        return newGreenSpace;
    }

    private boolean addGreenSpace (GreenSpace greenSpace) {
        if (validateGreenSpace(greenSpace)) {
            greenSpacesList.add(greenSpace.clone());
            return true;
        } else {
            throw new IllegalArgumentException("Green space already exists in the repository");
        }
    }

    private boolean validateGreenSpace (GreenSpace greenSpace) {
        return !greenSpacesList.contains(greenSpace);
    }

    public List<GreenSpace> getGreenSpacesList() {
        return greenSpacesList;
    }

    @Override
    public String toString() {
        return "Green space=" + greenSpacesList + '}';
    }
}

