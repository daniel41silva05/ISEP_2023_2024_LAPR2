package pprog.controller;

import pprog.domain.Collaborator;
import pprog.domain.GenerateTeam;
import pprog.domain.Skill;
import pprog.repository.CollaboratorRepository;
import pprog.repository.GenerateTeamRepository;
import pprog.repository.Repositories;
import pprog.repository.SkillRepository;

import java.util.List;

public class GenerateTeamController {

    private SkillRepository skillRepository;
    private CollaboratorRepository collaboratorRepository;
    private GenerateTeamRepository generateTeamRepository;

    public GenerateTeamController() {
        getSkillRepository();
        getCollaboratorRepository();
        getGenerateTeamRepository();
    }

    public GenerateTeamController(SkillRepository skillRepository, CollaboratorRepository collaboratorRepository, GenerateTeamRepository generateTeamRepository) {
        this.skillRepository = skillRepository;
        this.collaboratorRepository = collaboratorRepository;
        this.generateTeamRepository = generateTeamRepository;
    }

    public SkillRepository getSkillRepository() {
        if (skillRepository == null) {
            Repositories repositories = Repositories.getInstance();
            skillRepository = repositories.getSkillRepository();
        }
        return skillRepository;
    }

    public CollaboratorRepository getCollaboratorRepository() {
        if (collaboratorRepository == null) {
            Repositories repositories = Repositories.getInstance();
            collaboratorRepository = repositories.getCollaboratorRepository();
        }
        return collaboratorRepository;
    }

    public GenerateTeamRepository getGenerateTeamRepository() {
        if (generateTeamRepository == null) {
            Repositories repositories = Repositories.getInstance();
            generateTeamRepository = repositories.getGenerateTeamRepository();
        }
        return generateTeamRepository;
    }

    public GenerateTeam generateTeam(int maxSize, int minSize, List<Skill> skillsNeeded) {
        validateTeamParameters(maxSize, minSize);
        return generateTeamRepository.generateTeam(maxSize, minSize, skillsNeeded);
    }

    private void validateTeamParameters(int maxSize, int minSize) {
        if (maxSize < minSize) {
            throw new IllegalArgumentException("The maximum team size must be greater than or equal to the minimum size.");
        }

    }

    public List<Skill> getSkillList() {
        SkillRepository skillRepository = getSkillRepository();
        return skillRepository.getSkillsList();
    }

    public List<Collaborator> getCollaboratorList() {
        CollaboratorRepository collaboratorRepository = getCollaboratorRepository();
        return collaboratorRepository.getCollaboratorsList();
    }
}
