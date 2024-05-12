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
     * Gets the skill with the specified name from the repository.
     *
     * @param skillName the name of the skill to retrieve
     * @return the skill with the specified name, or null if not found
     */
    public Skill getSkillByName(String skillName) {
        for (Skill skill : skillsList) {
            if (skill.getSkill().equals(skillName)) {
                return skill;
            }
        }
        return null;
    }

    /**
     * Adds a skill to the repository.
     *
     * @param skill the skill to add
     * @return true if the skill is added successfully; false otherwise
     * @throws IllegalArgumentException if the skill name is invalid
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
     * @return true if the skill is successfully registered; false otherwise
     * @throws IllegalArgumentException if the skill already exists in the repository
     */
    public boolean registerSkill(Skill skill) {
        if (isSkillInList(skill)) {
            throw new IllegalArgumentException("Skill already exists in the repository");
        }
        return addSkill(skill);
    }

    /**
     * Retrieves the list of skills in the repository.
     *
     * @return the list of skills
     */
    public List<Skill> getSkillsList() {
        return skillsList;
    }

    /**
     * Sets the list of skills in the repository.
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
}
