package pprog.repository;

import pprog.domain.Job;
import java.util.ArrayList;
import java.util.List;

public class JobRepository {

    private List<Job> jobsList;

    public JobRepository() {
        this.jobsList = new ArrayList<>();
    }

    public List<Job> getJobsList() {
        return jobsList;
    }

}
