package pprog.ui.classesUI;

import pprog.domain.CheckUp;
import pprog.controller.RegisterCheckUpController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class RegisterCheckUpUI implements Runnable {

    private final RegisterCheckUpController controller;

    private String vehiclePlateNumber;
    private Date date;
    private int kms;

    public RegisterCheckUpUI() {
        controller = new RegisterCheckUpController();
    }

    private RegisterCheckUpController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\n\n---  Register a vehicle’s maintenance ------------------------");

        requestData();
        submitData();
    }

    private void submitData() {

        CheckUp checkUp = controller.registerCheckUp(vehiclePlateNumber, date, kms);
        if (checkUp != null) {
            System.out.println("\nVehicle maintenance successfully registed!");
        } else {
            System.out.println("\nVehicle maintenance not registed!");
        }

    }

    private void requestData() {

        vehiclePlateNumber = requestVehiclePlate();
        date = requestDate();
        kms = requestKms();

    }

    private String requestVehiclePlate() {
        Scanner input = new Scanner(System.in);
        System.out.print("Vehicle Plate Number: ");
        return input.nextLine();
    }

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

    private int requestKms() {
        Scanner input = new Scanner(System.in);
        System.out.print("Kms: ");
        return input.nextInt();
    }

}
