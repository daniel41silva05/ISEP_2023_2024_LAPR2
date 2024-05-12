package pprog.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Class representing the generation of a team based on specific criteria.
 */
public class GenerateTeam {

    /**
     * Minimum size of the team.
     */
    private int minSize;

    /**
     * Maximum size of the team.
     */
    private int maxSize;

    /**
     * List of skills needed for the team.
     */
    private List<Skill> skillsNeeded;

    /**
     * List of collaborators needed for the team.
     */
    private List<Collaborator> collaboratorsNeeded;

    /**
     * Constructs a new GenerateTeam with specified parameters.
     *
     * @param minSize      The minimum size of the team.
     * @param maxSize      The maximum size of the team.
     * @param skillsNeeded The list of skills needed for the team.
     */
    public GenerateTeam(int minSize, int maxSize, List<Skill> skillsNeeded) {
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.skillsNeeded = skillsNeeded;
        this.collaboratorsNeeded = new ArrayList<>();
    }

    /**
     * Retrieves the list of collaborators with the required skills.
     *
     * @param collaboratorList The list of available collaborators.
     * @param skillsNeeded     The list of skills needed for the team.
     * @return The list of collaborators with the required skills.
     */
    public List<Collaborator> seeColaboratorsWithSkillsNeeded(List<Collaborator> collaboratorList, List<Skill> skillsNeeded) {
        List<Collaborator> collaboratorWithTheSkills = new ArrayList<>();
        for (Collaborator c : collaboratorList) {
            List<Skill> cSkills = c.getSkillAssign();
            for (Skill s : skillsNeeded) {
                if (cSkills.contains(s)) {
                    collaboratorWithTheSkills.add(c);
                    break;
                }
            }
        }
        return collaboratorWithTheSkills;
    }

    /**
     * Generates a random team from the list of collaborators with required skills.
     *
     * @param collaboratorWithTheSkills The list of collaborators with the required skills.
     * @param maxSize                   The maximum size of the team.
     * @param minSize                   The minimum size of the team.
     * @return A list of collaborators forming the generated team.
     */
    public List<Collaborator> generateRandomTeam(List<Collaborator> collaboratorWithTheSkills, int maxSize, int minSize) {
        List<Collaborator> team = new ArrayList<>();
        Collections.shuffle(collaboratorWithTheSkills);
        int teamSize = getRandomNumberInRange(minSize, maxSize);
        for (int i = 0; i < Math.min(teamSize, collaboratorWithTheSkills.size()); i++) {
            team.add(collaboratorWithTheSkills.get(i));
        }
        return team;
    }

    /**
     * Generates a random number within the specified range.
     *
     * @param min The minimum value of the range.
     * @param max The maximum value of the range.
     * @return A random number within the range.
     * @throws IllegalArgumentException if max is less than or equal to min.
     */
    private int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     * Retrieves the minimum size of the team.
     *
     * @return The minimum size of the team.
     */
    public int getMinSize() {
        return minSize;
    }

    /**
     * Sets the minimum size of the team.
     *
     * @param minSize The minimum size of the team.
     */
    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    /**
     * Retrieves the maximum size of the team.
     *
     * @return The maximum size of the team.
     */
    public int getMaxSize() {
        return maxSize;
    }

    /**
     * Sets the maximum size of the team.
     *
     * @param maxSize The maximum size of the team.
     */
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * Retrieves the list of skills needed for the team.
     *
     * @return The list of skills needed for the team.
     */
    public List<Skill> getSkillAssign() {
        return skillsNeeded;
    }

    /**
     * Retrieves the list of collaborators needed for the team.
     *
     * @return The list of collaborators needed for the team.
     */
    public List<Collaborator> getCollaboratorsNeeded() {
        return collaboratorsNeeded;
    }

    /**
     * Creates a deep copy of the GenerateTeam object.
     *
     * @return A deep copy of the GenerateTeam object.
     */
    public GenerateTeam clone() {
        return new GenerateTeam(this.minSize, this.maxSize, this.skillsNeeded);
    }
}
