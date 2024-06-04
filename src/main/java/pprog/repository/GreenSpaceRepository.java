package pprog.repository;

import pprog.interfaces.SortingAlgorithm;
import pprog.domain.GreenSpace;
import pprog.domain.GreenSpacesManager;
import pprog.session.ApplicationSession;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GreenSpaceRepository implements Serializable {

    private final List<GreenSpace> greenSpacesList;

    public GreenSpaceRepository() {
        greenSpacesList = new ArrayList<>();
    }

    public GreenSpace registerGreenSpace (String name, String[] address, int type, double area, GreenSpacesManager greenSpacesManager) {
        GreenSpace newGreenSpace = null;
        GreenSpace greenSpace = new GreenSpace (name, address, type, area, greenSpacesManager);
        if (addGreenSpace(greenSpace)) {
            newGreenSpace = greenSpace;
        }
        return newGreenSpace;
    }

    private boolean addGreenSpace (GreenSpace greenSpace) {
        if (validateGreenSpace(greenSpace)) {
            greenSpacesList.add(greenSpace);
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

    public List<GreenSpace> getGreenSpaceListByGSM(GreenSpacesManager gsmFromSession) {
        List<GreenSpace> greenSpacesListByGSM = new ArrayList<>();

        for (GreenSpace gs: getGreenSpacesList()) {
            if (gs.getGreenSpacesManager().equals(gsmFromSession)) {
                greenSpacesListByGSM.add(gs);
            }
        }
        return greenSpacesListByGSM;
    }

    public List<GreenSpace> sortListByAlgorithm(GreenSpacesManager gsmFromSession) {
        SortingAlgorithm algorithm;
        try {
            algorithm = ApplicationSession.getSortingAlgorithm();
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        List<GreenSpace> sortedgreenSpacesListByGSM = getGreenSpaceListByGSM(gsmFromSession);
        algorithm.sort(sortedgreenSpacesListByGSM);
        return sortedgreenSpacesListByGSM;
    }

    @Override
    public String toString() {
        return greenSpacesList.toString();
    }
}

