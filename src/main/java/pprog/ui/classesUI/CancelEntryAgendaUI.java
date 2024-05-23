package pprog.ui.classesUI;

import pprog.controller.entry.CancelEntryAgendaController;
import pprog.domain.agenda.Entry;

import java.util.List;
import java.util.Scanner;

/**
 * User interface for canceling entries in the agenda.
 */
public class CancelEntryAgendaUI {

    private CancelEntryAgendaController controller;
    private Scanner scanner;

    /**
     * Constructs a CancelEntryAgendaUI and initializes the controller and scanner.
     */
    public CancelEntryAgendaUI() {
        controller = new CancelEntryAgendaController();
        scanner = new Scanner(System.in);
    }

    /**
     * Runs the cancel entry agenda user interface.
     */
    public void run() {
        System.out.println("## CANCEL ENTRY AGENDA ##");
        boolean exit = false;
        while (!exit) {
            System.out.println("1. List all entries");
            System.out.println("2. Cancel an entry");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Clears the scanner buffer

            switch (option) {
                case 1:
                    listAllEntries();
                    break;
                case 2:
                    cancelEntry();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
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
     * Cancels an entry in the agenda.
     */
    private void cancelEntry() {
        System.out.print("Enter the index of the entry you want to cancel: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Clears the scanner buffer

        boolean success = controller.cancelEntry(index);
        if (success) {
            System.out.println("Entry canceled successfully.");
        } else {
            System.out.println("Failed to cancel the entry. Please check the index and try again.");
        }
    }
}