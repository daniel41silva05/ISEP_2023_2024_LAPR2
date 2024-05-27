package pprog.controller.entry;

import pprog.domain.agenda.Agenda;
import pprog.domain.agenda.Entry;
import pprog.domain.email.Email;
import pprog.domain.todolist.TaskStatus;
import pprog.domain.collaborator.Collaborator;
import pprog.repository.AuthenticationRepository;

import java.util.Date;
import java.util.List;

/**
 * The controller class for consulting tasks.
 */
public class ConsultTasksController {

    private Agenda agenda;

    /**
     * Constructs a new ConsultTasksController object.
     */
    public ConsultTasksController() {
        this.agenda = new Agenda();
    }

    private Collaborator getEmailCollaboratorFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return email.getEmail();
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
