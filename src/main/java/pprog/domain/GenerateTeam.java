package pprog.domain;

public class GenerateTeam implements Comparable<GenerateTeam> {

    private int minSize;
    private int maxSize;
    private Skill skill;
    private static final int MIN_SIZE_POR_OMISSAO = 2;
    private static final int MAX_SIZE_POR_OMISSAO = 10000;

    public GenerateTeam() {
        minSize = MIN_SIZE_POR_OMISSAO;
        maxSize = MAX_SIZE_POR_OMISSAO;
        skill = new Skill();
    }

    public GenerateTeam(int minSize, int maxSize, Skill skill) {
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.skill = skill;
    }

    public int getMinSize() {
        return minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return String.format("Min Size: %d\nMax Size: %d\nSkill: %s", minSize, maxSize, skill);
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
                skill.equals(outraGenerateTeam.skill);
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

        return this.skill.compareTo(gt.skill);
    }

}
