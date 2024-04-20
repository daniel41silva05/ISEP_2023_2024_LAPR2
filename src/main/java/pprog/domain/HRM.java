package pprog.domain;

import pprog.repository.CollaboratorRepository;
import pprog.repository.JobRepository;

public class HRM {

    private String name;
    private CollaboratorRepository collaboratorRepository;
    private JobRepository jobRepository;

    public HRM (String name, CollaboratorRepository collaboratorRepository, JobRepository jobRepository) {
        this.name = name;
        this.collaboratorRepository = collaboratorRepository;
        this.jobRepository = jobRepository;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void registerCollaborator (Collaborator collaborator, Job job) {
        collaboratorRepository.save(collaborator);
    }

    @Override
    public String toString() {
        return String.format("Human Resources Manager: %s\n", name);
    }

}
