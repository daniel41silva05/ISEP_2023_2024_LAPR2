package pprog.ui.classesUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import pprog.controller.RegisterCollaboratorController;
import pprog.domain.Collaborator;
import pprog.domain.IdDocType;
import pprog.domain.Job;

/**
 * User interface for registering a collaborator.
 */
public class RegisterCollaboratorUI implements Runnable {

    /**
     * The controller for registering collaborators.
     */
    private final RegisterCollaboratorController controller;

    /**
     * The name of the collaborator.
     */
    private String name;

    /**
     * The birthday of the collaborator.
     */
    private Date birthday;

    /**
     * The admission date of the collaborator.
     */
    private Date admissionDate;

    /**
     * The address of the collaborator.
     */
    private String address;

    /**
     * The phone number of the collaborator.
     */
    private int phoneNumber;

    /**
     * The email of the collaborator.
     */
    private String email;

    /**
     * The type of ID document of the collaborator.
     */
    private IdDocType idDocType;

    /**
     * The ID number of the collaborator.
     */
    private int idNumber;

    /**
     * The job of the collaborator.
     */
    private String job;

    /**
     * Constructs a RegisterCollaboratorUI with a new instance of RegisterCollaboratorController.
     */
    public RegisterCollaboratorUI() {
        controller = new RegisterCollaboratorController();
    }

    /**
     * Gets the controller.
     *
     * @return the controller
     */
    private RegisterCollaboratorController getController() {
        return controller;
    }

    /**
     * Runs the UI.
     */
    public void run() {
        System.out.println("\n\n--- Register a Collaborator ------------------------");

        requestData();
        displayJobs();
        job = requestJobName();
        submitData();
    }

    /**
     * Submits data to register the collaborator.
     */
    private void submitData() {

        Collaborator collaborator = controller.registerCollaborator(name, birthday, admissionDate, address, phoneNumber, email, idDocType, idNumber, job);
        if (collaborator != null) {
            System.out.println("\nCollaborator successfully registed!");
        } else {
            System.out.println("\nCollaborator not registed!");
        }

    }

    /**
     * Requests data from the user.
     */
    private void requestData() {

        name = requestName();
        birthday = requestBirthday();
        admissionDate = requestAdmissionDate();
        address = requestAddress();
        phoneNumber = requestPhoneNumber();
        email = requestEmail();
        idDocType = requestIdDocType();
        idNumber = requestIdNumber(idDocType);

    }

    /**
     * Requests the name of the collaborator from the user.
     *
     * @return the name entered by the user
     */
    private String requestName() {
        Scanner input = new Scanner(System.in);
        String name;
        do {
            System.out.print("Name: ");
            name = input.nextLine().trim();
            if (!name.matches("[a-zA-Z ]+")) {
                System.out.println("Invalid name. Please enter a valid name.");
            }
            if (name.split("\\s+").length > 6) {
                System.out.println("Invalid name. Please enter a valid name with at most 6 words.");
            }
        } while (!name.matches("[a-zA-Z ]+") || name.split("\\s+").length > 6);
        return name;
    }

    /**
     * Requests the birthday of the collaborator from the user.
     *
     * @return the birthday entered by the user
     */
    private Date requestBirthday() {
        Scanner input = new Scanner(System.in);
        System.out.print("Birthday (format: dd/MM/yyyy): ");
        String dateStr = input.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy format.");
            return requestBirthday();
        }
    }

    /**
     * Requests the admission date of the collaborator from the user.
     *
     * @return the admission date entered by the user
     */
    private Date requestAdmissionDate() {
        Scanner input = new Scanner(System.in);
        System.out.print("Admission Date (format: dd/MM/yyyy): ");
        String dateStr = input.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy format.");
            return requestAdmissionDate();
        }
    }

    /**
     * Requests the address of the collaborator from the user.
     *
     * @return the address entered by the user
     */
    private String requestAddress() {
        Scanner input = new Scanner(System.in);
        String address;
        do {
            System.out.print("Address (street, zipcode, city): ");
            address = input.nextLine().trim();
            String[] parts = address.split(",");
            if (parts.length != 3) {
                System.out.println("Invalid address format. Please enter the address including street, zipcode, and city.");
                continue;
            }
            String zipcode = parts[1].trim();
            if (!zipcode.matches("\\d{4}-\\d{3}")) {
                System.out.println("Invalid zipcode format. Please enter a valid zipcode (format: xxxx-xxx).");
                continue;
            }
            return address;
        } while (true);
    }

    /**
     * Requests the phone number of the collaborator from the user.
     *
     * @return the phone number entered by the user
     */
    private int requestPhoneNumber() {
        Scanner input = new Scanner(System.in);
        int phoneNumber;
        do {
            System.out.print("Phone Number: ");
            phoneNumber = input.nextInt();
            if (!String.valueOf(phoneNumber).matches("\\d{9}")) {
                System.out.println("Invalid phone number. Please enter a 9-digit number.");
            }
        } while (!String.valueOf(phoneNumber).matches("\\d{9}"));
        return phoneNumber;
    }

    /**
     * Requests the email of the collaborator from the user.
     *
     * @return the email entered by the user
     */
    private String requestEmail() {
        Scanner input = new Scanner(System.in);
        String email;
        do {
            System.out.print("Email: ");
            email = input.nextLine().trim();
            // Verifica se o email está em um formato válido
            if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                System.out.println("Invalid email. Please enter a valid email.");
            }
        } while (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"));
        return email;
    }

    /**
     * Requests the type of ID document of the collaborator from the user.
     *
     * @return the ID document type selected by the user
     */
    private IdDocType requestIdDocType() {
        Scanner input = new Scanner(System.in);
        System.out.println("Id Document Type: ");
        System.out.println("1 - Taxpayer Number");
        System.out.println("2 - Citizen Card");
        System.out.println("3 - Passport");
        int idDocTypeInput = input.nextInt();

        switch (idDocTypeInput) {
            case 1:
                return IdDocType.TAXPAYER_NUMBER;
            case 2:
                return IdDocType.CITIZEN_CARD;
            case 3:
                return IdDocType.PASSPORT;
            default:
                System.out.println("Invalid input. Please choose a valid option.");
                return requestIdDocType();
        }
    }

    /**
     * Requests the ID number of the collaborator from the user.
     *
     * @param idDocType the type of ID document of the collaborator
     * @return the ID number entered by the user
     */
    private int requestIdNumber(IdDocType idDocType) {
        Scanner input = new Scanner(System.in);
        int idNumber;
        do {
            System.out.print("ID Number: ");
            idNumber = input.nextInt();
            switch (idDocType) {
                case TAXPAYER_NUMBER:
                    if (String.valueOf(idNumber).length() != 9) {
                        System.out.println("Invalid taxpayer number. Please enter a 9-digit number.");
                        idNumber = -1;
                    }
                    break;
                case CITIZEN_CARD:
                    if (String.valueOf(idNumber).length() != 8) {
                        System.out.println("Invalid citizen card number. Please enter an 8-digit number.");
                        idNumber = -1;
                    }
                    break;
                case PASSPORT:
                    if (!String.valueOf(idNumber).matches("[a-zA-Z]\\d{6}")) {
                        System.out.println("Invalid passport number. Please enter a letter followed by 6 digits.");
                        idNumber = -1;
                    }
                    break;
            }
        } while (idNumber == -1);
        return idNumber;
    }

    /**
     * Requests the job of the collaborator from the user.
     *
     * @return the job entered by the user
     */
    private String requestJobName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Job: ");
        return input.nextLine();
    }

    /**
     * Displays the list of jobs.
     */
    private void displayJobs() {

        List<Job> jobs = controller.getJobsList();

        System.out.println("List of existing jobs: ");
        for (Job job : jobs) {
            System.out.println(job.getName());
        }

    }
}
