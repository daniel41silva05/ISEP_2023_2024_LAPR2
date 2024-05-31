package pprog.ui.classesUI;

import pprog.controller.entry.AddEntryAgendaController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AddEntryAgendaUI implements Runnable {
    private final AddEntryAgendaController controller;

    private int index;
    private Date date;

    public AddEntryAgendaUI() {
        controller = new AddEntryAgendaController();
    }

    public AddEntryAgendaController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\n\n--- Add a Entry in the Agenda ------------------------");

        listAllTasks();
        requestData();
        submitData();
    }

    private void submitData() {
        String result = getController().addEntryAgenda(date, index);
        if (result == null) {
            System.out.println("\nTask successfully added!");
            System.out.println(controller.getEntryAdded());
        } else {
            System.out.println("Task not added!\n" + result);
        }
    }

    private void requestData() {
        index = requestTask();
        date = requestDate();
    }

    private int requestTask() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Task: ");
                if (input.hasNextInt()) {
                    int task = input.nextInt();
                    if (task > 0 && task <= controller.getTasksList().size()) {
                        return task;
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

    private Date requestDate() {
        Scanner input = new Scanner(System.in);
        System.out.print("Starting Date (format: dd/MM/yyyy): ");
        String dateStr = input.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(dateStr);
            return date;
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy format.");
            return requestDate();
        }
    }

    private void listAllTasks() {
        if (controller.getTasksList().isEmpty()) {
            System.out.println("To-Do List is empty!");
        } else {
            System.out.println(controller.getTasksList());
        }
    }

}
