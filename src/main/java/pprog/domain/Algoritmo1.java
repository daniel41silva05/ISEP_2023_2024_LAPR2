package pprog.domain;

import pprog.interfaces.SortingAlgorithm;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Algoritmo1 implements SortingAlgorithm {

    @Override
    public void sort(List<GreenSpace> managedGreenSpacesList) {
        sortList(managedGreenSpacesList);
    }

    private void sortList(List<GreenSpace> managedGreenSpacesList) {

        Comparator<GreenSpace> comparator = new Comparator<GreenSpace>() {
            @Override
            public int compare(GreenSpace gs1, GreenSpace gs2) {
                return Double.compare(gs2.getArea(), gs1.getArea());
            }
        };

        Collections.sort(managedGreenSpacesList, comparator);
    }
}
