package pprog.ui.classesUI;

import pprog.controller.entry.PostponeEntryAgendaController;
import pprog.domain.agenda.Entry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * UI class for postponing an entry in the agenda.
 */
public class PostponeEntryAgendaUI {

    private PostponeEntryAgendaController controller;
    private Scanner scanner;

    /**
     * Constructs a PostponeEntryAgendaUI object.
     */
    public PostponeEntryAgendaUI() {
        controller = new PostponeEntryAgendaController();
        scanner = new Scanner(System.in);
    }

    /**
     * Runs the UI for postponing an entry.
     */
    public void run() {
        System.out.println("## POSTPONE ENTRY AGENDA ##");
        boolean exit = false;
        while (!exit) {
            System.out.println("1. List all entries");
            System.out.println("2. Postpone an entry");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Clear the scanner buffer

            switch (option) {
                case 1:
                    listAllEntries();
                    break;
                case 2:
                    postponeEntry();
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
     * Postpones an entry in the agenda.
     */
    private void postponeEntry() {
        System.out.print("Enter the index of the entry you want to postpone: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Clear the scanner buffer

        System.out.print("Enter the new start date (Format: dd/MM/yyyy HH:mm:ss): ");
        String dateString = scanner.nextLine();
        Date newStartingDate = parseDateString(dateString);

        boolean success = controller.postponeEntry(index, newStartingDate);
        if (success) {
            System.out.println("Entry postponed successfully.");
        } else {
            System.out.println("Failed to postpone the entry. Please check the index and date and try again.");
        }
    }

    /**
     * Parses a string to a Date object.
     *
     * @param dateString the string representation of the date
     * @return the Date object parsed from the string
     */
    private Date parseDateString(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter the date in the format dd/MM/yyyy HH:mm:ss.");
            return null;
        }
    }
}