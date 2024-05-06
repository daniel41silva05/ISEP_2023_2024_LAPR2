package pprog.controller;

import pprog.domain.Job;
import pprog.repository.JobRepository;
import pprog.repository.Repositories;

import java.util.List;

/**
 * Controller class responsible for registering jobs.
 */
public class RegisterJobController {

    /**
     * The repository where the job data is stored.
     */
    private JobRepository jobRepository;

    /**
     * Default constructor. Retrieves the job repository instance.
     */
    public RegisterJobController() {
        getJobRepository();
    }

    /**
     * Constructor to set a specific job repository.
     * @param jobRepository The job repository to be set.
     */
    public RegisterJobController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    /**
     * Retrieves the job repository instance if not already set.
     * @return The job repository instance.
     */
    private JobRepository getJobRepository() {
        if (jobRepository == null) {
            Repositories repositories = Repositories.getInstance();
            jobRepository = repositories.getJobRepository();
        }
        return jobRepository;
    }

    /**
     * Registers a new job.
     * @param name The name of the job.
     * @param description The description of the job.
     * @return The registered job object.
     */
    public Job registerJob(String name, String description) {
        return jobRepository.registerJob(name, description);
    }

    public Job getJobByName(String jobName) {
        JobRepository jobRepository = getJobRepository();
        return jobRepository.getJobByName(jobName);
    }

    public List<Job> getJobsList() {
        JobRepository jobRepository = getJobRepository();
        return jobRepository.getJobsList();
    }
}
