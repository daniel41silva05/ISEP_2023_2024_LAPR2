package pprog.ui.classesUI;

import pprog.controller.AssignSkillController;
import pprog.domain.Collaborator;
import pprog.domain.Skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AssignSkillUI implements Runnable {
    private final AssignSkillController controller;
    private Collaborator collaborator;
    private List<Skill> skillsToAssign;

    public AssignSkillUI() {
        controller = new AssignSkillController();
    }

    private AssignSkillController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\n\n--- Assign one or more skills to a Collaborator ------------------------");

        displayCollaborators();
        displaySkills();
        requestData();
        submitData();
    }

    private void submitData() {

        controller.assignSkillToCollaborator(collaborator, skillsToAssign);

    }

    private void requestData() {

        collaborator = requestCollaborator();
        skillsToAssign = requestSkillsToAssign();

    }

    private Collaborator requestCollaborator() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of the collaborator: ");
        String collaboratorName = input.nextLine();
        Collaborator collaborator = controller.getCollaboratorByName(collaboratorName);
        if (collaborator == null) {
            throw new IllegalArgumentException("Collaborator not found: " + collaboratorName);
        }
        return collaborator;
    }

    private List<Skill> requestSkillsToAssign() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter skill names (comma-separated) to assign to the collaborator: ");
        String skillNamesInput = input.nextLine();
        String[] skillNames = skillNamesInput.split(",");
        List<Skill> skillsToAssign = new ArrayList<>();
        for (String skillName : skillNames) {
            Skill skill = controller.getSkillRepository().getSkillByName(skillName.trim());
            if (skill != null) {
                skillsToAssign.add(skill);
            } else {
                throw new IllegalArgumentException("Skill '" + skillName.trim() + "' not found.");
            }
        }
        return skillsToAssign;
    }

    private void displayCollaborators() {

        List<Collaborator> collaborators = controller.getCollaboratorList();

        System.out.println("List of existing collaborators: ");
        for (Collaborator collaborator : collaborators) {
            System.out.println(collaborator.getName());
        }

    }

    private void displaySkills() {

        List<Skill> skills = controller.getSkillsList();

        System.out.println("List of existing skills: ");
        for (Skill skill : skills) {
            System.out.println(skill.getSkill());
        }

    }

}
