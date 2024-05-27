package pprog.ui.classesUI;

import pprog.controller.entry.ConsultTasksController;
import pprog.domain.agenda.Entry;
import pprog.domain.todolist.TaskStatus;
import pprog.domain.collaborator.Collaborator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents the user interface for consulting tasks.
 */
public class ConsultTasksUI {

    private ConsultTasksController controller;
    private Scanner scanner;

    /**
     * Constructs a new ConsultTasksUI object.
     */
    public ConsultTasksUI() {
        this.controller = new ConsultTasksController();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Starts the user interface for consulting tasks.
     */
    public void start() {
        System.out.println("\n\n--- Consult a Task ------------------------");

        // Request user information
        System.out.print("Enter the collaborator's name: ");
        String collaboratorName = scanner.nextLine();

        System.out.print("Enter the start date (dd/MM/yyyy): ");
        Date startDate = readDateFromUser();

        System.out.print("Enter the end date (dd/MM/yyyy): ");
        Date endDate = readDateFromUser();

        System.out.print("Enter the task status (PENDING or PROCESSED, leave blank to ignore): ");
        String taskStatusInput = scanner.nextLine();
        TaskStatus taskStatus = null;
        if (!taskStatusInput.isEmpty()) {
            taskStatus = TaskStatus.valueOf(taskStatusInput.toUpperCase());
        }

        // Consult tasks
        List<Entry> tasks = controller.getTasksForCollaboratorBetweenDates(startDate, endDate, taskStatus);

        // Display found tasks
        System.out.println("\nFound tasks:");
        for (Entry task : tasks) {
            System.out.println(task.getTask().getTitle() + " - " + task.getStartingDate());
        }
    }

    /**
     * Reads a date input from the user.
     *
     * @return The parsed date.
     */
    private Date readDateFromUser() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String input = scanner.nextLine();
            return dateFormat.parse(input);
        } catch (Exception e) {
            System.out.println("Invalid date. Please try again.");
            return readDateFromUser();
        }
    }

}
