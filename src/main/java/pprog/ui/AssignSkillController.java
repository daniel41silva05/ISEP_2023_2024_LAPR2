package pprog.ui;

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

    }
