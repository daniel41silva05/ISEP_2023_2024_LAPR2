package pprog.domain;

import java.util.ArrayList;
import java.util.List;

public class GenerateTeam implements Comparable<GenerateTeam> {

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

    @Override
    public int compareTo(GenerateTeam gt) {
        int minSizeComparison = Integer.compare(this.minSize, gt.minSize);
        if (minSizeComparison != 0) {
            return minSizeComparison;
        }

        int maxSizeComparison = Integer.compare(this.maxSize, gt.maxSize);
        if (maxSizeComparison != 0) {
            return maxSizeComparison;
        }

        int skillsListSizeComparison = Integer.compare(this.skillsList.size(), gt.skillsList.size());
        if (skillsListSizeComparison != 0) {
            return skillsListSizeComparison;
        }

        for (int i = 0; i < this.skillsList.size(); i++) {
            int skillComparison = this.skillsList.get(i).compareTo(gt.skillsList.get(i));
            if (skillComparison != 0) {
                return skillComparison;
            }
        }

        return 0;
    }


}
