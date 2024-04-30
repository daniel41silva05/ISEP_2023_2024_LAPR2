package pprog.repository;

import pprog.domain.Skill;

import java.util.ArrayList;
import java.util.Collections;
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
     * @param s the skill to add
     * @return true if the skill is added successfully; false otherwise
     */
    public boolean addSkill(Skill s) {
        if (s.validateSkill()) {
            return skillsList.add(s);
        } else {
            return false;
        }
    }

    /**
     * Checks if a skill is in the repository.
     *
     * @param s the skill to check
     * @return true if the skill is in the repository; false otherwise
     */
    public boolean isSkillInList(Skill s) {
        return skillsList.contains(s);
    }

    /**
     * Registers a new skill in the repository.
     *
     * @param s the skill to register
     * @return the newly registered skill, or null if registration fails
     */
    public Skill registerSkill(String s) {
        Skill newSkill = null;
        Skill skill = new Skill(s);
        if (addSkill(skill)) {
            newSkill = skill;
        }
        return newSkill;
    }

}
