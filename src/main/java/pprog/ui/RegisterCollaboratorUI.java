package pprog.ui;

import pprog.controller.RegisterCollaboratorController;
import pprog.domain.Collaborator;
import pprog.domain.IdDocType;
import pprog.domain.Job;

import java.util.List;
import java.util.Scanner;

public class RegisterCollaboratorUI implements Runnable {

    private final RegisterCollaboratorController controller;
    private String name;
    private String birthday;
    private String admissionDate;
    private String address;
    private int phoneNumber;
    private String email;
    private IdDocType idDocType;
    private int idNumber;
    private String job;

    public RegisterCollaboratorUI() {
        controller = new RegisterCollaboratorController();
    }

    private RegisterCollaboratorController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\n\n--- Register a Collaborator ------------------------");

        requestData();
        displayJobs();
        job = requestJobName();
        submitData();
    }

    private void submitData() {

        Collaborator collaborator = controller.registerCollaborator(name, birthday, admissionDate, address, phoneNumber, email, idDocType, idNumber, job);
        if (collaborator != null) {
            System.out.println("\nCollaborator successfully registed!");
        } else {
            System.out.println("\nCollaborator not registed!");
        }

    }

    private void requestData() {

        name = requestName();
        birthday = requestBirthday();
        admissionDate = requestAdmissionDate();
        address = requestAddress();
        phoneNumber = requestPhoneNumber();
        email = requestEmail();
        idDocType = requestIdDocType();
        idNumber = requestIdNumber();

    }

    private String requestName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Name: ");
        return input.nextLine();
    }

    private String requestBirthday() {
        Scanner input = new Scanner(System.in);
        System.out.print("Birthday: ");
        return input.nextLine();
    }

    private String requestAdmissionDate() {
        Scanner input = new Scanner(System.in);
        System.out.print("Admission Date: ");
        return input.nextLine();
    }

    private String requestAddress() {
        Scanner input = new Scanner(System.in);
        System.out.print("Address: ");
        return input.nextLine();
    }

    private int requestPhoneNumber() {
        Scanner input = new Scanner(System.in);
        System.out.print("Phone Number: ");
        return input.nextInt();
    }

    private String requestEmail() {
        Scanner input = new Scanner(System.in);
        System.out.print("Email: ");
        return input.nextLine();
    }

    private IdDocType requestIdDocType() {
        Scanner input = new Scanner(System.in);
        System.out.println("Id Document Type: ");
        System.out.println("1 - Taxpayer Number");
        System.out.println("2 - Citizen Card");
        System.out.println("3 - Passport");
        int idDocTypeInput = input.nextInt();
        if (idDocTypeInput == 1) {
            IdDocType idDocType = IdDocType.TAXPAYER_NUMBER;
        }
        if (idDocTypeInput == 2) {
            IdDocType idDocType = IdDocType.CITIZEN_CARD;
        }
        if (idDocTypeInput == 3) {
            IdDocType idDocType = IdDocType.PASSPORT;
        }
        return idDocType;
    }

    private int requestIdNumber() {
        Scanner input = new Scanner(System.in);
        System.out.print("ID Number: ");
        return input.nextInt();
    }

    private String requestJobName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Job: ");
        return input.nextLine();
    }

    private void displayJobs() {

        List<Job> jobs = controller.getJobsList();

        System.out.println("List of existing jobs: ");
        for (Job job : jobs) {
            System.out.println(job.getName());
        }

    }
}
