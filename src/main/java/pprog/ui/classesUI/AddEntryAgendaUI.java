package pprog.ui.classesUI;

import pprog.controller.entry.AddEntryAgendaController;
import pprog.domain.todolist.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// ESTA CLASSE NAO ESTÁ CORRETA, FOI A PRESSA PARA TESTAR
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
        System.out.println("\n\n--- Add a Task ------------------------");

        listAllTasks();
        requestData();
        submitData();
    }

    private void submitData() {
        if (getController().addEntryAgenda(date, index)) {
            System.out.println("\nTask successfully completed!");
        } else {
            System.out.println("Task not completed!");
        }
    }

    private void requestData() {
        index = request1();
        date = request2();
    }

    private int request1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Task: ");
        return sc.nextInt();
    }

    private Date request2() {
        Scanner input = new Scanner(System.in);
        System.out.print("Date (format: dd/MM/yyyy): ");
        String dateStr = input.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy format.");
            return request2();
        }
    }

    private void listAllTasks() {
        List<Task> tasksList = controller.getTasksList();
        System.out.println(tasksList);
    }
}
