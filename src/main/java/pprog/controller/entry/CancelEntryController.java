package pprog.controller.entry;

import pprog.domain.agenda.Entry;
import pprog.repository.Agenda;
import pprog.repository.Repositories;

public class CancelEntryController {

    private Agenda agenda;
    private pprog.domain.agenda.Entry Entry;

    public CancelEntryController(Agenda agenda, Entry Entry) {
        this.agenda = agenda;
        this.Entry = Entry;
    }

    private Agenda getAgenda(){
        if(agenda == null){
            Repositories repositories = Repositories.getInstance();
            agenda = repositories.getAgenda();
        }
        return agenda;
    }
}
