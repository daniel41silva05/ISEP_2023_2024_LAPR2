package pprog.repository;

import pprog.domain.CheckUp;
import pprog.domain.Collaborator;
import pprog.domain.GenerateTeam;
import pprog.domain.Skill;

import java.util.ArrayList;
import java.util.List;

public class GenerateTeamRepository {

    private List<GenerateTeam> teamList;

    public GenerateTeamRepository() {
        teamList = new ArrayList<>();
    }

    public List<GenerateTeam> getTeamList() {
        return teamList;
    }
    // sdf

    public List<Collaborator> team(int minSize, int maxSize, List<Skill> requiredSkills, List<Collaborator> collaboratorList) {
        List<Collaborator> newTeams = new ArrayList<>();
        GenerateTeam team = new GenerateTeam(minSize, maxSize, requiredSkills);

        if (addTeam(team)) {
            List<Collaborator> collaboratorsWithSkills = team.seeColaboratorsWithSkillsNeeded(collaboratorList, requiredSkills);
            List<Collaborator> generatedTeams = team.generateRandomTeam(collaboratorsWithSkills, maxSize, minSize);
            newTeams.addAll(generatedTeams);
        }
        return newTeams;
    }

    private boolean addTeam(GenerateTeam team) {
        boolean success = false;
        if (validateTeam(team)) {
            success = teamList.add(team.clone());
        }
        return success;
    }

    private boolean validateTeam(GenerateTeam team) {
        return !teamList.contains(team);
    }

}
