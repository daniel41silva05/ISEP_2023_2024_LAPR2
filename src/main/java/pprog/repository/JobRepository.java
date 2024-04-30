package pprog.repository;

import pprog.domain.Collaborator;
import pprog.domain.Job;

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
    public void addJob(Job job){
        jobsList.add(job);
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

}
