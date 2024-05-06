package pprog.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GenerateTeam {

    private int minSize;
    private int maxSize;
    private List<Skill> skillsNeeded;
    private List<Collaborator> collaboratorsNeeded;

    public GenerateTeam(int minSize, int maxSize, List<Skill> skillsNeeded) {
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.skillsNeeded = skillsNeeded;
        this.collaboratorsNeeded = new ArrayList<>();
    }

    public List<Collaborator> seeColaboratorsWithSkillsNeeded(List<Collaborator> collaboratorList, List<Skill> skillsNeeded) {
        List<Collaborator> collaboratorWithTheSkills = new ArrayList<>();
        for (Collaborator c : collaboratorList) {
            List<Skill> cSkills = c.getSkillAssign();
            for (Skill s: skillsNeeded) {
                if (cSkills.contains(s)) {
                    collaboratorWithTheSkills.add(c);
                    break;
                }
            }
        }
        return collaboratorWithTheSkills;
    }

    public List<Collaborator> generateRandomTeam(List<Collaborator> collaboratorWithTheSkills, int maxSize, int minSize) {
        List<Collaborator> team = new ArrayList<>();
        Collections.shuffle(collaboratorWithTheSkills);
        int teamSize = getRandomNumberInRange(minSize, maxSize);
        for (int i = 0; i < Math.min(teamSize, collaboratorWithTheSkills.size()); i++) {
            team.add(collaboratorWithTheSkills.get(i));
        }

        return team;
    }

    private int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Skill> getSkillAssign() {
        return skillsNeeded;
    }

    public List<Collaborator> getCollaboratorsNeeded() {
        return collaboratorsNeeded;
    }

    public GenerateTeam clone() {
        return new GenerateTeam(this.minSize, this.maxSize, this.skillsNeeded);
    }

}
