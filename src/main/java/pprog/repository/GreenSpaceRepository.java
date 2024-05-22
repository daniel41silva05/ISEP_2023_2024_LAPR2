package pprog.repository;

import pprog.domain.gs.GreenSpace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GreenSpaceRepository implements Serializable {

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

    public GreenSpace getGreenSpaceByName(String name) {
        for (GreenSpace gs: greenSpacesList) {
            if (gs.getName().equalsIgnoreCase(name)) {
                return gs;
            }
        }
        throw new IllegalArgumentException("Green space with the name '" + name + "' doesn't exist.");
    }

    @Override
    public String toString() {
        return "Green space=" + greenSpacesList + '}';
    }
}

