package pprog.controller;

import pprog.domain.Skill;
import pprog.repository.Repositories;
import pprog.repository.SkillRepository;

public class RegisterSkillController {

    private SkillRepository skillRepository;

    public RegisterSkillController(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public RegisterSkillController() {
        getSkillRepository();
    }

    public SkillRepository getSkillRepository() {
        if (skillRepository == null) {
            Repositories repositories = Repositories.getInstance();
            skillRepository = repositories.getSkillRepository();
        }
        return skillRepository;
    }

    public Skill registerSkill(String s) {
        return new Skill(s);
    }

}
