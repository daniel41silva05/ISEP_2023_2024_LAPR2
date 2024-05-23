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

        if (getController().registerGreenSpace(name, address, type, area)) {
            System.out.println("\nGreen Space successfully registed!");
            List<GreenSpace> greenSpaces = getController().getGreenSpaceRepository().getGreenSpacesList();
            GreenSpace lastGreenSpace = greenSpaces.get(greenSpaces.size() - 1);
            System.out.println(lastGreenSpace);
        } else {
            System.out.println("Green Space not registed!");
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
        System.out.print("Enter the address of the green space: ");
        return input.nextLine();
    }
    private int request3() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the type of the green space (1: Park, 2: Garden, etc.): ");
        return input.nextInt();
    }

    private Double request4() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the area of the green space in square meters: ");
        return input.nextDouble();
    }
}
