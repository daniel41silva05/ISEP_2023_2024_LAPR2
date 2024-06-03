package pprog.controller.entry;

import pprog.domain.agenda.Entry;
import pprog.domain.agenda.Agenda;
import pprog.repository.AuthenticationRepository;
import pprog.repository.Repositories;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.List;

/**
 * Controller for canceling an entry in the agenda.
 */
public class CancelEntryAgendaController {

    private Agenda agenda;
    private AuthenticationRepository authenticationRepository;

    /**
     * Constructs a CancelEntryAgendaController and initializes the agenda.
     */
    public CancelEntryAgendaController() {
        getAgenda();
        getAuthenticationRepository();
    }

    /**
     * Constructs a CancelEntryAgendaController with a given agenda.
     *
     * @param agenda the agenda to be used by this controller
     */
    public CancelEntryAgendaController(Agenda agenda, AuthenticationRepository authenticationRepository) {
        this.agenda = agenda;
        this.authenticationRepository = authenticationRepository;
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
     * Retrieves the authentication repository instance.
     *
     * @return The authentication repository instance.
     */
    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    /**
     * Cancels an entry in the agenda.
     *
     * @param entryIndex the index of the entry to be canceled
     * @return true if the entry was successfully canceled, false otherwise
     */
    public String cancelEntry(int entryIndex) {
        try {
            getAgenda().cancelEntry(getEntryByIndex(entryIndex), getGSMFromSession());
            return null;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    private Entry getEntryByIndex(int index) {
        return getAgenda().getEntryByIndex(index);
    }

    /**
     * Gets the list of entries in the agenda.
     *
     * @return the list of entries
     */
    public List<Entry> getEntriesList() {
        return getAgenda().getEntriesList();
    }

    private String getGSMFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return email.getEmail();
    }

    public Entry getEntryCancel(int index) {
        return getEntryByIndex(index);
    }
}