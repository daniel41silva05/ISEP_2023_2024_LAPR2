package pprog.ui.classesUI;

import pprog.controller.AddTaskToDoListController;
import pprog.domain.greenspace.GreenSpace;
import pprog.domain.todolist.EmergencyDegree;
import pprog.domain.todolist.TaskType;

import java.util.Scanner;

public class AddTaskToDoListUI {

    private final AddTaskToDoListController controller;
    private String title;
    private String description;
    private int degreeOfUrgency;
    private int expectedDuration;
    private int type;
    private GreenSpace greenSpace;

    public AddTaskToDoListUI(AddTaskToDoListController controller) {
        this.controller = controller;
    }

    private AddTaskToDoListController getController() {
        return controller;
    }

    private void run() {
        System.out.println("\n\n--- Add task to To-Do List ------------------------");


    }

    private String requestTitle() {
        Scanner input = new Scanner(System.in);
        String title;
        do {
            System.out.println("Title: ");
            title = input.nextLine().trim();
            if (!title.matches("[a-zA-Z ]+")) {
                System.out.println("Invalid title. Please enter a valid title.");
            }
        } while (!title.matches("[a-zA-Z ]+}"));
        return title;
    }

    private String requestDescription() {
        Scanner input = new Scanner(System.in);
        String description;
        do {
            System.out.println("Description: ");
            description = input.nextLine().trim();
            if (!description.matches("[a-zA-Z ]+")) {
                System.out.println("Invalid title. Please enter a valid description.");
            }
        } while (!description.matches("[a-zA-Z ]+}"));
        return description;
    }

    private int requestDegreeOfUrgency() {
        Scanner input = new Scanner(System.in);
        int degreeOfUrgency;
        System.out.println("Degree of Urgency: ");
        System.out.println("1 - HIGH");
        System.out.println("2 - MEDIUM");
        System.out.println("3 - LOW");
        degreeOfUrgency = input.nextInt();

        if (degreeOfUrgency < 1 || degreeOfUrgency > 3) {
            System.out.println("Invalid input. Please choose a valid option (1, 2 or 3).");
            return requestDegreeOfUrgency();
        } else {
            return degreeOfUrgency;
        }
    }

    private int requestExpectedDuration() {
        Scanner input = new Scanner(System.in);
        int expectedDuration;
        System.out.println("Expected Duration: ");
        expectedDuration = input.nextInt();

        if (expectedDuration < 0) {
            System.out.println("Invalid input. Please insert a valid duration (greater than 0).");
            return requestExpectedDuration();
        } else {
            return expectedDuration;
        }
    }

    private int requestType() {
        Scanner input = new Scanner(System.in);
        int type;
        System.out.println("Type: ");
        System.out.println("1 - REGULAR");
        System.out.println("2 - OCCASIONAL");
        type = input.nextInt();

        if (type < 1 || type > 2) {
            System.out.println("Invalid input. Please choose a valid option (1 or 2).");
            return requestType();
        } else {
            return type;
        }
    }
}

