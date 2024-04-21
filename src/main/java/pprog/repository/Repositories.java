package pprog.repository;

public class Repositories {
    private static Repositories instance;
    private CollaboratorRepository collaboratorRepository;
    private JobRepository jobRepository;
    private VehicleRepository vehicleRepository;

    private Repositories() {
        collaboratorRepository = new CollaboratorRepository();
        jobRepository = new JobRepository();
        vehicleRepository = new VehicleRepository();
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
}

