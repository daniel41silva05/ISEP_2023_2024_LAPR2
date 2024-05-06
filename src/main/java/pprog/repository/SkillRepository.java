package pprog.repository;

import pprog.domain.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository for managing skills.
 */
public class SkillRepository {

    /**
     * The list of skills.
     */
    private List<Skill> skillsList;

    /**
     * Constructs a SkillRepository with the given list of skills.
     *
     * @param skillsList the list of skills
     */
    public SkillRepository(List<Skill> skillsList) {
        this.skillsList = skillsList;
    }

    /**
     * Constructs a SkillRepository with an empty list of skills.
     */
    public SkillRepository() {
        skillsList = new ArrayList<>();
    }

    /**
     * Gets the list of skills.
     *
     * @return the list of skills
     */
    public Skill getSkillByName(String skillName) {
        for (Skill skill : skillsList) {
            if (skill.getSkill().equals(skillName)) {
                return skill;
            }
        }
        return null;
    }
    public List<Skill> getSkillsList() {
        return skillsList;
    }

    /**
     * Sets the list of skills.
     *
     * @param skillsList the list of skills to set
     */
    public void setSkillsList(List<Skill> skillsList) {
        this.skillsList = skillsList;
    }

    /**
     * Returns a string representation of the skill repository.
     *
     * @return a string representation of the skill repository
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Skill sk : skillsList) {
            s.append(sk.toString());
            s.append("\n");
        }
        return s.toString();
    }

    /**
     * Adds a skill to the repository.
     *
     * @param skill the skill to add
     * @return true if the skill is added successfully; false otherwise
     */
    public boolean addSkill(Skill skill) {
        if (skill.validateSkill()) {
            return skillsList.add(skill);
        } else {
            throw new IllegalArgumentException("Invalid skill name");
        }
    }

    /**
     * Checks if a skill is in the repository.
     *
     * @param skill the skill to check
     * @return true if the skill is in the repository; false otherwise
     */
    public boolean isSkillInList(Skill skill) {
        return skillsList.contains(skill);
    }

    /**
     * Registers a new skill in the repository.
     *
     * @param skill the skill to register
     * @return the newly registered skill, or null if registration fails
     */
    public boolean registerSkill(Skill skill) {
        if (isSkillInList(skill)) {
            throw new IllegalArgumentException("Skill already exists in the repository");
        }
        return addSkill(skill);
    }

}
