package pprog.controller.entry;

import pprog.domain.agenda.Agenda;
import pprog.domain.agenda.Entry;
import pprog.repository.Repositories;

import java.util.List;

public class CompleteEntryAgendaController {

    private Agenda agenda;

    public CompleteEntryAgendaController(Agenda agenda) {
        this.agenda = agenda;
    }

    public CompleteEntryAgendaController() {
        getAgenda();
    }

    public Agenda getAgenda() {
        if (agenda == null) {
            Repositories repositories = Repositories.getInstance();
            agenda = repositories.getAgenda();
        }
        return agenda;
    }

    public boolean completeEntry(int entryIndex) {
        try {
            getAgenda().completeEntry(getEntryByIndex(entryIndex));
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
            return false;
        }
    }

    private Entry getEntryByIndex(int index) {
        return getAgenda().getEntryByIndex(index);
    }

    public List<Entry> getEntriesList() {
        return getAgenda().getEntriesList();
    }
}
