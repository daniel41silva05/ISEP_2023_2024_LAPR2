package pprog.controller;

import pprog.domain.Skill;
import pprog.repository.Repositories;
import pprog.repository.SkillRepository;

import java.util.List;

/**
 * Controller for registering skills.
 */
public class RegisterSkillController {

    /**
     * The skill repository used for registering skills.
     */
    private SkillRepository skillRepository;

    /**
     * Constructs a RegisterSkillController with the given skill repository.
     *
     * @param skillRepository the skill repository to use
     */
    public RegisterSkillController(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    /**
     * Constructs a RegisterSkillController using the global skill repository.
     */
    public RegisterSkillController() {
        getSkillRepository();
    }

    /**
     * Gets the skill repository.
     * If not already initialized, initializes it using the global repository.
     *
     * @return the skill repository
     */
    public SkillRepository getSkillRepository() {
        if (skillRepository == null) {
            Repositories repositories = Repositories.getInstance();
            skillRepository = repositories.getSkillRepository();
        }
        return skillRepository;
    }

    private Skill getSkillByName(String skillName) {
        SkillRepository skillRepository = getSkillRepository();
        return skillRepository.getSkillByName(skillName);
    }

    /**
     * Registers a new skill.
     *
     * @param s the skill to register
     * @return the newly registered skill, or null if registration fails
     */
    public boolean registerSkill(String skillName) {
        if (skillName == null || skillName.trim().isEmpty()) {
            throw new IllegalArgumentException("Skill name cannot be null or empty");
        }
        Skill skill = new Skill(skillName);
        return skillRepository.registerSkill(skill);
    }

    public List<Skill> getSkillsList() {
        SkillRepository skillRepository = getSkillRepository();
        return skillRepository.getSkillsList();
    }

}
