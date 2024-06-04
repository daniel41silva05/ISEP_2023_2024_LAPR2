package pprog.ui.console;

import pprog.controller.ListGreenSpacesByGSMController;
import pprog.domain.GreenSpace;

import java.util.List;

public class ListGreenSpacesByGSMUI implements Runnable{

    private final ListGreenSpacesByGSMController controller;

    public ListGreenSpacesByGSMUI() {
        controller = new ListGreenSpacesByGSMController();
    }

    private ListGreenSpacesByGSMController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\n\n--- List of Green Spaces Managed by GSM ------------------------");

        List<GreenSpace> sortedGreenSpaces = getController().sortListByAlgorithm();

        if (sortedGreenSpaces.isEmpty()) {
            System.out.println("No green spaces managed by the current GSM.");
        } else {
            for (GreenSpace gs : sortedGreenSpaces) {
                System.out.println(gs);
            }
        }
    }
}
