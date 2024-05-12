package pprog.ui.classesUI;

import pprog.controller.AssignSkillController;
import pprog.domain.Collaborator;
import pprog.domain.Skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents the user interface for assigning skills to a collaborator.
 */
public class AssignSkillUI implements Runnable {

    /**
     * The controller for assigning skills.
     */
    private final AssignSkillController controller;

    /**
     * The collaborator to whom skills will be assigned.
     */
    private Collaborator collaborator;

    /**
     * The list of skills to be assigned.
     */
    private List<Skill> skillsToAssign;

    /**
     * Constructs a new AssignSkillUI object.
     */
    public AssignSkillUI() {
        controller = new AssignSkillController();
    }

    /**
     * Gets the AssignSkillController associated with this UI.
     *
     * @return the AssignSkillController
     */
    private AssignSkillController getController() {
        return controller;
    }

    /**
     * Runs the AssignSkillUI.
     */
    public void run() {
        System.out.println("\n\n--- Assign one or more skills to a Collaborator ------------------------");

        displayCollaborators();
        displaySkills();
        requestData();
        submitData();
    }

    /**
     * Submits the data to assign skills to the collaborator.
     */
    private void submitData() {
        controller.assignSkillToCollaborator(collaborator, skillsToAssign);
    }

    /**
     * Requests collaborator and skills data from the user.
     */
    private void requestData() {
        collaborator = requestCollaborator();
        skillsToAssign = requestSkillsToAssign();
    }

    /**
     * Requests the collaborator name from the user and retrieves the corresponding collaborator.
     *
     * @return the selected collaborator
     */
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

    /**
     * Requests the skills to assign from the user and retrieves the corresponding skills.
     *
     * @return the list of skills to assign
     */
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

    /**
     * Displays the list of existing collaborators.
     */
    private void displayCollaborators() {
        List<Collaborator> collaborators = controller.getCollaboratorList();
        System.out.println("List of existing collaborators: ");
        for (Collaborator collaborator : collaborators) {
            System.out.println(collaborator.getName());
        }
    }

    /**
     * Displays the list of existing skills.
     */
    private void displaySkills() {
        List<Skill> skills = controller.getSkillsList();
        System.out.println("List of existing skills: ");
        for (Skill skill : skills) {
            System.out.println(skill.getSkill());
        }
    }
}
