package pprog.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pprog.controller.AssignSkillController;
import pprog.controller.RegisterCollaboratorController;
import pprog.controller.RegisterJobController;
import pprog.controller.RegisterSkillController;

public class mainTestarUs1eUs2eUS3eUs4 {

    private static final RegisterCollaboratorController collabController = new RegisterCollaboratorController();
    private static final RegisterJobController jobController = new RegisterJobController();
    private static final AssignSkillController skillController = new AssignSkillController();
    private static final RegisterSkillController registerSkillController = new RegisterSkillController();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Colaborator Registration System ===");
            System.out.println("1. Register a new collaborator");
            System.out.println("2. Register a new job");
            System.out.println("3. Register a new skill");
            System.out.println("4. Assign skills to a collaborator");
            System.out.println("5. Show registered collaborators");
            System.out.println("6. Show registered jobs");
            System.out.println("7. Show registered skills");
            System.out.println("8. Show skills of a collaborator");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    registerCollaborator();
                    break;
                case 2:
                    registerJob();
                    break;
                case 3:
                    registerSkill();
                    break;
                case 4:
                    assignSkills();
                    break;
                case 5:
                    showRegisteredCollaborators();
                    break;
                case 6:
                    showRegisteredJobs();
                    break;
                case 7:
                    showRegisteredSkills();
                    break;
                case 8:
                    showCollaboratorSkills();
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }

        System.out.println("Goodbye!");
    }

    private static void registerCollaborator() {
        System.out.println("\n=== Register a New Collaborator ===");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Birthday (DD/MM/YYYY): ");
        String birthday = scanner.nextLine();
        System.out.print("Admission Date (DD/MM/YYYY): ");
        String admissionDate = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Phone Number: ");
        int phoneNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("ID Document Type (1 for Passport, 2 for ID Card): ");
        int idDocTypeInput = scanner.nextInt();
        IdDocType idDocType = (idDocTypeInput == 1) ? IdDocType.PASSPORT : IdDocType.PASSPORT;
        scanner.nextLine(); // Consume newline character
        System.out.print("ID Number: ");
        int idNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Job Name: ");
        String jobName = scanner.nextLine();

        Collaborator collaborator = collabController.registerCollaborator(name, birthday, admissionDate, address, phoneNumber, email, idDocType, idNumber, jobName);
        System.out.println("Collaborator registered successfully:");
        System.out.println(collaborator);
    }

    private static void registerJob() {
        System.out.println("\n=== Register a New Job ===");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();

        Job job = jobController.registerJob(name, description);
        System.out.println("Job registered successfully:");
        System.out.println(job);
    }

    private static void registerSkill() {
        System.out.println("\n=== Register a New Skill ===");
        System.out.print("Skill Name: ");
        String skillName = scanner.nextLine();

        boolean success = registerSkillController.registerSkill(skillName);
        if (success) {
            System.out.println("Skill registered successfully.");
        } else {
            System.out.println("Failed to register skill. Please try again.");
        }
    }

    private static void assignSkills() {
        System.out.println("\n=== Assign Skills to a Collaborator ===");

        System.out.print("Enter the name of the collaborator: ");
        String collaboratorName = scanner.nextLine();
        Collaborator collaborator = skillController.getCollaboratorByName(collaboratorName);

        if (collaborator == null) {
            System.out.println("Collaborator not found.");
            return;
        }

        System.out.print("Enter skill names (comma-separated) to assign to the collaborator: ");
        String skillNamesInput = scanner.nextLine();
        String[] skillNames = skillNamesInput.split(",");
        List<Skill> skillsToAssign = new ArrayList<>();
        for (String skillName : skillNames) {
            Skill skill = skillController.getSkillRepository().getSkillByName(skillName.trim());
            if (skill != null) {
                skillsToAssign.add(skill);
            } else {
                System.out.println("Skill '" + skillName.trim() + "' not found.");
            }
        }

        if (skillsToAssign.isEmpty()) {
            System.out.println("No valid skills to assign.");
            return;
        }

        skillController.assignSkillToCollaborator(collaborator, skillsToAssign);
        System.out.println("Skills assigned to " + collaboratorName + " successfully.");
    }

    private static void showRegisteredCollaborators() {
        System.out.println("\n=== Registered Collaborators ===");
        List<Collaborator> collaborators = collabController.getCollaboratorsList();
        if (collaborators.isEmpty()) {
            System.out.println("No collaborators registered yet.");
        } else {
            for (Collaborator collaborator : collaborators) {
                System.out.println(collaborator);
            }
        }
    }

    private static void showRegisteredJobs() {
        System.out.println("\n=== Registered Jobs ===");
        List<Job> jobs = jobController.getJobsList();
        if (jobs.isEmpty()) {
            System.out.println("No jobs registered yet.");
        } else {
            for (Job job : jobs) {
                System.out.println(job);
            }
        }
    }

    private static void showRegisteredSkills() {
        System.out.println("\n=== Registered Skills ===");
        List<Skill> skills = registerSkillController.getSkillsList();
        if (skills.isEmpty()) {
            System.out.println("No skills registered yet.");
        } else {
            for (Skill skill : skills) {
                System.out.println(skill.getSkill());
            }
        }
    }

    private static void showCollaboratorSkills() {
        System.out.println("\n=== Show Collaborator Skills ===");
        System.out.print("Enter the name of the collaborator: ");
        String collaboratorName = scanner.nextLine();
        Collaborator collaborator = skillController.getCollaboratorByName(collaboratorName);

        if (collaborator == null) {
            System.out.println("Collaborator not found.");
            return;
        }

        List<Skill> skills = skillController.getSkillsOfCollaborator(collaborator);
        if (skills.isEmpty()) {
            System.out.println("No skills assigned to this collaborator yet.");
            return;
        }

        System.out.println("Skills of " + collaboratorName + ":");
        for (Skill skill : skills) {
            System.out.println(skill.getSkill());
        }
    }
}


