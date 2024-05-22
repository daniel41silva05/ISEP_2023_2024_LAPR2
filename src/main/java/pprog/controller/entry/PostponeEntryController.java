package pprog.controller.entry;

import pprog.domain.Agenda;
import pprog.repository.Repositories;
import pprog.domain.agenda.Entry;

public class PostponeEntryController {

    private Agenda agenda;
    private Entry Entry;

    public PostponeEntryController(Agenda agenda, Entry Entry) {
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
