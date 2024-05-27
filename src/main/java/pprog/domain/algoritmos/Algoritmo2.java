package pprog.domain.algoritmos;

import pprog.domain.greenspace.GreenSpace;

import java.util.List;

public class Algoritmo2 implements SortingAlgorithm {

    @Override
    public void sort(List<GreenSpace> managedGreenSpacesList) {
        sortList(managedGreenSpacesList);
    }

    private void sortList(List<GreenSpace> managedGreenSpacesList) {
        boolean swapped;

        // Bubble Sort Algorithm to sort by area in descending order
        for (int i = 0; i < managedGreenSpacesList.size()- 1; i++) {
            swapped = false;
            for (int j = 0; j < managedGreenSpacesList.size() - i - 1; j++) {
                if (managedGreenSpacesList.get(j).getArea() < managedGreenSpacesList.get(j + 1).getArea()) {
                    // Swap managedGreenSpacesList[j] and managedGreenSpacesList[j + 1]
                    GreenSpace temp = managedGreenSpacesList.get(j);
                    managedGreenSpacesList.set(j, managedGreenSpacesList.get(j + 1));
                    managedGreenSpacesList.set(j + 1, temp);
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then the list is sorted
            if (!swapped) break;
        }
    }
}
