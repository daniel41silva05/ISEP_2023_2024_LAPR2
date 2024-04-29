package pprog.repository;

import pprog.domain.Job;

import java.util.ArrayList;
import java.util.List;

public class JobRepository {

    private final List<Job> jobsList;

    public JobRepository() { jobsList = new ArrayList<>();}

    public void addJob(Job job){
        jobsList.add(job);
    }

    public Job getJobByName (String jobName) {
        Job newJob = new Job(jobName);
        Job job = null;
        if (jobsList.contains(newJob)) {
            job = jobsList.get(jobsList.indexOf(newJob));
        }
        if (job == null) {
            throw new IllegalArgumentException(
                    "Job requested for [" + jobName + "] does not exist.");
        }
        return job;
    }

    public List<Job> getJobsList() {
        return jobsList;
    }

    @Override
    public String toString() {
        return "Jobs=" + jobsList + '}';
    }
}
