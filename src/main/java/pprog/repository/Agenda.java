package pprog.repository;

import pprog.domain.Entry;
import pprog.domain.Task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Agenda {

    private final List<Entry> entriesList;

    public Agenda () {
        entriesList = new ArrayList<>();
    }

    public Entry addEntryAgenda (Date startingDate, Task task) {
        Entry newEntry = null;
        Entry entry = new Entry(startingDate, task);

        if (addEntry(entry)) {
            newEntry = entry;
        }
        return newEntry;
    }

    private boolean addEntry(Entry entry) {
        if (validateEntry(entry)) {
            entriesList.add(entry);
            return true;
        } else {
            throw new IllegalArgumentException("Entry already exists in the repository.");
        }
    }

    private boolean validateEntry(Entry entry) {
        return !entriesList.contains(entry);
    }

    public List<Entry> getEntriesList() {
        return entriesList;
    }
}
