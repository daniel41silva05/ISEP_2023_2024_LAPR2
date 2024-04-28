package pprog.controller;


import pprog.domain.Collaborator;
import pprog.domain.IdDocType;
import pprog.domain.Job;
import pprog.repository.CollaboratorRepository;
import pprog.repository.JobRepository;
import pprog.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.domain.Organization;
import pt.ipp.isep.dei.esoft.project.domain.TaskCategory;
import pt.ipp.isep.dei.esoft.project.repository.TaskCategoryRepository;

import java.util.List;
import java.util.Optional;

public class RegisterCollaboratorController {

    private CollaboratorRepository collaboratorRepository;
    private JobRepository jobRepository;

    public RegisterCollaboratorController() {
        getCollaboratorRepository();
        getJobRepository();
    }

    private CollaboratorRepository getCollaboratorRepository() {
        if (collaboratorRepository == null) {
            Repositories repositories = Repositories.getInstance();
            collaboratorRepository = repositories.getCollaboratorRepository();
        }
        return getCollaboratorRepository();
    }

    private JobRepository getJobRepository() {
        if (jobRepository == null) {
            Repositories repositories = Repositories.getInstance();
            jobRepository = repositories.getJobRepository();
        }
        return getJobRepository();
    }

    public Optional<Collaborator> registerCollaborator(String name, String birthday, String admissionDate, String address, int phoneNumber, String email, IdDocType idDocType, int idNumber, String jobName) {

        Job job = getJobByName(jobName);

        Optional<Collaborator> newCollaborator = Optional.empty();
        Collaborator collaborator = new Collaborator(name, birthday, admissionDate, address, phoneNumber, email, idDocType, idNumber, job);
        newCollaborator = Optional.of(collaborator);

        return newCollaborator;
    }

    private Job getJobByName(String jobName) {
        JobRepository jobRepository = getJobRepository();
        Job jobByName = getJobRepository().getJobByName(jobName);
        return jobByName;
    }

    public List<Job> getJobsList() {
        JobRepository jobRepository = getJobRepository();
        return jobRepository.getJobsList();
    }

}
