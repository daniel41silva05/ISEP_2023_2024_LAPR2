package pprog.ui.menu;

import pprog.ui.classesUI.*;
import pprog.ui.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class GreenSpacesManagerUI implements Runnable {
    public GreenSpacesManagerUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
            options.add(new MenuItem("Register a Green Space", new RegisterGreenSpaceUI()));
            options.add(new MenuItem("Add Entry To Do List", new AddTaskToDoListUI()));
            options.add(new MenuItem("Add Entry Agenda", new AddEntryAgendaUI()));
            options.add(new MenuItem("Assign Team Entry Agenda", new AssignTeamUI()));
            options.add(new MenuItem("List Green Spaces managed by GSM", new ListGreenSpacesByGSMUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\n--- GREEN SPACES MANAGER MENU -------------------------");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
