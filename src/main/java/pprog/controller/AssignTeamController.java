package pprog.controller;

import pprog.domain.Collaborator;
import pprog.domain.EmailService;
import pprog.domain.Entry;
import pprog.domain.Team;
import pprog.domain.Agenda;
import pprog.repository.AuthenticationRepository;
import pprog.repository.Repositories;
import pprog.repository.TeamRepository;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.List;

public class AssignTeamController {

    private Agenda agenda;
    private TeamRepository teamRepository;
    private AuthenticationRepository authenticationRepository;

    public AssignTeamController () {
        getAgenda();
        getTeamRepository();
        getAuthenticationRepository();
    }

    public AssignTeamController (Agenda agenda, TeamRepository teamRepository, AuthenticationRepository authenticationRepository) {
        this.agenda = agenda;
        this.teamRepository = teamRepository;
        this.authenticationRepository = authenticationRepository;
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

    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    public String assignTeamToEntry(int agendaIndex, int teamIndex) {
        try {
            Entry entry = getEntryByIndex(agendaIndex);
            Team team = getTeamByIndex(teamIndex);
            entry.assignTeam(team);
            for (Collaborator c : team.getTeam()) {
                sendTheEmailToTeam(getEmailGSMFromSession(), c.getEmail(), c.getName(), entry.toString());
            }
            return null;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
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

    private void sendTheEmailToTeam(String gsmEmail, String collaboratorEmail, String collaboratorName, String entry) {
        EmailService.sendToEmailFile(gsmEmail, collaboratorEmail, collaboratorName, entry);
    }

    private String getEmailGSMFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return email.getEmail();
    }

    public Entry getEntryWithTeam(int index) {
        return getEntryByIndex(index);
    }

}
