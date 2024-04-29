package pprog.domain;

import pprog.repository.CollaboratorRepository;
import pprog.repository.JobRepository;
import pprog.repository.Repositories;

public class HumanResourcesManager {

    private String name;

    public HumanResourcesManager (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Human Resources Manager: %s\n", name);
    }

}
