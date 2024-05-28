package pprog.controller.entry;

import pprog.domain.agenda.Agenda;
import pprog.domain.agenda.Entry;
import pt.isep.lei.esoft.auth.domain.model.Email;
import pprog.domain.todolist.TaskStatus;
import pprog.domain.collaborator.Collaborator;
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


    /**
     * Constructs a new ConsultTasksController object.
     */
    public ConsultTasksController() {
        getAgenda();
        getAuthenticationRepository();
    }

    public ConsultTasksController(Agenda agenda, AuthenticationRepository authenticationRepository) {
        this.agenda = new Agenda();
        this.authenticationRepository = authenticationRepository;
    }

    private String getEmailCollaboratorFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return email.getEmail();
    }

    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
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
     * Retrieves tasks for a collaborator between specified dates with optional task status filtering.
     *
     * @param startDate    The start date for the task retrieval period.
     * @param endDate      The end date for the task retrieval period.
     * @param taskStatus   The optional status of tasks to filter by (null to ignore).
     * @return A list of tasks matching the criteria.
     */
    public List<Entry> getTasksForCollaboratorBetweenDates(Date startDate, Date endDate, TaskStatus taskStatus) {
        return agenda.getTasksForCollaboratorBetweenDates(getEmailCollaboratorFromSession(), startDate, endDate, taskStatus);
    }
}
