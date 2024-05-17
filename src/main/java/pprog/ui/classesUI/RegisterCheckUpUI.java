package pprog.ui.classesUI;

import pprog.controller.RegisterCheckUpController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * User interface for registering vehicle check-ups.
 */
public class RegisterCheckUpUI implements Runnable {

    /**
     * The controller for handling registration of vehicle check-ups.
     */
    private final RegisterCheckUpController controller;

    /**
     * The number plate of the vehicle for which the check-up is being registered.
     */
    private String vehiclePlateNumber;

    /**
     * The date of the check-up.
     */
    private Date date;

    /**
     * The number of kilometers of the vehicle at the time of the check-up.
     */
    private int kms;

    /**
     * Constructs a RegisterCheckUpUI with a new instance of RegisterCheckUpController.
     */
    public RegisterCheckUpUI() {
        controller = new RegisterCheckUpController();
    }

    /**
     * Gets the controller.
     *
     * @return the RegisterCheckUpController
     */
    private RegisterCheckUpController getController() {
        return controller;
    }

    /**
     * Runs the UI for registering a vehicle check-up.
     */
    public void run() {
        System.out.println("\n\n---  Register a vehicle’s maintenance ------------------------");

        requestData();
        submitData();
    }

    /**
     * Submits the entered data to register the check-up.
     */
    private void submitData() {

        if (getController().registerCheckUp(vehiclePlateNumber, date, kms)) {
            System.out.println("\nVehicle maintenance successfully registed!");
        } else {
            System.out.println("\nVehicle maintenance not registed!");
        }

    }

    /**
     * Requests data from the user to register the check-up.
     */
    private void requestData() {

        vehiclePlateNumber = requestVehiclePlate();
        date = requestDate();
        kms = requestKms();

    }

    /**
     * Requests the vehicle plate number from the user.
     *
     * @return the vehicle plate number entered by the user
     */
    private String requestVehiclePlate() {
        Scanner input = new Scanner(System.in);
        System.out.print("Vehicle Plate Number: ");
        return input.nextLine();
    }

    /**
     * Requests the date of the check-up from the user.
     *
     * @return the date of the check-up entered by the user
     */
    private Date requestDate() {
        Scanner input = new Scanner(System.in);
        System.out.print("Date (format: dd/MM/yyyy): ");
        String dateStr = input.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy format.");
            return requestDate();
        }
    }

    /**
     * Requests the number of kilometers at the time of the check-up from the user.
     *
     * @return the number of kilometers entered by the user
     */
    private int requestKms() {
        Scanner input = new Scanner(System.in);
        int kms;
        do {
            System.out.print("Kms: ");
            kms = input.nextInt();
            if (kms < 0) {
                System.out.println("Please enter a non-negative number.");
            }
        } while (kms < 0);
        return kms;
    }

}
