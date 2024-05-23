package pprog.ui.menu;

import pprog.session.UserSession;
import pprog.ui.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class GreenSpacesManagerUI implements Runnable {
    public GreenSpacesManagerUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
//        options.add(new MenuItem("Register a Vehicle", new RegisterVehicleUI()));
//        options.add(new MenuItem("Register a vehicle’s maintenance", new RegisterCheckUpUI()));
//        options.add(new MenuItem("Produce a list of vehicles needing maintenance", new VehicleNeedingMaintenanceUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\n--- GREEN SPACES MANAGER MENU -------------------------");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
