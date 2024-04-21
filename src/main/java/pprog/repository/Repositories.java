package pprog.repository;

public class Repositories {
    private static Repositories instance;
    private CollaboratorRepository collaboratorRepository;
    private JobRepository jobRepository;

    private Repositories() {
        collaboratorRepository = new CollaboratorRepository();
        jobRepository = new JobRepository();
    }

    public static Repositories getInstance() {
        if (instance == null) {
            instance = new Repositories();
        }
        return instance;
    }

    public CollaboratorRepository getCollaboratorRepository() {
        return collaboratorRepository;
    }

    public JobRepository getJobRepository() {
        return jobRepository;
    }
}

