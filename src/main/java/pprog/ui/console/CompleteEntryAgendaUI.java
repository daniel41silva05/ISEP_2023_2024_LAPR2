package pprog.ui.console;

import pprog.controller.CompleteEntryAgendaController;
import pprog.domain.Entry;

import java.util.List;
import java.util.Scanner;

public class CompleteEntryAgendaUI implements Runnable {

    private final CompleteEntryAgendaController controller;

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

    private void submitData() {
        String result = getController().completeEntry(taskIndex);
        if (result == null) {
            System.out.println("\nTask registered as completed successfully!");
            System.out.println(getController().getEntryComplete(taskIndex));
        } else {
            System.out.println("Task not completed!\n" + result);
        }
    }

    private void requestData() {
        taskIndex = requestTask();
    }

    private int requestTask() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Task: ");
                if (input.hasNextInt()) {
                    int type = input.nextInt();
                    if (type > 0 && type <= getController().getEntriesList().size()) {
                        return type;
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

    private void listAllEntries() {
        List<Entry> entries = getController().getEntriesList();
        if (entries.isEmpty()) {
            System.out.println("No entries found.");
        } else {
            for (int i = 0; i < entries.size(); i++) {
                Entry entry = entries.get(i);
                System.out.println((i + 1) + ". " + entry.getTask().getTitle() + " - " + entry.getStartingDate() + " - " + entry.getStatus());
            }
        }
    }

}
