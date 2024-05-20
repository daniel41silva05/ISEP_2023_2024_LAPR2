package pprog.controller;

import pprog.domain.Task;
import pprog.repository.Agenda;
import pprog.repository.Repositories;
import pprog.repository.ToDoList;

import java.util.Date;
import java.util.List;

public class AddEntryAgendaController {

    private Agenda agenda;
    private ToDoList toDoList;

    public AddEntryAgendaController() {
        getAgenda();
        getToDoList();
    }

    public AddEntryAgendaController(Agenda agenda, ToDoList toDoList) {
        this.agenda = agenda;
        this.toDoList = toDoList;
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

    public boolean addEntryAgenda(Date startingDate, String reference) {
        try {
            getAgenda().addEntryAgenda(startingDate, getTaskByReference(reference));
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
            return false;
        }
    }

    private Task getTaskByReference(String reference) {
        return getToDoList().getTaskByReference(reference);
    }

    public List<Task> getTasksList() {
        return getToDoList().getTasksList();
    }

}
