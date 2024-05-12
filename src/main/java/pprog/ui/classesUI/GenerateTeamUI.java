package pprog.ui.classesUI;

import pprog.controller.GenerateTeamController;
import pprog.domain.Collaborator;
import pprog.domain.Skill;

import java.util.ArrayList;
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
    private List<Skill> requiredSkills;

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
        List<Collaborator> team = controller.team(minSize, maxSize, requiredSkills);
        if (team != null) {
            System.out.println("\nTeam generated successfully!\n" + team);
        } else {
            System.out.println("\nTeam generation failed!");
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
        System.out.print("Minimum Size: ");
        return input.nextInt();
    }

    /**
     * Requests the maximum size of the team from the user.
     *
     * @return The maximum size of the team.
     */
    private int requestMaxSize() {
        Scanner input = new Scanner(System.in);
        System.out.print("Maximum Size: ");
        return input.nextInt();
    }

    /**
     * Requests the required skills for the team from the user.
     *
     * @return The list of required skills.
     */
    private List<Skill> requestRequiredSkills() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter required skills for the team (comma-separated): \"");
        String skillNamesInput = input.nextLine();
        String[] skillNames = skillNamesInput.split(",");
        List<Skill> requiredSkills = new ArrayList<>();
        for (String skillName : skillNames) {
            Skill skill = controller.getSkillRepository().getSkillByName(skillName.trim());
            if (skill != null) {
                requiredSkills.add(skill);
            } else {
                throw new IllegalArgumentException("Skill '" + skillName.trim() + "' not found.");
            }
        }
        return requiredSkills;
    }

    /**
     * Displays the list of available skills to the user.
     */
    private void displaySkills() {
        List<Skill> skills = controller.getSkillList();
        System.out.println("List of existing skills: ");
        for (Skill skill : skills) {
            System.out.println(skill.getSkill());
        }
    }
}
