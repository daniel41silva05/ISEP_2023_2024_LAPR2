package pprog.ui.menu;


import pprog.ui.classesUI.RegisterSkillUI;
import pprog.ui.classesUI.RegisterJobUI;
import pprog.ui.classesUI.RegisterCollaboratorUI;
import pprog.ui.classesUI.AssignSkillUI;
import pprog.ui.classesUI.GenerateTeamUI;
import pprog.ui.utils.Utils;

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
