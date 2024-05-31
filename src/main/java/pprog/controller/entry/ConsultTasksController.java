package pprog.controller.entry;

import pprog.domain.agenda.Agenda;
import pprog.domain.agenda.Entry;
import pt.isep.lei.esoft.auth.domain.model.Email;
import pprog.repository.AuthenticationRepository;
import pprog.repository.Repositories;

import java.util.Date;
import java.util.List;

/**
 * The controller class for consulting tasks.
 */
public class ConsultTasksController {

    private Agenda agenda;
    private AuthenticationRepository authenticationRepository;

    public ConsultTasksController() {
        getAgenda();
        getAuthenticationRepository();
    }
    /**
     * Constructs a new ConsultTasksController object.
     */
    public ConsultTasksController(Agenda agenda, AuthenticationRepository authenticationRepository) {
        this.agenda = agenda;
        this.authenticationRepository = authenticationRepository;
    }

    private String getEmailCollaboratorFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return email.getEmail();
    }

    /**
     * Retrieves the agenda instance.
     *
     * @return The agenda instance.
     */
    public Agenda getAgenda() {
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
     * Retrieves tasks for a collaborator between specified dates with optional task status filtering.
     *
     * @param startDate    The start date for the task retrieval period.
     * @param endDate      The end date for the task retrieval period.
     * @return A list of tasks matching the criteria.
     */
    public List<Entry> getTasksForCollaboratorBetweenDates(Date startDate, Date endDate) {
        return getAgenda().getTasksForCollaboratorBetweenDates(getEmailCollaboratorFromSession(), startDate, endDate);
    }
}
