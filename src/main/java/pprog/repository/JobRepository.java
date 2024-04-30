package pprog.repository;

import pprog.domain.Collaborator;
import pprog.domain.Job;
import pprog.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository class to manage jobs.
 */
public class JobRepository {

    /** The list of jobs stored in this repository. */
    private final List<Job> jobsList;

    /**
     * Constructs a JobRepository with an empty list of jobs.
     */
    public JobRepository() {
        jobsList = new ArrayList<>();
    }

    /**
     * Adds a job to the repository.
     * @param job The job to be added.
     */
    public boolean addJob(Job job){
        boolean success = false;
        if (validateJob(job)) {
            success = jobsList.add(job.clone());
        }
        return success;
    }

    /**
     * Retrieves a job by its name.
     * @param jobName The name of the job to retrieve.
     * @return The Job object with the specified name, or null if not found.
     */
    public Job getJobByName(String jobName) {
        for (Job job : jobsList) {
            if (job.getName().equals(jobName)) {
                return job;
            }
        }
        return null;
    }

    /**
     * Validates a job before adding it to the repository.
     *
     * @param job       The job to be validated.
     * @return          True if the job is valid (not already in the repository), false otherwise.
     */
    private boolean validateJob (Job job) {
        boolean isValid = !jobsList.contains(job);
        return isValid;
    }

    /**
     * Gets the list of all jobs stored in this repository.
     * @return The list of jobs.
     */
    public List<Job> getJobsList() {
        return jobsList;
    }

    /**
     * Returns a string representation of this JobRepository.
     * @return A string representation containing all jobs.
     */
    @Override
    public String toString() {
        return "Jobs=" + jobsList + '}';
    }

    public Job registerJob(String name, String description) {
        Job newJob = null;
        Job job = new Job(name, description);

        if (addJob(job)){
            newJob = job;
        }
        return newJob;
    }
}
