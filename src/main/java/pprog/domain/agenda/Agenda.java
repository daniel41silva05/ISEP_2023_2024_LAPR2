package pprog.domain.agenda;

import pprog.domain.todolist.Task;
import pprog.domain.todolist.TaskStatus;
import pprog.domain.users.GreenSpacesManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Agenda implements Serializable {

    private final List<Entry> entriesList;

    public Agenda() {
        entriesList = new ArrayList<>();
    }

    public Entry addEntryAgenda(Date startingDate, Task task, GreenSpacesManager gsmFromSession) {
        Entry newEntry = null;
        Entry entry = new Entry(startingDate, task);

        if (addEntry(gsmFromSession, entry)) {
            newEntry = entry;
        }
        return newEntry;
    }

    public Entry getEntryByIndex(int index) {
        if (index < 1 || index > entriesList.size()) {
            throw new IllegalArgumentException("Entry not found in Agenda.");
        }
        return entriesList.get(index - 1);
    }

    private boolean addEntry(GreenSpacesManager gsmFromSession, Entry entry) {
        if (validateEntry(entry) && validateUser(gsmFromSession, entry)) {
            entry.getTask().changeStatus(TaskStatus.PROCESSED);
            entriesList.add(entry);
            return true;
        } else {
            throw new IllegalArgumentException("Entry already exists in the Agenda.");
        }
    }

    public void postponeEntry(Entry entry, Date newStartingDate) {
        entry.setStartingDate(newStartingDate);
        entry.changeStatus(AgendaStatus.POSTPONED);
    }

    public void cancelEntry(Entry entry) {
        entry.changeStatus(AgendaStatus.CANCELED);
    }

    public void completeEntry(Entry entry) {
        entry.changeStatus(AgendaStatus.DONE);
    }

    private boolean validateEntry(Entry entry) {
        return !entriesList.contains(entry);
    }

    private boolean validateUser(GreenSpacesManager gsmFromSession, Entry entry) {
        if (entry.getGreenSpacesManager().equals(gsmFromSession)) {
            return true;
        } else {
            throw new IllegalArgumentException("The logged in Green Space Manager does not manage the green space associated with this entrance.");
        }
    }

    public List<Entry> getEntriesList() {
        return entriesList;
    }
}
