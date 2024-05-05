package pprog.ui.menu;


import pprog.ui.RegisterSkillUI;
import pprog.ui.RegisterJobUI;
import pprog.ui.RegisterCollaboratorUI;
import pprog.ui.AssignSkillUI;
import pprog.ui.GenerateTeamUI;
import pprog.ui.RegisterVehicleUI;
import pprog.ui.RegisterCheckUpUI;
import pprog.ui.VehicleNeedingMaintenanceUI;
import pprog.ui.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class AdminUI implements Runnable {
    public AdminUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Register Skills", new RegisterSkillUI()));
        options.add(new MenuItem("Register Job", new RegisterJobUI()));
        options.add(new MenuItem("Register a Collaborator", new RegisterCollaboratorUI()));
        options.add(new MenuItem("Assign one or more skills to a Collaborator", new AssignSkillUI()));
        options.add(new MenuItem("Generate a team proposal automatically", new GenerateTeamUI()));
        options.add(new MenuItem("Register a Vehicle", new RegisterVehicleUI()));
        options.add(new MenuItem("Register a vehicle’s maintenance", new RegisterCheckUpUI()));
        options.add(new MenuItem("Produce a list of vehicles needing maintenance", new VehicleNeedingMaintenanceUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\n--- ADMIN MENU -------------------------");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
