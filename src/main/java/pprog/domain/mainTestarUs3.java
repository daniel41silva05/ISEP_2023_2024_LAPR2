package pprog.domain;

import pprog.controller.RegisterCollaboratorController;
import pprog.domain.Collaborator;
import pprog.domain.Date;
import pprog.domain.IdDocType;
import pprog.domain.Job;

import java.util.List;
import java.util.Scanner;

public class mainTestarUs3 {

    private static final RegisterCollaboratorController controller = new RegisterCollaboratorController();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Colaborator Registration System ===");
            System.out.println("1. Register a new collaborator");
            System.out.println("2. View all available jobs");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    registerCollaborator();
                    break;
                case 2:
                    viewAllJobs();
                    break;
                case 3:
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
        Date birthday = parseDateInput(scanner.nextLine());
        System.out.print("Admission Date (DD/MM/YYYY): ");
        Date admissionDate = parseDateInput(scanner.nextLine());
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

        Collaborator collaborator = controller.registerCollaborator(name, birthday, admissionDate, address, phoneNumber, email, idDocType, idNumber, jobName);
        System.out.println("Collaborator registered successfully:");
        System.out.println(collaborator);
    }

    private static void viewAllJobs() {
        System.out.println("\n=== All Available Jobs ===");
        List<Job> jobs = controller.getJobsList();
        for (Job job : jobs) {
            System.out.println(job.getName() + " - " + job.getDescription());
        }
    }

    private static Date parseDateInput(String input) {
        String[] parts = input.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        return new Date(day, month, year);
    }
}
