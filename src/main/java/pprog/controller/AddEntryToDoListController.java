package pprog.controller;

import pprog.domain.agenda.EmergencyDegree;
import pprog.domain.gs.GreenSpace;
import pprog.domain.agenda.TaskType;
import pprog.repository.GreenSpaceRepository;
import pprog.repository.Repositories;
import pprog.repository.ToDoList;

import java.util.List;

public class AddEntryToDoListController {

    private ToDoList toDoList;
    private GreenSpaceRepository greenSpacesRepository;

    public AddEntryToDoListController() {
        getToDoList();
        getGreenSpacesRepository();
    }

    public AddEntryToDoListController(ToDoList toDoList, GreenSpaceRepository greenSpacesRepository) {
        this.toDoList = toDoList;
        this.greenSpacesRepository = greenSpacesRepository;
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

    public boolean addTaskToDoList(String title, String descritpion, EmergencyDegree degreeOfUrgency, int expectedDurantionTime, TaskType taskType, String greenSpace) {
        try {
            getToDoList().addTaskToDoList(title, descritpion, degreeOfUrgency, expectedDurantionTime, taskType, getGreenSpaceByName(greenSpace));
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
            return false;
        }
    }

    public GreenSpace getGreenSpaceByName(String name) {
        return getGreenSpacesRepository().getGreenSpaceByName(name);
    }

    public List<GreenSpace> getGreenSpacesList() {
        return getGreenSpacesRepository().getGreenSpacesList();
    }

}
