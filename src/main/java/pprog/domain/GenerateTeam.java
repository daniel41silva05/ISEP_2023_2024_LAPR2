package pprog.domain;

import java.util.ArrayList;
import java.util.List;

public class GenerateTeam {

    private int minSize;
    private int maxSize;
    private List<Skill> skillsList;
    private static final int MIN_SIZE_POR_OMISSAO = 2;
    private static final int MAX_SIZE_POR_OMISSAO = 10000;

    public GenerateTeam() {
        minSize = MIN_SIZE_POR_OMISSAO;
        maxSize = MAX_SIZE_POR_OMISSAO;
        skillsList = new ArrayList<>();
    }

    public GenerateTeam(int minSize, int maxSize, List<Skill> skillsList) {
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.skillsList = skillsList;
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

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void setSkillsList(List<Skill> skillsList) {
        this.skillsList = skillsList;
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
