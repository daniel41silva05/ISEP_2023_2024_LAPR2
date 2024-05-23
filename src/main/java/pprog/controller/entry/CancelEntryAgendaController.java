package pprog.controller.entry;

import pprog.domain.agenda.Entry;
import pprog.domain.Agenda;
import pprog.repository.Repositories;

import java.util.List;

/**
 * Controller for canceling an entry in the agenda.
 */
public class CancelEntryAgendaController {

    private Agenda agenda;

    /**
     * Constructs a CancelEntryAgendaController and initializes the agenda.
     */
    public CancelEntryAgendaController() {
        getAgenda();
    }

    /**
     * Constructs a CancelEntryAgendaController with a given agenda.
     *
     * @param agenda the agenda to be used by this controller
     */
    public CancelEntryAgendaController(Agenda agenda) {
        this.agenda = agenda;
    }

    /**
     * Retrieves the agenda from the repositories if it is not already initialized.
     *
     * @return the agenda instance
     */
    private Agenda getAgenda() {
        if (agenda == null) {
            Repositories repositories = Repositories.getInstance();
            agenda = repositories.getAgenda();
        }
        return agenda;
    }

    /**
     * Cancels an entry in the agenda.
     *
     * @param entryIndex the index of the entry to be canceled
     * @return true if the entry was successfully canceled, false otherwise
     */
    public boolean cancelEntry(int entryIndex) {
        try {
            Entry entry = getAgenda().getEntryByIndex(entryIndex);
            getAgenda().cancelEntry(entry);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
            return false;
        }
    }

    /**
     * Gets the list of entries in the agenda.
     *
     * @return the list of entries
     */
    public List<Entry> getEntriesList() {
        return getAgenda().getEntriesList();
    }
}