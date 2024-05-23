package pprog.domain;

import pprog.domain.agenda.AgendaStatus;
import pprog.domain.agenda.Entry;
import pprog.domain.todolist.Task;
import pprog.domain.todolist.TaskStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Agenda implements Serializable {

    private final List<Entry> entriesList;

    public Agenda() {
        entriesList = new ArrayList<>();
    }

    public Entry addEntryAgenda(Date startingDate, Task task) {
        Entry newEntry = null;
        Entry entry = new Entry(startingDate, task);

        if (addEntry(entry)) {
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

    private boolean addEntry(Entry entry) {
        if (validateEntry(entry)) {
            entry.getTask().changeStatus(TaskStatus.PROCESSED);
            entriesList.add(entry);
            return true;
        } else {
            throw new IllegalArgumentException("Entry already exists in the Agenda.");
        }
    }

    public void postponeEntry(Entry entry, Date newStartingDate) {
        entry.setStartingDate(newStartingDate);
    }

    public void cancelEntry(Entry entry) {
        entry.changeStatus(AgendaStatus.CANCELED);
    }

    private boolean validateEntry(Entry entry) {
        return !entriesList.contains(entry);
    }

    public List<Entry> getEntriesList() {
        return entriesList;
    }
}
