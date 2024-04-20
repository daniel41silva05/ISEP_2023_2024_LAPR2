package pprog.repository;

import pprog.domain.Job;
import java.util.ArrayList;
import java.util.List;

public class JobRepository {

    private List<Job> jobs;

    public JobRepository() {
        this.jobs = new ArrayList<>();
    }

    public void save(Job job) {
        jobs.add(job);
    }

    public List<Job> getAllJobs() {
        return jobs;
    }

}
