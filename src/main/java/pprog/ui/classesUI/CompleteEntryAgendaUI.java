package pprog.ui.classesUI;

import pprog.controller.entry.CompleteEntryAgendaController;
import pprog.domain.agenda.Entry;

import java.util.List;
import java.util.Scanner;

public class CompleteEntryAgendaUI {

    private CompleteEntryAgendaController controller;

    private int taskIndex;

    public CompleteEntryAgendaUI() {
        controller = new CompleteEntryAgendaController();
    }

    public CompleteEntryAgendaController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\n\n--- Complete a Task ------------------------");

        listAllEntries();
        requestData();
        submitData();
    }

    private void listAllEntries() {
        List<Entry> entries = controller.getEntriesList();
        if (entries.isEmpty()) {
            System.out.println("No entries found.");
        } else {
            for (int i = 0; i < entries.size(); i++) {
                Entry entry = entries.get(i);
                System.out.println((i + 1) + ". " + entry.getTask().getTitle() + " - " + entry.getStartingDate() + " - " + entry.getStatus());
            }
        }
    }

    private void submitData() {
        if (getController().completeEntry(taskIndex)) {
            System.out.println("\nTask successfully completed!");
        } else {
            System.out.println("Task not completed!");
        }
    }

    private void requestData() {
        taskIndex = requestTask();
    }

    private int requestTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Task: ");
        return sc.nextInt();
    }

}
