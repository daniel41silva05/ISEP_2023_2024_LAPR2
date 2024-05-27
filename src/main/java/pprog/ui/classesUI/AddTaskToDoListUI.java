package pprog.ui.classesUI;

import pprog.controller.AddTaskToDoListController;
import pprog.domain.greenspace.GreenSpace;
import pprog.domain.todolist.EmergencyDegree;
import pprog.domain.todolist.TaskType;
import pprog.repository.GreenSpaceRepository;

import java.util.List;
import java.util.Scanner;

public class    AddTaskToDoListUI {

    private final AddTaskToDoListController controller;
    private String title;
    private String description;
    private int degreeOfUrgency;
    private int expectedDuration;
    private int type;
    private String greenSpace;

    public AddTaskToDoListUI(AddTaskToDoListController controller) {
        this.controller = controller;
    }

    private AddTaskToDoListController getController() {
        return controller;
    }

    private void run() {
        System.out.println("\n\n--- Add task to To-Do List ------------------------");

        listAllGreenSpaces();
        requestData();
        submitData();
    }

    private void submitData() {
        if (getController().addTaskToDoList(title, description, degreeOfUrgency, expectedDuration, type, greenSpace)) {
            System.out.println("Task successfully added!");
        } else {
            System.out.println("Skill not added!");
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

    private String requestGreenSpace() {
        Scanner input = new Scanner(System.in);
        String greenSpace;
        System.out.println("Green Space: ");
        greenSpace = input.nextLine().trim();

        if (!greenSpace.matches("[a-zA-Z ]+")) {
            System.out.println("Invalid name. Please introduce a valid name!");
            return requestGreenSpace();
        } else {
            return greenSpace;
        }
    }

    private void listAllGreenSpaces() {
        List<GreenSpace> listOfGreenSpaces = getController().getGreenSpacesList();
        if (listOfGreenSpaces == null) {
            System.out.println("No Green Spaces found!");
        } else {
            for (GreenSpace gs: listOfGreenSpaces) {
                System.out.println(gs);
            }
        }
    }
}

