package pprog.controller.entry;

import pprog.domain.todolist.Task;
import pprog.domain.agenda.Agenda;
import pprog.domain.users.GreenSpacesManager;
import pprog.repository.AuthenticationRepository;
import pprog.repository.Repositories;
import pprog.domain.todolist.ToDoList;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.Date;
import java.util.List;

public class AddEntryAgendaController {

    private Agenda agenda;
    private ToDoList toDoList;
    private AuthenticationRepository authenticationRepository;

    public AddEntryAgendaController() {
        getAgenda();
        getToDoList();
        getAuthenticationRepository();
    }

    public AddEntryAgendaController(Agenda agenda, ToDoList toDoList, AuthenticationRepository authenticationRepository) {
        this.agenda = agenda;
        this.toDoList = toDoList;
        this.authenticationRepository = authenticationRepository;
    }

    private Agenda getAgenda() {
        if (agenda == null) {
            Repositories repositories = Repositories.getInstance();
            agenda = repositories.getAgenda();
        }
        return agenda;
    }

    private ToDoList getToDoList() {
        if (toDoList == null) {
            Repositories repositories = Repositories.getInstance();
            toDoList = repositories.getToDoList();
        }
        return toDoList;
    }

    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    public boolean addEntryAgenda(Date startingDate, int index) {
        try {
            getAgenda().addEntryAgenda(startingDate, getTaskByIndex(index), getGSMFromSession());
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
            return false;
        }
    }

    private Task getTaskByIndex(int index) {
        return getToDoList().getTaskByIndex(index);
    }

    public List<Task> getTasksList() {
        return getToDoList().getTasksList();
    }

    private GreenSpacesManager getGSMFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return new GreenSpacesManager(email.getEmail());
    }

}
