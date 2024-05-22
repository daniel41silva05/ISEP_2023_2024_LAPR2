package pprog.ui.classesUI;

import pprog.controller.team.GenerateTeamController;

import java.util.List;
import java.util.Scanner;

/**
 * User interface for generating teams.
 */
public class GenerateTeamUI implements Runnable {

    /**
     * The controller for managing team generation.
     */
    private final GenerateTeamController controller;

    /**
     * The minimum size of the team.
     */
    private int minSize;

    /**
     * The maximum size of the team.
     */
    private int maxSize;

    /**
     * The list of required skills for the team.
     */
    private List<String> requiredSkills;

    /**
     * Constructs a new GenerateTeamUI with default values.
     */
    public GenerateTeamUI() {
        controller = new GenerateTeamController();
    }

    /**
     * Retrieves the GenerateTeamController associated with this UI.
     *
     * @return The GenerateTeamController.
     */
    private GenerateTeamController getController() {
        return controller;
    }

    /**
     * Runs the GenerateTeamUI.
     */
    public void run() {
        System.out.println("\n\n--- Generate a team proposal automatically ------------------------");

        requestData();
        displaySkills();
        requiredSkills = requestRequiredSkills();
        submitData();
    }

    /**
     * Submits the entered data for team generation.
     */
    private void submitData() {
        if (getController().team(minSize, maxSize, requiredSkills)) {
            System.out.println("\nTeam generated successfully!");
        } else {
            System.out.println("Team generation failed!");
        }
    }

    /**
     * Requests data from the user.
     */
    private void requestData() {
        minSize = requestMinSize();
        maxSize = requestMaxSize();
    }

    /**
     * Requests the minimum size of the team from the user.
     *
     * @return The minimum size of the team.
     */
    private int requestMinSize() {
        Scanner input = new Scanner(System.in);
        int minSize = 0;
        do {
            System.out.print("Minimum Size: ");
            minSize = input.nextInt();
            if (minSize < 1) {
                System.out.println("Please enter a number greater than 1.");
            }
        } while (minSize < 1);
        return minSize;
    }

    /**
     * Requests the maximum size of the team from the user.
     *
     * @return The maximum size of the team.
     */
    private int requestMaxSize() {
        Scanner input = new Scanner(System.in);
        int maxSize = 0;
        do {
            System.out.print("Maximum Size: ");
            maxSize = input.nextInt();
            if (maxSize < 1) {
                System.out.println("Please enter a number greater than 1.");
            }
        } while (maxSize < 1);
        return maxSize;
    }

    /**
     * Requests the required skills for the team from the user.
     *
     * @return The list of required skills.
     */
    private List<String> requestRequiredSkills() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter required skills for the team (comma-separated): ");
        String skillNamesInput = input.nextLine();
        String[] skillNames = skillNamesInput.split(",");
        return List.of(skillNames);
    }

    /**
     * Displays the list of available skills to the user.
     */
    private void displaySkills() {

        System.out.println("List of existing skills: ");
        System.out.println(getController().getSkillList());

    }
}
