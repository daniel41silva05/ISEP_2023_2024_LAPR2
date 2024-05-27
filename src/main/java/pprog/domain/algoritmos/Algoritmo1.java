package pprog.domain.algoritmos;

import pprog.domain.greenspace.GreenSpace;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Algoritmo1 implements SortingAlgorithm {

    @Override
    public void sort(List<GreenSpace> managedGreenSpacesList) {
        sortList(managedGreenSpacesList);
    }

    private void sortList(List<GreenSpace> managedGreenSpacesList) {
        // Comparator to compare GreenSpace objects by their area in descending order
        Comparator<GreenSpace> comparator = new Comparator<GreenSpace>() {
            @Override
            public int compare(GreenSpace gs1, GreenSpace gs2) {
                return Double.compare(gs2.getArea(), gs1.getArea());
            }
        };

        // Sort the list using the comparator
        Collections.sort(managedGreenSpacesList, comparator);
    }
}
