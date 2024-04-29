package pprog.domain;

public class Skill implements Comparable<Skill>{

    private String skill;

    private static final String SKILL_POR_OMISSAO = "sem skill";

    public Skill() {
        skill = SKILL_POR_OMISSAO;
    }

    public Skill(String skill) {
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return String.format("Skill: %s", skill);
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Skill outraSkill = (Skill) outroObjeto;
        return skill.equalsIgnoreCase(outraSkill.skill);
    }

    @Override
    public int compareTo(Skill s) {
        return this.skill.compareTo(s.skill);
    }

    public boolean validateSkill() {
        return this.skill.matches("[a-zA-Z ]+") && !this.skill.matches(".*\\d.*");
    }
}
