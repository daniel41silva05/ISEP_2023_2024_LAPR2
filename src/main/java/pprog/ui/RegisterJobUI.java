package pprog.ui;

import java.util.ArrayList;
import java.util.List;
import pprog.domain.Job;

public class RegisterJobUI {
    private List<Job> job;

    public JobRepository() {
        this.job = new ArrayList<>();
    }

    public void save(Job job) {
        job.add(job);
    }

    public List<Job> getAllVehicle() {
        return job;
    }

}
