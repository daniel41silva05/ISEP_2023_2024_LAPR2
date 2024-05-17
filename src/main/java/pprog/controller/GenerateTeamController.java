package pprog.controller;

import pprog.domain.Collaborator;
import pprog.domain.Skill;
import pprog.repository.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller class for managing the generation of teams.
 */
public class GenerateTeamController {

    /**
     * Repository for managing skills.
     */
    private SkillRepository skillRepository;

    /**
     * Repository for managing collaborators.
     */
    private CollaboratorRepository collaboratorRepository;

    /**
     * Repository for managing generated teams.
     */
    private GenerateTeamRepository generateTeamRepository;

    /**
     * Constructs a new GenerateTeamController and initializes repositories.
     */
    public GenerateTeamController() {
        getSkillRepository();
        getCollaboratorRepository();
        getGenerateTeamRepository();
    }

    /**
     * Constructs a new GenerateTeamController with provided repositories.
     *
     * @param skillRepository        The skill repository.
     * @param collaboratorRepository The collaborator repository.
     * @param generateTeamRepository The generate team repository.
     */
    public GenerateTeamController(SkillRepository skillRepository, CollaboratorRepository collaboratorRepository, GenerateTeamRepository generateTeamRepository) {
        this.skillRepository = skillRepository;
        this.collaboratorRepository = collaboratorRepository;
        this.generateTeamRepository = generateTeamRepository;
    }

    /**
     * Retrieves the skill repository.
     *
     * @return The skill repository.
     */
    public SkillRepository getSkillRepository() {
        if (skillRepository == null) {
            Repositories repositories = Repositories.getInstance();
            skillRepository = repositories.getSkillRepository();
        }
        return skillRepository;
    }

    /**
     * Retrieves the collaborator repository.
     *
     * @return The collaborator repository.
     */
    public CollaboratorRepository getCollaboratorRepository() {
        if (collaboratorRepository == null) {
            Repositories repositories = Repositories.getInstance();
            collaboratorRepository = repositories.getCollaboratorRepository();
        }
        return collaboratorRepository;
    }

    /**
     * Retrieves the generate team repository.
     *
     * @return The generate team repository.
     */
    public GenerateTeamRepository getGenerateTeamRepository() {
        if (generateTeamRepository == null) {
            Repositories repositories = Repositories.getInstance();
            generateTeamRepository = repositories.getGenerateTeamRepository();
        }
        return generateTeamRepository;
    }

    /**
     * Generates a team based on the given criteria.
     *
     * @param minSize        The minimum size of the team.
     * @param maxSize        The maximum size of the team.
     * @param requiredSkills The list of required skills for the team.
     * @return True if team generation was successful, false otherwise.
     */
    public boolean team(int minSize, int maxSize, List<String> requiredSkills) {
        List<Skill> skillsNeeded = new ArrayList<>();
        try {
            for (String skill : requiredSkills) {
                skillsNeeded.add(getSkillByName(skill.trim()));
            }
            getGenerateTeamRepository().team(minSize, maxSize, skillsNeeded, getCollaboratorList());
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
            return false;
        }
    }

    private Skill getSkillByName(String skillName) {
        return getSkillRepository().getSkillByName(skillName);
    }

    /**
     * Retrieves the list of skills.
     *
     * @return The list of skills.
     */
    public List<Skill> getSkillList() {
        return getSkillRepository().getSkillsList();
    }

    /**
     * Retrieves the list of collaborators.
     *
     * @return The list of collaborators.
     */
    public List<Collaborator> getCollaboratorList() {
        return getCollaboratorRepository().getCollaboratorsList();
    }
}
