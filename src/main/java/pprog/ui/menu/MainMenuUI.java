package pprog.ui.menu;

import pprog.ui.DevTeamUI;
import pprog.ui.authorization.AuthenticationUI;
import pprog.ui.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class MainMenuUI implements Runnable {

    public MainMenuUI() {
    }

    public void run() {
        List<pprog.ui.menu.MenuItem> options = new ArrayList<pprog.ui.menu.MenuItem>();
        options.add(new pprog.ui.menu.MenuItem("Do Login", new AuthenticationUI()));
        options.add(new MenuItem("Know the Development Team", new DevTeamUI()));
        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\n--- MAIN MENU --------------------------");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }

}
