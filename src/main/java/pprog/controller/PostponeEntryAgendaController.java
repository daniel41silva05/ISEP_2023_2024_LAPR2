package pprog.controller;

import pprog.domain.Entry;
import pprog.domain.Agenda;
import pprog.repository.AuthenticationRepository;
import pprog.repository.Repositories;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.Date;
import java.util.List;

/**
 * Controller for postponing an entry in the agenda.
 */
public class PostponeEntryAgendaController {

    private Agenda agenda;
    private AuthenticationRepository authenticationRepository;

    /**
     * Constructs a PostponeEntryAgendaController and initializes the agenda.
     */
    public PostponeEntryAgendaController() {
        getAgenda();
        getAuthenticationRepository();
    }

    public PostponeEntryAgendaController(Agenda agenda, AuthenticationRepository authenticationRepository) {
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

    public String postponeEntry(int entryIndex, Date newStartingDate) {
        try {
            getAgenda().postponeEntry(getEntryByIndex(entryIndex), newStartingDate, getGSMFromSession());
            return null;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    private Entry getEntryByIndex(int index) {
        return getAgenda().getEntryByIndex(index);
    }

    public List<Entry> getEntriesList() {
        return getAgenda().getEntriesList();
    }

    private String getGSMFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return email.getEmail();
    }

    public Entry getEntryPostpone(int index) {
        return getEntryByIndex(index);
    }
}