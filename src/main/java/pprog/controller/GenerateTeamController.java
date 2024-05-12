package pprog.controller;

import pprog.domain.Collaborator;
import pprog.domain.GenerateTeam;
import pprog.domain.Skill;
import pprog.repository.*;

import java.util.List;

/**
 * Controller class for managing generation of teams.
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
     * @return A list of collaborators forming the generated team.
     */
    public List<Collaborator> team(int minSize, int maxSize, List<Skill> requiredSkills) {
        return generateTeamRepository.team(minSize, maxSize, requiredSkills, getCollaboratorList());
    }

    /**
     * Retrieves the list of skills.
     *
     * @return The list of skills.
     */
    public List<Skill> getSkillList() {
        SkillRepository skillRepository = getSkillRepository();
        return skillRepository.getSkillsList();
    }

    /**
     * Retrieves the list of collaborators.
     *
     * @return The list of collaborators.
     */
    public List<Collaborator> getCollaboratorList() {
        CollaboratorRepository collaboratorRepository = getCollaboratorRepository();
        return collaboratorRepository.getCollaboratorsList();
    }

    /**
     * Retrieves the list of generated teams.
     *
     * @return The list of generated teams.
     */
    public List<GenerateTeam> getTeamList() {
        GenerateTeamRepository generateTeamRepository = getGenerateTeamRepository();
        return generateTeamRepository.getTeamList();
    }
}
