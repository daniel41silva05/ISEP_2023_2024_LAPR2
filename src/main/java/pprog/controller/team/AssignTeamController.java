package pprog.controller.team;

import pprog.domain.email.EmailService;
import pprog.domain.agenda.Entry;
import pprog.domain.Team;
import pprog.domain.agenda.Agenda;
import pprog.repository.Repositories;
import pprog.repository.TeamRepository;

import java.io.IOException;
import java.util.List;

public class AssignTeamController {

    private Agenda agenda;
    private TeamRepository teamRepository;

    public AssignTeamController () {
        getAgenda();
        getTeamRepository();
    }

    public AssignTeamController (Agenda agenda, TeamRepository teamRepository) {
        this.agenda = agenda;
        this.teamRepository = teamRepository;
    }

    private Agenda getAgenda() {
        if (agenda == null) {
            Repositories repositories = Repositories.getInstance();
            agenda = repositories.getAgenda();
        }
        return agenda;
    }

    private TeamRepository getTeamRepository() {
        if (teamRepository == null) {
            Repositories repositories = Repositories.getInstance();
            teamRepository = repositories.getTeamRepository();
        }
        return teamRepository;
    }

    public boolean assignTeamToEntry(int agendaIndex, int teamIndex) {
        try {
            getEntryByIndex(agendaIndex).assignTeam(getTeamByIndex(teamIndex));
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
            return false;
        }
    }

    private Entry getEntryByIndex(int index) {
        return getAgenda().getEntryByIndex(index);
    }

    private Team getTeamByIndex(int index) {
        return getTeamRepository().getTeamByIndex(index);
    }

    public List<Entry> getEntriesList() {
        return getAgenda().getEntriesList();
    }

    public List<Team> getTeamsList() {
        return getTeamRepository().getTeamList();
    }

    // requer alteracoes
    public static void sendTheEmailToTheClient(String from, String to, String subject, String body) throws IOException {
        EmailService.sendToEmailFile(from,to, subject, body);
    }

    // apenas para testar o envio do email
    public static void main(String[] args) {
        String from = "sender@example.com";
        String to = "recipient@example.com";
        String subject = "Important";
        String body = "This is a test email.";

        try {
            sendTheEmailToTheClient(from, to, subject, body);
            System.out.println("Email sent successfully.");
        } catch (IOException e) {
            System.out.println("Failed to send email: " + e.getMessage());
        }
    }

}
