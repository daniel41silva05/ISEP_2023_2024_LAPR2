package pprog.repository;

import pprog.domain.GenerateTeam;

import java.util.ArrayList;
import java.util.Collections;
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

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (GenerateTeam gt : teamList) {
            s.append(gt.toString());
            s.append("\n");
        }
        return s.toString();
    }


}
