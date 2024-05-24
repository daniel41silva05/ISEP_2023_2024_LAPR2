package pprog.ui.classesUI;

import pprog.controller.team.AssignTeamController;
import pprog.domain.Team;
import pprog.domain.agenda.Entry;

import java.util.List;
import java.util.Scanner;

// ESTA CLASSE NAO ESTÁ CORRETA, FOI A PRESSA PARA TESTAR
public class AssignTeamUI implements Runnable {
    private final AssignTeamController controller;

    private int entry;
    private int team;

    public AssignTeamUI() {
        controller = new AssignTeamController();
    }

    public AssignTeamController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\n\n--- Assign a Team ------------------------");

        listAllTeams();
        listAllEntries();
        requestData();
        submitData();
    }

    private void submitData() {
        if (getController().assignTeamToEntry(entry, team)) {
            System.out.println("\nAssign successfully completed!");
        } else {
            System.out.println("Task not completed!");
        }
    }

    private void requestData() {
        entry = request1();
        team = request2();
    }

    private int request1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entry: ");
        return sc.nextInt();
    }

    private int request2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Team: ");
        return sc.nextInt();
    }

    private void listAllTeams() {
        List<Team> teams = controller.getTeamsList();
        System.out.println(teams);
    }

    private void listAllEntries() {
        List<Entry> tasks = controller.getEntriesList();
        System.out.println(tasks);
    }
}
