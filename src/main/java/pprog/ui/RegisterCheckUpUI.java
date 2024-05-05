package pprog.ui;

import pprog.domain.CheckUp;
import pprog.controller.RegisterCheckUpController;

import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * User interface class responsible for registering check-ups.
 */
public class RegisterCheckUpUI {

    private final RegisterCheckUpController controller;

    /**
     * Default constructor.
     */
    public RegisterCheckUpUI() {
        controller = new RegisterCheckUpController();
    }

    /**
     * Constructor with a specific check-up controller.
     * @param controller The check-up controller to be set.
     */
    public RegisterCheckUpUI(RegisterCheckUpController controller) {
        this.controller = controller;
    }

    /**
     * Starts the user interface for registering check-ups.
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Check-Up Registration System!");

        boolean exit = false;
        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Register a new check-up");
            System.out.println("2. View all check-ups");
            System.out.println("3. Exit");

            int option;
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // clear the input buffer
                continue;
            }

            switch (option) {
                case 1:
                    registerCheckUp(scanner);
                    break;
                case 2:
                    viewCheckUps();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose a number between 1 and 3.");
            }
        }

        System.out.println("Goodbye!");
        scanner.close();
    }

    /**
     * Registers a new check-up based on user input.
     * @param scanner The scanner object to read user input.
     */
    private void registerCheckUp(Scanner scanner) {
        System.out.println("\nEnter vehicle plate number:");
        String plateNumber = scanner.next();

        System.out.println("Enter check-up date (DD MM YYYY):");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();
        Date date = new Date(day, month, year);

        System.out.println("Enter kilometers covered:");
        int kms = scanner.nextInt();

        CheckUp checkUp = controller.registerCheckUp(plateNumber, date, kms);
        if (checkUp != null) {
            System.out.println("\nCheck-up registered successfully:");
            System.out.println(checkUp);
        } else {
            System.out.println("\nFailed to register check-up. Please check your input.");
        }
    }

    /**
     * Displays all registered check-ups.
     */
    private void viewCheckUps() {
        List<CheckUp> checkUpList = controller.getCheckUpList();
        if (checkUpList.isEmpty()) {
            System.out.println("\nNo check-ups registered yet.");
        } else {
            System.out.println("\nRegistered check-ups:");
            for (CheckUp checkUp : checkUpList) {
                System.out.println(checkUp);
            }
        }
    }
}
