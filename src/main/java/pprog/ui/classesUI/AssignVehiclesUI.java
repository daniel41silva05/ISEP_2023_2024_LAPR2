package pprog.ui.classesUI;

import pprog.controller.vehicle.AssignVehiclesController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AssignVehiclesUI implements Runnable {

    private final AssignVehiclesController controller;

    private int entry;
    private List<String> vehiclesPlateNumber;

    public AssignVehiclesUI() {
        controller = new AssignVehiclesController();
    }

    public AssignVehiclesController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\n\n--- Assign vehicles to a task------------------------");

        listAllVehicles();
        listAllEntries();
        requestData();
        submitData();
    }

    private void submitData() {
        String result = getController().assignVehiclesToEntry(entry, vehiclesPlateNumber);
        if (result == null) {
            System.out.println("\nSuccessfully assigned vehicles!");
            System.out.println(getController().getEntryWithVehicles(entry));
        } else {
            System.out.println("Unassigned vehicles!\n" + result);
        }
    }

    private void requestData() {
        entry = requestTask();
        vehiclesPlateNumber = requestVehicles();
    }

    private int requestTask() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Task: ");
                if (input.hasNextInt()) {
                    int type = input.nextInt();
                    if (type > 0 && type <= controller.getEntriesList().size()) {
                        return type;
                    } else {
                        throw new IllegalArgumentException("Invalid input. Please choose a valid option.");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid input. Please choose a valid option.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }
    }

    private List<String> requestVehicles() {
        ArrayList<String> vehiclesList = new ArrayList<>();

        while (true) {
            try {
                System.out.print("Vehicle Plate Number (format: XX XX XX): ");
                Scanner input = new Scanner(System.in);
                String plateNumber = input.nextLine();

                if (plateNumber.matches("[A-Z0-9]{2} [A-Z0-9]{2} [A-Z0-9]{2}")) {
                    vehiclesList.add(plateNumber);
                } else {
                    throw new IllegalArgumentException("Please enter a plate number in the format XX XX XX.");
                }

                System.out.print("Do you want to add another vehicle? (yes/no): ");
                String choice = input.nextLine();
                if (!choice.equalsIgnoreCase("yes")) {
                    if (!choice.equalsIgnoreCase("no")) {
                        throw new IllegalArgumentException("Please enter 'yes' to add another vehicle or 'no' to finish.");
                    }
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        String[] vehiclesToAssign = vehiclesList.toArray(new String[0]);

        return List.of(vehiclesToAssign);
    }

    private void listAllVehicles() {
        if (controller.getVehiclesList().isEmpty()) {
            System.out.println("Vehicles List is empty!");
        } else {
            System.out.println(controller.getVehiclesList());
        }
    }

    private void listAllEntries() {
        if (controller.getEntriesList().isEmpty()) {
            System.out.println("Agenda is empty!");
        } else {
            System.out.println(controller.getEntriesList());
        }
    }
}
