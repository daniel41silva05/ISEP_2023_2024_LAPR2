package pprog.ui.classesUI;

import pprog.controller.entry.CancelEntryAgendaController;
import pprog.domain.agenda.Entry;

import java.util.List;
import java.util.Scanner;

/**
 * User interface for canceling an entry in the agenda.
 */
public class CancelEntryAgendaUI {

    private CancelEntryAgendaController controller;

    private int taskIndex;

    /**
     * Constructs a new CancelEntryAgendaUI instance with a default controller.
     */
    public CancelEntryAgendaUI() {
        controller = new CancelEntryAgendaController();
    }

    /**
     * Gets the controller associated with this UI.
     *
     * @return The CancelEntryAgendaController instance.
     */
    public CancelEntryAgendaController getController() {
        return controller;
    }

    /**
     * Runs the UI to cancel a task.
     */
    public void run() {
        System.out.println("\n\n--- Cancel an Entry ------------------------");

        listAllEntries();
        requestData();
        submitData();
    }

    /**
     * Lists all entries in the agenda.
     */
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

    /**
     * Submits data to cancel the selected task.
     */
    private void submitData() {
        if (getController().cancelEntry(taskIndex)) {
            System.out.println("\nTask successfully canceled!");
        } else {
            System.out.println("Task not canceled!");
        }
    }

    /**
     * Requests data from the user to select the task to cancel.
     */
    private void requestData() {
        taskIndex = requestTask();
    }

    /**
     * Requests the task index from the user.
     *
     * @return The index of the task to cancel.
     */
    private int requestTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Task: ");
        return sc.nextInt();
    }

}
