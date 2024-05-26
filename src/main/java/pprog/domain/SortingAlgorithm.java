package pprog.domain;

import pprog.domain.greenspace.GreenSpace;

import java.util.List;

public interface SortingAlgorithm {

    List<GreenSpace> sort(List<GreenSpace> managedGreenSpacesList);

}
