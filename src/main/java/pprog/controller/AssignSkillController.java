package pprog.controller;

import pprog.domain.Collaborator;
import pprog.domain.Job;
import pprog.domain.Skill;
import pprog.repository.CollaboratorRepository;
import pprog.repository.JobRepository;
import pprog.repository.Repositories;
import pprog.repository.SkillRepository;

import java.util.Collections;
import java.util.List;

public class AssignSkillController {

    private List<Skill> skillsToAssign;
    private SkillRepository skillRepository;
    private CollaboratorRepository collaboratorRepository;

    public AssignSkillController(SkillRepository skillRepository, CollaboratorRepository collaboratorRepository) {
        this.skillRepository = skillRepository;
        this.collaboratorRepository = collaboratorRepository;
    }

    public AssignSkillController() {
        getSkillRepository();
        getCollaboratorRepository();
    }

    public List<Skill> getSkillsToAssign() {
        return skillsToAssign;
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

    public void setSkillsToAssign(List<Skill> skillsToAssign) {
        this.skillsToAssign = skillsToAssign;
    }

    public Collaborator getCollaboratorByName(String collaboratorName) {
        for (Collaborator collaborator : collaboratorRepository.getCollaboratorsList()) {
            if (collaborator.getName().equals(collaboratorName)) {
                return collaborator;
            }
        }
        return null;
    }

    public List<Collaborator> getCollaboratorList() {
        return collaboratorRepository.getCollaboratorsList();
    }

    private Skill getSkillByName(String skillName) {
        SkillRepository skillRepository = getSkillRepository();
        return skillRepository.getSkillByName(skillName);
    }
    public List<Skill> getSkillsList() {
        return skillRepository.getSkillsList();
    }

    public void assignSkillToCollaborator(Collaborator collaborator, List<Skill> skillsToAssign) {
        for (Skill skill: skillsToAssign) {
            collaborator.getSkillAssign().add(skill);
        }
    }

    public List<Skill> getSkillsOfCollaborator(Collaborator collaborator) {
        return collaborator.getSkillAssign();
    }

}
