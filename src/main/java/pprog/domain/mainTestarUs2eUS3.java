package pprog.domain;

import java.util.List;
import java.util.Scanner;

import pprog.controller.RegisterCollaboratorController;
import pprog.controller.RegisterJobController;

public class mainTestarUs2eUS3 {

    private static final RegisterCollaboratorController collabController = new RegisterCollaboratorController();
    private static final RegisterJobController jobController = new RegisterJobController();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Colaborator Registration System ===");
            System.out.println("1. Register a new collaborator");
            System.out.println("2. Register a new job");
            System.out.println("3. Show registered collaborators");
            System.out.println("4. Show registered jobs");
            System.out.println("5. Exit");
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
                    showRegisteredCollaborators();
                    break;
                case 4:
                    showRegisteredJobs();
                    break;
                case 5:
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

}


