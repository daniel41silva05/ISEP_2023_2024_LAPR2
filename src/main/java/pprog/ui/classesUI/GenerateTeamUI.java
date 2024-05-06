package pprog.ui.classesUI;

import pprog.controller.GenerateTeamController;
import pprog.domain.Collaborator;
import pprog.domain.Skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateTeamUI implements Runnable {

    private final GenerateTeamController controller;

    private int minSize;
    private int maxSize;
    private List<Skill> requiredSkills;

    public GenerateTeamUI() {
        controller = new GenerateTeamController();
    }

    private GenerateTeamController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\n\n--- Generate a team proposal automatically ------------------------");

        requestData();
        displaySkills();
        requiredSkills = requestRequiredSkills();
        submitData();
    }

    private void submitData() {

        List <Collaborator> team = controller.team(minSize, maxSize, requiredSkills);
        if (team != null) {
            System.out.println("\nTeam generated successfully!\n" + team);
        } else {
            System.out.println("\nTeam generated not generated!");
        }

    }

    private void requestData() {

        minSize = requestMinSize();
        maxSize = requestMaxSize();

    }

    private int requestMinSize() {
        Scanner input = new Scanner(System.in);
        System.out.print("Minimum Size: ");
        return input.nextInt();
    }

    private int requestMaxSize() {
        Scanner input = new Scanner(System.in);
        System.out.print("Maximum Size: ");
        return input.nextInt();
    }

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

    private void displaySkills() {

        List<Skill> skills = controller.getSkillList();

        System.out.println("List of existing skills: ");
        for (Skill skill : skills) {
            System.out.println(skill.getSkill());
        }

    }
}
