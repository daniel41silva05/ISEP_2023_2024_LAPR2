package pprog.ui.classesUI;

import java.util.Scanner;

import pprog.controller.RegisterJobController;
import pprog.domain.Job;

/**
 * User interface for registering a job.
 */
public class RegisterJobUI implements Runnable {
    /**
     * The controller for registering jobs.
     */
    private RegisterJobController controller;

    /**
     * The name of the job.
     */
    private String name;

    /**
     * The description of the job.
     */
    private String description;

    /**
     * Constructs a RegisterJobUI with a new instance of RegisterJobController.
     */
    public RegisterJobUI() {
        controller = new RegisterJobController();
    }

    /**
     * Gets the controller.
     *
     * @return the controller
     */
    private RegisterJobController getController() {
        return controller;
    }

    /**
     * Runs the UI.
     */
    public void run() {
        System.out.println("\n\n--- Register a Job ------------------------");

        requestData();
        submitData();

    }

    /**
     * Submits data to register the job.
     */
    private void submitData() {
        Job job = controller.registerJob(name, description);
        if (job != null) {
            System.out.println("\nJob successfully registed!");
        } else {
            System.out.println("\nJob not registed!");
        }

    }

    /**
     * Requests data from the user.
     */
    private void requestData() {

        name = requestName();
        description = requestDescription();

    }

    /**
     * Requests the name of the job from the user.
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
        } while (!name.matches("[a-zA-Z ]+"));
        return name;
    }

    /**
     * Requests the description of the job from the user.
     *
     * @return the description entered by the user
     */
    private String requestDescription() {
        Scanner input = new Scanner(System.in);
        System.out.print("Description: ");
        return input.nextLine();
    }
}
