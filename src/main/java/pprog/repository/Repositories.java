package pprog.repository;

public class Repositories {
    private static Repositories instance;
    private final CollaboratorRepository collaboratorRepository;
    private final JobRepository jobRepository;
    private final VehicleRepository vehicleRepository;

    private final SkillRepository skillRepository;

    private Repositories() {
        collaboratorRepository = new CollaboratorRepository();
        jobRepository = new JobRepository();
        vehicleRepository = new VehicleRepository();
        skillRepository = new SkillRepository();
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

    public VehicleRepository getVehicleRepository() {
        return vehicleRepository;
    }

    public SkillRepository getSkillRepository() {
        return skillRepository;
    }
}

