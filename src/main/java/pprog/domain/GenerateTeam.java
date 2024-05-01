package pprog.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GenerateTeam {

    private int minSize;
    private int maxSize;
    private List<Skill> skillsList;
    private List<Skill> skillsNeeded;
    private List<Collaborator> collaboratorList;
    private static final int MIN_SIZE_POR_OMISSAO = 2;
    private static final int MAX_SIZE_POR_OMISSAO = 10000;

    public GenerateTeam() {
        minSize = MIN_SIZE_POR_OMISSAO;
        maxSize = MAX_SIZE_POR_OMISSAO;
        skillsList = new ArrayList<>();
        skillsNeeded = new ArrayList<>();
        collaboratorList = new ArrayList<>();
    }

    public GenerateTeam(int minSize, int maxSize, List<Skill> skillsList, List<Skill> skillsNeeded, List<Collaborator> collaboratorList){
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.skillsList = skillsList;
        this.skillsNeeded = skillsNeeded;
        this.collaboratorList = collaboratorList;
    }

    public int getMinSize() {
        return minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public List<Skill> getSkillsList() {
        return skillsList;
    }

    public List<Skill> getSkillsNeeded() {
        return skillsNeeded;
    }

    public List<Collaborator> getCollaboratorList() {
        return collaboratorList;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void setSkillsNeeded(List<Skill> skillsNeeded) {
        this.skillsNeeded = skillsNeeded;
    }

    public List<Collaborator> seeColaboratorsWithSkillsNeeded(List<Skill> skillsNeeded) {
        List<Collaborator> collaboratorWithTheSkills = new ArrayList<>();
        for (Collaborator c: collaboratorList) {
            List<Skill> cSkills = c.getSkillAssign();
            for (Skill s: skillsNeeded) {
                if (cSkills.contains(s)) {
                    collaboratorWithTheSkills.add(c);
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


    @Override
    public String toString() {
        return String.format("Min Size: %d\nMax Size: %d\nSkill: %s", minSize, maxSize, skillsList);
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        GenerateTeam outraGenerateTeam = (GenerateTeam) outroObjeto;
        return minSize == outraGenerateTeam.minSize &&
                maxSize == outraGenerateTeam.maxSize &&
                skillsList.equals(outraGenerateTeam.skillsList);
    }


}
