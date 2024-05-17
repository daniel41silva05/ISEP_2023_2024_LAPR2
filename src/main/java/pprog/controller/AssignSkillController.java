package pprog.controller;

import pprog.domain.Collaborator;
import pprog.domain.Skill;
import pprog.repository.CollaboratorRepository;
import pprog.repository.Repositories;
import pprog.repository.SkillRepository;

import java.util.ArrayList;
import java.util.List;

public class AssignSkillController {

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

    public Collaborator getCollaboratorByName(String collaboratorName) {
        return getCollaboratorRepository().getCollaboratorByName(collaboratorName);
    }

    public List<Collaborator> getCollaboratorList() {
        return getCollaboratorRepository().getCollaboratorsList();
    }

    private Skill getSkillByName(String skillName) {
        return getSkillRepository().getSkillByName(skillName);
    }

    public List<Skill> getSkillsList() {
        return getSkillRepository().getSkillsList();
    }

    public boolean assignSkillToCollaborator(String nameCollaborator, List<String> skillNames) {
        List<Skill> skillsToAssign = new ArrayList<>();
        try {
            for (String skillName : skillNames) {
                skillsToAssign.add(getSkillByName(skillName.trim()));
            }
            for (Skill skill: skillsToAssign) {
                getCollaboratorByName(nameCollaborator).getSkillAssign().add(skill);
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
            return false;
        }
    }

}
