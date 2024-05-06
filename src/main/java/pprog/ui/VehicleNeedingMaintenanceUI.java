package pprog.ui;

import pprog.controller.RegisterCollaboratorController;
import pprog.controller.VehicleNeedingMaintenanceController;
import pprog.domain.Collaborator;
import pprog.domain.IdDocType;

import java.util.List;

public class VehicleNeedingMaintenanceUI implements Runnable {

    private final VehicleNeedingMaintenanceController controller;

    public VehicleNeedingMaintenanceUI() {
        controller = new VehicleNeedingMaintenanceController();
    }

    private VehicleNeedingMaintenanceController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\n\n--- Produce a list of vehicles needing maintenance ------------------------");

        submitData();
    }

    private void submitData() {

        List<String> vehiclesNeedingMaintenanceList = controller.getVehiclesNeedingMaintenanceList();
        if (vehiclesNeedingMaintenanceList != null) {
            System.out.println(vehiclesNeedingMaintenanceList);
        } else {
            System.out.println("No vehicle needs maintenance");
        }

    }
}
