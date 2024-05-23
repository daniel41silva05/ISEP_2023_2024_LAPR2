package pprog.controller.entry;

import pprog.domain.agenda.Entry;
import pprog.domain.Agenda;
import pprog.repository.Repositories;

import java.util.Date;
import java.util.List;

/**
 * Controller for postponing an entry in the agenda.
 */
public class PostponeEntryAgendaController {

    private Agenda agenda;

    /**
     * Constructs a PostponeEntryAgendaController and initializes the agenda.
     */
    public PostponeEntryAgendaController() {
        getAgenda();
    }

    /**
     * Constructs a PostponeEntryAgendaController with a given agenda.
     *
     * @param agenda the agenda to be used by this controller
     */
    public PostponeEntryAgendaController(Agenda agenda) {
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
     * Postpones an entry in the agenda to a new starting date.
     *
     * @param entryIndex the index of the entry to be postponed
     * @param newStartingDate the new starting date for the entry
     * @return true if the entry was successfully postponed, false otherwise
     */
    public boolean postponeEntry(int entryIndex, Date newStartingDate) {
        try {
            Entry entry = getAgenda().getEntryByIndex(entryIndex);
            getAgenda().postponeEntry(entry, newStartingDate);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
            return false;
        }
    }

    public List<Entry> getEntriesList() {
        return getAgenda().getEntriesList();
    }
}