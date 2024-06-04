package pprog.ui.console;

import pprog.controller.AssignTeamController;

import java.util.Scanner;

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
        System.out.println("\n\n--- Assign a Team to a Task------------------------");

        listAllTeams();
        listAllEntries();
        requestData();
        submitData();
    }

    private void submitData() {
        String result = getController().assignTeamToEntry(entry, team);
        if (result == null) {
            System.out.println("\nSuccessfully assigned team!");
            System.out.println(getController().getEntryWithTeam(entry));
        } else {
            System.out.println("Unassigned team!\n" + result);
        }
    }

    private void requestData() {
        entry = requestTask();
        team = requestTeam();
    }

    private int requestTask() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Task: ");
                if (input.hasNextInt()) {
                    int type = input.nextInt();
                    if (type > 0 && type <= controller.getEntriesList().size()) {
                        return type;
                    } else {
                        throw new IllegalArgumentException("Invalid input. Please choose a valid option.");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid input. Please choose a valid option.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }
    }

    private int requestTeam() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Team: ");
                if (input.hasNextInt()) {
                    int team = input.nextInt();
                    if (team > 0 && team <= controller.getTeamsList().size()) {
                        return team;
                    } else {
                        throw new IllegalArgumentException("Invalid input. Please choose a valid option.");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid input. Please choose a valid option.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }
    }

    private void listAllTeams() {
        if (controller.getTeamsList().isEmpty()) {
            System.out.println("Team List is empty!");
        } else {
            System.out.println(controller.getTeamsList());
        }
    }

    private void listAllEntries() {
        if (controller.getEntriesList().isEmpty()) {
            System.out.println("Agenda is empty!");
        } else {
            System.out.println(controller.getEntriesList());
        }
    }
}
