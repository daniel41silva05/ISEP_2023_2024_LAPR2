package pprog.ui.classesUI;

import pprog.controller.entry.CompleteEntryAgendaController;
import pprog.domain.agenda.Entry;

import java.util.List;
import java.util.Scanner;

public class CompleteEntryAgendaUI {

    private CompleteEntryAgendaController controller;
    private Scanner scanner;

    public CompleteEntryAgendaUI(CompleteEntryAgendaController controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    public CompleteEntryAgendaUI() {
        controller = new CompleteEntryAgendaController();
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("## COMPLETE ENTRY AGENDA ##");
        boolean exit = false;
        while (!exit) {
            System.out.println("1. List all entries");
            System.out.println("2. Complete an entry");
            System.out.println("0. Exit");
            System.out.println("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch(option) {
                case 1:
                    listAllEntries();
                    break;
                case 2:
                    completeEntry();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
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

    private void completeEntry() {
        System.out.print("Enter the index of the entry you want to cancel: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Clears the scanner buffer

        boolean success = controller.completeEntry(index);
        if (success) {
            System.out.println("Entry completed successfully.");
        } else {
            System.out.println("Failed to complete the entry. Please check the index and try again.");
        }
    }
}
