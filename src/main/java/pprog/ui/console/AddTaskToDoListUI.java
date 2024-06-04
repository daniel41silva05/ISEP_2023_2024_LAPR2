package pprog.ui.console;

import pprog.controller.AddTaskToDoListController;
import pprog.controller.RegisterGreenSpaceController;

import java.util.Scanner;

public class AddTaskToDoListUI implements Runnable {

    private final AddTaskToDoListController controller;
    private String title;
    private String description;
    private int degreeOfUrgency;
    private int expectedDuration;
    private int type;
    private String greenSpace;

    public AddTaskToDoListUI() {
        controller = new AddTaskToDoListController();
    }

    private AddTaskToDoListController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\n\n--- Add Task to To-Do List ------------------------");

        listAllGreenSpaces();
        requestData();
        submitData();
    }

    private void submitData() {
        String result = getController().addTaskToDoList(title, description, degreeOfUrgency, expectedDuration, type, greenSpace);
        if (result == null) {
            System.out.println("\nTask successfully added!");
            System.out.println(getController().getTaskAdded());
        } else {
            System.out.println("Task not added!\n" + result);
        }
    }

    private void requestData() {
        title = requestTitle();
        description = requestDescription();
        degreeOfUrgency = requestDegreeOfUrgency();
        expectedDuration = requestExpectedDuration();
        type = requestType();
        greenSpace = requestGreenSpace();
    }

    private String requestTitle() {
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Title: ");
                String name = input.nextLine().trim();;
                if (name.matches("[a-zA-Z0-9\\s]+")) {
                    return name;
                } else {
                    throw new IllegalArgumentException("Invalid title. Please enter a valid title.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String requestDescription() {
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Description: ");
                String description = input.nextLine().trim();;
                if (description.matches("[a-zA-Z0-9\\s]+")) {
                    return description;
                } else {
                    throw new IllegalArgumentException("Invalid description. Please enter a valid description.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int requestDegreeOfUrgency() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Degree of Urgency: ");
                System.out.println("1 - High");
                System.out.println("2 - Medium");
                System.out.println("3 - Low");
                if (input.hasNextInt()) {
                    int degree = input.nextInt();
                    if (degree > 0 && degree < 4) {
                        return degree;
                    } else {
                        throw new IllegalArgumentException("Invalid input. Please choose a valid option (1, 2 or 3).");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid input. Please choose a valid option (1, 2 or 3).");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }
    }

    private int requestExpectedDuration() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Expected Duration: ");
                if (input.hasNextDouble()) {
                    int duration = input.nextInt();
                    if (duration > 0) {
                        return duration;
                    } else {
                        throw new IllegalArgumentException("Invalid input. Please insert a valid duration (greater than 0).");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid input. Please enter numbers.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }
    }

    private int requestType() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Type: ");
                System.out.println("1 - Regular");
                System.out.println("2 - Occasional");
                if (input.hasNextInt()) {
                    int degree = input.nextInt();
                    if (degree > 0 && degree < 3) {
                        return degree;
                    } else {
                        throw new IllegalArgumentException("Invalid input. Please choose a valid option (1 or 2).");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid input. Please choose a valid option (1 or 2).");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }
    }

    private String requestGreenSpace() {
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Green Space: ");
                String greenSpace = input.nextLine().trim();;
                if (greenSpace.matches("[a-zA-Z0-9\\s]+")) {
                    return greenSpace;
                } else {
                    throw new IllegalArgumentException("Invalid name. Please enter a valid name.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void listAllGreenSpaces() {
        if (controller.getGreenSpacesList().isEmpty()) {
            System.out.println("No Green Spaces found!");
        } else {
            System.out.println(controller.getGreenSpacesList());
        }
    }

}

