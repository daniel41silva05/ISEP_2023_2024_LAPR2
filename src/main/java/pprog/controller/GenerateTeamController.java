package pprog.controller;

import pprog.domain.Collaborator;
import pprog.domain.GenerateTeam;
import pprog.domain.Skill;
import pprog.repository.*;

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

    public List<Collaborator> team(int minSize, int maxSize, List<Skill> requiredSkills) {

        return generateTeamRepository.team(minSize, maxSize, requiredSkills, getCollaboratorList());
    }

    public List<Skill> getSkillList() {
        SkillRepository skillRepository = getSkillRepository();
        return skillRepository.getSkillsList();
    }

    public List<Collaborator> getCollaboratorList() {
        CollaboratorRepository collaboratorRepository = getCollaboratorRepository();
        return collaboratorRepository.getCollaboratorsList();
    }

    public List<GenerateTeam> getTeamList() {
        GenerateTeamRepository generateTeamRepository = getGenerateTeamRepository();
        return generateTeamRepository.getTeamList();
    }

}
