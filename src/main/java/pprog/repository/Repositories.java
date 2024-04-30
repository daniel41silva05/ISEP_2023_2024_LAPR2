package pprog.repository;

/**
 * This class manages singleton instances of repositories.
 */
public class Repositories {
    /** The singleton instance of Repositories. */
    private static Repositories instance;

    /** The repository for collaborators. */
    private final CollaboratorRepository collaboratorRepository;

    /** The repository for jobs. */
    private final JobRepository jobRepository;

    /** The repository for vehicles. */
    private final VehicleRepository vehicleRepository;

    /** The repository for skills. */
    private final SkillRepository skillRepository;

    /** The repository for check-ups. */
    private final CheckUpRepository checkUpRepository;

    /**
     * Constructs a new Repositories object, initializing all repositories.
     */
    private Repositories() {
        collaboratorRepository = new CollaboratorRepository();
        jobRepository = new JobRepository();
        vehicleRepository = new VehicleRepository();
        skillRepository = new SkillRepository();
        checkUpRepository = new CheckUpRepository();
    }

    /**
     * Returns the singleton instance of Repositories, creating it if necessary.
     * @return The singleton instance of Repositories.
     */
    public static Repositories getInstance() {
        if (instance == null) {
            synchronized (Repositories.class) {
                if (instance == null) {
                    instance = new Repositories();
                }
            }
        }
        return instance;
    }

    /**
     * Gets the repository for collaborators.
     * @return The CollaboratorRepository.
     */
    public CollaboratorRepository getCollaboratorRepository() {
        return collaboratorRepository;
    }

    /**
     * Gets the repository for jobs.
     * @return The JobRepository.
     */
    public JobRepository getJobRepository() {
        return jobRepository;
    }

    /**
     * Gets the repository for vehicles.
     * @return The VehicleRepository.
     */
    public VehicleRepository getVehicleRepository() {
        return vehicleRepository;
    }

    /**
     * Gets the repository for skills.
     * @return The SkillRepository.
     */
    public SkillRepository getSkillRepository() {
        return skillRepository;
    }

    /**
     * Gets the repository for check-up.
     * @return The CheckUpRepository.
     */
    public CheckUpRepository getCheckUpRepository(){ return checkUpRepository; }
}

