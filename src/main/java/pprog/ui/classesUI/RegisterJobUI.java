package pprog.ui.classesUI;

import java.util.Scanner;

import pprog.controller.RegisterJobController;
import pprog.domain.Job;

public class RegisterJobUI implements Runnable {
    private RegisterJobController controller;

    private String name;
    private String description;

    public RegisterJobUI() {
        controller = new RegisterJobController();
    }

    private RegisterJobController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\n\n--- Register a Job ------------------------");

        requestData();
        submitData();

    }

    private void submitData() {
        Job job = controller.registerJob(name, description);
        if (job != null) {
            System.out.println("\nJob successfully registed!");
        } else {
            System.out.println("\nJob not registed!");
        }

    }

    private void requestData() {

        name = requestName();
        description = requestDescription();

    }

    private String requestName() {
        Scanner input = new Scanner(System.in);
        String name;
        do {
            System.out.print("Name: ");
            name = input.nextLine().trim();
            if (!name.matches("[a-zA-Z ]+")) {
                System.out.println("Invalid name. Please enter a valid name.");
            }
        } while (!name.matches("[a-zA-Z ]+"));
        return name;
    }

    private String requestDescription() {
        Scanner input = new Scanner(System.in);
        System.out.print("Description: ");
        return input.nextLine();
    }
}
