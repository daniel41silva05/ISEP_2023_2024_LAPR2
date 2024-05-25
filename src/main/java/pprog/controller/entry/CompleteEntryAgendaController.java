package pprog.controller.entry;

import pprog.domain.agenda.Agenda;
import pprog.domain.agenda.Entry;
import pprog.domain.collaborator.Collaborator;
import pprog.repository.AuthenticationRepository;
import pprog.repository.CollaboratorRepository;
import pprog.repository.Repositories;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.List;

public class CompleteEntryAgendaController {

    private Agenda agenda;

    private AuthenticationRepository authenticationRepository;

    public CompleteEntryAgendaController(Agenda agenda, AuthenticationRepository authenticationRepository) {
        this.agenda = agenda;
        this.authenticationRepository = authenticationRepository;
    }

    public CompleteEntryAgendaController() {
        getAgenda();
        getAuthenticationRepository();
    }

    public Agenda getAgenda() {
        if (agenda == null) {
            Repositories repositories = Repositories.getInstance();
            agenda = repositories.getAgenda();
        }
        return agenda;
    }

    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    public boolean completeEntry(int entryIndex) {
        try {
            getAgenda().completeEntry(getEntryByIndex(entryIndex));
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
            return false;
        }
    }

    private Entry getEntryByIndex(int index) {
        return getAgenda().getEntryByIndex(index);
    }

    public List<Entry> getEntriesList() {
        return getAgenda().getEntriesList();
    }

    private String getEmailCollaboratorFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return email.getEmail();
    }

    public boolean verifyCollaborator(int entryIndex) {
        for (Collaborator c : getEntryByIndex(entryIndex).getTeamAssign().getTeam()) {
            if (getEmailCollaboratorFromSession().equalsIgnoreCase(c.getEmail())) {
                return true;
            }
        }
        return false;
    }
}
