package pprog.repository;

import pprog.domain.Skill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SkillRepository {

    private List<Skill> skillsList;

    public SkillRepository(List<Skill> skillsList) {
        this.skillsList = skillsList;
    }

    public SkillRepository() {
        skillsList = new ArrayList<>();
    }

    public List<Skill> getSkillsList() {
        return skillsList;
    }

    public void setSkillsList(List<Skill> skillsList) {
        this.skillsList = skillsList;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Skill sk : skillsList) {
            s.append(sk.toString());
            s.append("\n");
        }
        return s.toString();
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }

        SkillRepository outraSkillsList = (SkillRepository) outroObjeto;
        if (!(this.skillsList.size() == outraSkillsList.skillsList.size())) {
            return false;
        }

        List<Skill> skillsListTemp = new ArrayList<>(this.skillsList);
        List<Skill> outraSkillsListTemp = new ArrayList<>(outraSkillsList.skillsList);

        Collections.sort(skillsListTemp);
        Collections.sort(outraSkillsListTemp);

        return skillsListTemp.equals(outraSkillsListTemp);
    }

    public void addSKill(Skill s) {
        if (s.validateSkill()) {
            skillsList.add(s);
        }
    }


}
