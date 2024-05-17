package pprog.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the generation of a team based on specific criteria.
 */
public class Team {

    /**
     * List of collaborators needed for the team.
     */
    private List<Collaborator> collaborators;

    public Team (List<Collaborator> members) {
        collaborators = members;
    }

    /**
     * Retrieves the list of collaborators with the required skills.
     *
     * @param collaboratorList The list of available collaborators.
     * @param skillsNeeded     The list of skills needed for the team.
     * @return The list of collaborators with the required skills.
     */
    public static List<Collaborator> seeColaboratorsWithSkillsNeeded(List<Collaborator> collaboratorList, List<Skill> skillsNeeded) {
        List<Collaborator> collaboratorWithTheSkills = new ArrayList<>();
        List<Skill> skillsAdded = new ArrayList<>();
        for (Collaborator c : collaboratorList) {
            List<Skill> cSkills = c.getSkillAssign();
            boolean collaboratorAdded = false;
            for (Skill cskill : cSkills) {
                if (skillsNeeded.contains(cskill)) {
                    if (!collaboratorAdded) {
                        collaboratorWithTheSkills.add(c);
                        collaboratorAdded = true;
                    }
                    skillsAdded.add(cskill);
                }
            }
            if (skillsAdded.containsAll(skillsNeeded)) {
                break;
            }
        }
        return collaboratorWithTheSkills;
    }

    /**
     * Generates a random number within the specified range.
     *
     * @param minSize The minimum value of the range.
     * @param maxSize The maximum value of the range.
     * @return A random number within the range.
     * @throws IllegalArgumentException if max is less than or equal to min.
     */
    public boolean teamValidations (int minSize, int maxSize, List<Skill> requiredSkills, List<Collaborator> collaboratorList) {
        int teamSize = seeColaboratorsWithSkillsNeeded(collaboratorList, requiredSkills).size();
        if (minSize > maxSize) {
            throw new IllegalArgumentException("Max must be greater than min.");
        } else if (teamSize > maxSize || teamSize < minSize) {
            throw new IllegalArgumentException("The team size does not meet the desired size.");
        }
        return true;
    }

    public List<Collaborator> getTeam() {
        return collaborators;
    }

    public void setTeam(List<Collaborator> team) {
        this.collaborators = team;
    }

    /**
     * Creates a deep copy of the GenerateTeam object.
     *
     * @return A deep copy of the GenerateTeam object.
     */
    public Team clone() {
        return new Team(this.collaborators);
    }

    @Override
    public String toString() {
        StringBuilder team = new StringBuilder();

        for (Collaborator member : this.collaborators){
            team.append(member);
            team.append("\n");
        }

        return team.toString();
    }
}
