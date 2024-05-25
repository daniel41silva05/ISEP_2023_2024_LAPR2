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
    private EmergencyDegree degreeOfUrgency;
    private int expectedDuration;
    private TaskType type;
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
}
