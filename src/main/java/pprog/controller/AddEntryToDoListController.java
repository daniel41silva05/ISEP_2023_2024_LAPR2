package pprog.controller;

import pprog.domain.greenspace.GreenSpace;
import pprog.domain.users.GreenSpacesManager;
import pprog.repository.AuthenticationRepository;
import pprog.repository.GreenSpaceRepository;
import pprog.repository.Repositories;
import pprog.domain.todolist.ToDoList;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.List;

public class AddEntryToDoListController {

    private ToDoList toDoList;
    private GreenSpaceRepository greenSpacesRepository;
    private AuthenticationRepository authenticationRepository;

    public AddEntryToDoListController() {
        getToDoList();
        getGreenSpacesRepository();
        getAuthenticationRepository();
    }

    public AddEntryToDoListController(ToDoList toDoList, GreenSpaceRepository greenSpacesRepository, AuthenticationRepository authenticationRepository) {
        this.toDoList = toDoList;
        this.greenSpacesRepository = greenSpacesRepository;
        this.authenticationRepository = authenticationRepository;
    }

    private ToDoList getToDoList() {
        if (toDoList == null) {
            Repositories repositories = Repositories.getInstance();
            toDoList = repositories.getToDoList();
        }
        return toDoList;
    }

    private GreenSpaceRepository getGreenSpacesRepository() {
        if (greenSpacesRepository == null) {
            Repositories repositories = Repositories.getInstance();
            greenSpacesRepository = repositories.getGreenSpaceRepository();
        }
        return greenSpacesRepository;
    }

    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    public boolean addTaskToDoList(String title, String descritpion, int degreeOfUrgency, int expectedDurantionTime, int taskType, String greenSpace) {
        try {
            getToDoList().addTaskToDoList(title, descritpion, degreeOfUrgency, expectedDurantionTime, taskType, getGreenSpaceByName(greenSpace), getGSMFromSession());
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
            return false;
        }
    }

    private GreenSpace getGreenSpaceByName(String name) {
        return getGreenSpacesRepository().getGreenSpaceByName(name);
    }

    private GreenSpacesManager getGSMFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return new GreenSpacesManager(email.getEmail());
    }

    public List<GreenSpace> getGreenSpacesList() {
        return getGreenSpacesRepository().getGreenSpacesList();
    }

}
