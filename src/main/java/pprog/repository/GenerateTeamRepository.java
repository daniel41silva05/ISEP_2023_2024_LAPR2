package pprog.repository;

import pprog.domain.GenerateTeam;
import pprog.domain.Skill;

import java.util.ArrayList;
import java.util.List;

public class GenerateTeamRepository {

    private List<GenerateTeam> teamList;

    public GenerateTeamRepository(List<GenerateTeam> teamList) {
        this.teamList = teamList;
    }

    public GenerateTeamRepository() {
        teamList = new ArrayList<>();
    }

    public List<GenerateTeam> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<GenerateTeam> teamList) {
        this.teamList = teamList;
    }

    public GenerateTeam generateTeam(int maxSize, int minSize, List<Skill> skillsNeeded) {
        return generateTeam(maxSize, minSize, skillsNeeded);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (GenerateTeam gt : teamList) {
            s.append(gt.toString());
            s.append("\n");
        }
        return s.toString();
    }

    public boolean addTeam(GenerateTeam team) {
        return teamList.add(team);
    }

}
