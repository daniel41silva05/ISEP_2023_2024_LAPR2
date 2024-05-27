package pprog.ui.classesUI;

import pprog.controller.RegisterGreenSpaceController;
import pprog.domain.greenspace.GreenSpace;

import java.util.List;
import java.util.Scanner;

// ESTA CLASSE NAO ESTÁ CORRETA, FOI A PRESSA PARA TESTAR
public class RegisterGreenSpaceUI implements Runnable {

    private final RegisterGreenSpaceController controller;
    private String name;
    private String address;
    private int type;
    private double area;

    public RegisterGreenSpaceUI() {
        controller = new RegisterGreenSpaceController();
    }

    private RegisterGreenSpaceController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\n\n--- Register a Collaborator ------------------------");

        requestData();
        submitData();
    }

    private void submitData() {
        String result = getController().registerGreenSpace(name, address, type, area);
        if (result == null) {
            System.out.println("\nGreen Space successfully registered!");
            List<GreenSpace> greenSpaces = getController().getGreenSpaceRepository().getGreenSpacesList();
            GreenSpace lastGreenSpace = greenSpaces.get(greenSpaces.size() - 1);
            System.out.println(lastGreenSpace);
        } else {
            System.out.println("Green Space not registered!\n" + result);
        }
    }

    private void requestData() {

        name = requestName();
        address = request2();
        type = request3();
        area = request4();

    }

    private String requestName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of the green space: ");
        return input.nextLine();
    }

    private String request2() {
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
    private int request3() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the type of the green space (1: Park, 2: Garden, etc.): ");
        int type = input.nextInt();

        if (type < 1 || type > 3) {
            System.out.println("Invalid input. Please choose a valid option (1, 2 or 3).");
            return request3();
        } else {
            return type;
        }
    }

    private Double request4() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the area of the green space in square meters: ");
        return input.nextDouble();
    }
}
