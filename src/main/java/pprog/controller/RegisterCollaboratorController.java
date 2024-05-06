package pprog.controller;

import pprog.domain.Collaborator;
import pprog.domain.IdDocType;
import pprog.domain.Job;
import pprog.repository.CollaboratorRepository;
import pprog.repository.JobRepository;
import pprog.repository.Repositories;

import java.util.List;

/**
 * Controller responsible for registering collaborators.
 */
public class RegisterCollaboratorController {

    /**
     * The repository where the collaborator data is stored.
     */
    private CollaboratorRepository collaboratorRepository;

    /**
     * The repository where the job data is stored.
     */
    private JobRepository jobRepository;

    /**
     * Default constructor. Retrieves the collaborator and job repository instance.
     */
    public RegisterCollaboratorController() {
        getCollaboratorRepository();
        getJobRepository();
    }

    /**
     * Constructor that receives instances of CollaboratorRepository and JobRepository.
     *
     * @param collaboratorRepository the collaborator repository
     * @param jobRepository          the job repository
     */
    public RegisterCollaboratorController(CollaboratorRepository collaboratorRepository, JobRepository jobRepository) {
        this.collaboratorRepository = collaboratorRepository;
        this.jobRepository = jobRepository;
    }

    /**
     * Gets the collaborator repository, if not already initialized.
     *
     * @return the collaborator repository
     */
    private CollaboratorRepository getCollaboratorRepository() {
        if (collaboratorRepository == null) {
            Repositories repositories = Repositories.getInstance();
            collaboratorRepository = repositories.getCollaboratorRepository();
        }
        return collaboratorRepository;
    }

    /**
     * Gets the job repository, if not already initialized.
     *
     * @return the job repository
     */
    private JobRepository getJobRepository() {
        if (jobRepository == null) {
            Repositories repositories = Repositories.getInstance();
            jobRepository = repositories.getJobRepository();
        }
        return jobRepository;
    }

    /**
     * Registers a new collaborator.
     *
     * @param name          the name of the collaborator
     * @param birthday      the birthday of the collaborator
     * @param admissionDate the admission date of the collaborator
     * @param address       the address of the collaborator
     * @param phoneNumber   the phone number of the collaborator
     * @param email         the email of the collaborator
     * @param idDocType     the ID document type of the collaborator
     * @param idNumber      the ID number of the collaborator
     * @param jobName       the job name of the collaborator
     * @return the registered collaborator
     */
    public Collaborator registerCollaborator(String name, String birthday, String admissionDate, String address, int phoneNumber, String email, IdDocType idDocType, int idNumber, String jobName) {
        Job job = getJobByName(jobName);
        if (job == null) {
            return null;
        }
        return collaboratorRepository.registerCollaborator(name, birthday, admissionDate, address, phoneNumber, email, idDocType, idNumber, job);
    }

    /**
     * Gets a job by name.
     *
     * @param jobName the job name
     * @return the job corresponding to the name
     */
    private Job getJobByName(String jobName) {
        JobRepository jobRepository = getJobRepository();
        return jobRepository.getJobByName(jobName);
    }

    /**
     * Gets the list of all available jobs.
     *
     * @return the list of jobs
     */
    public List<Job> getJobsList() {
        JobRepository jobRepository = getJobRepository();
        return jobRepository.getJobsList();
    }

    public List<Collaborator> getCollaboratorsList() {
        CollaboratorRepository collaboratorRepository = getCollaboratorRepository();
        return collaboratorRepository.getCollaboratorsList();
    }

}
