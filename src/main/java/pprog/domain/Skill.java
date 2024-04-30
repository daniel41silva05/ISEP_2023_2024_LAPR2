package pprog.domain;

/**
 * Represents a skill.
 */
public class Skill implements Comparable<Skill> {

    /**
     * The skill value.
     */
    private String skill;

    /**
     * Default skill value if none is provided.
     */
    private static final String SKILL_POR_OMISSAO = "sem skill";

    /**
     * Constructs a new Skill object with the default skill.
     */
    public Skill() {
        skill = SKILL_POR_OMISSAO;
    }

    /**
     * Constructs a new Skill object with the specified skill.
     *
     * @param skill the skill to set
     */
    public Skill(String skill) {
        this.skill = skill;
    }

    /**
     * Gets the skill.
     *
     * @return the skill
     */
    public String getSkill() {
        return skill;
    }

    /**
     * Sets the skill.
     *
     * @param skill the skill to set
     */
    public void setSkill(String skill) {
        this.skill = skill;
    }

    /**
     * Returns a string representation of the skill.
     *
     * @return a string representation of the skill
     */
    @Override
    public String toString() {
        return String.format("Skill: %s", skill);
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param outroObjeto the reference object with which to compare
     * @return true if this object is the same as the obj argument; false otherwise
     */
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

    /**
     * Compares this skill with the specified skill for order.
     *
     * @param s the skill to be compared
     * @return a negative integer, zero, or a positive integer as this skill is less than, equal to, or greater than the specified skill
     */
    @Override
    public int compareTo(Skill s) {
        return this.skill.compareTo(s.skill);
    }

    /**
     * Validates the skill.
     *
     * @return true if the skill contains only letters and spaces and does not contain any digits; false otherwise
     */
    public boolean validateSkill() {
        return this.skill.matches("[a-zA-Z ]+") && !this.skill.matches(".*\\d.*");
    }
}
