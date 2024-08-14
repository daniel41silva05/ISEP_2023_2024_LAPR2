package app.ui.console.menu;


import app.ui.console.RegisterSkillUI;
import app.ui.console.RegisterJobUI;
import app.ui.console.RegisterCollaboratorUI;
import app.ui.console.AssignSkillUI;
import app.ui.console.GenerateTeamUI;
import app.ui.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class HumanResourcesManagerUI implements Runnable {
    public HumanResourcesManagerUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Register Skills", new RegisterSkillUI()));
        options.add(new MenuItem("Register Job", new RegisterJobUI()));
        options.add(new MenuItem("Register a Collaborator", new RegisterCollaboratorUI()));
        options.add(new MenuItem("Assign one or more skills to a Collaborator", new AssignSkillUI()));
        options.add(new MenuItem("Generate a team proposal automatically", new GenerateTeamUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\n--- HUMAN RESOURCES MANAGER MENU -------------------------");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
