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

    /** The repository for teams. */
    private final TeamRepository teamRepository;

    /** The repository for vehicles needing maintenance. */
    private final VehicleNeedingMaintenanceRepository vehicleNeedingMaintenanceRepository;

    /** The repository for authentication. */
    private final AuthenticationRepository authenticationRepository;

    private final Agenda agenda;
    private final ToDoList toDoList;

    /**
     * Constructs a new Repositories object, initializing all repositories.
     */
    private Repositories() {
        collaboratorRepository = new CollaboratorRepository();
        jobRepository = new JobRepository();
        vehicleRepository = new VehicleRepository();
        skillRepository = new SkillRepository();
        checkUpRepository = new CheckUpRepository();
        teamRepository = new TeamRepository();
        vehicleNeedingMaintenanceRepository = new VehicleNeedingMaintenanceRepository();
        authenticationRepository = new AuthenticationRepository();
        agenda = new Agenda();
        toDoList = new ToDoList();
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
     * Gets the repository for check-ups.
     * @return The CheckUpRepository.
     */
    public CheckUpRepository getCheckUpRepository(){ return checkUpRepository; }

    /**
     * Gets the repository for teams.
     * @return The GenerateTeamRepository.
     */
    public TeamRepository getTeamRepository() { return teamRepository; }

    /**
     * Gets the repository for vehicles needing maintenance.
     * @return The VehicleNeedingMaintenanceRepository.
     */
    public VehicleNeedingMaintenanceRepository getVehicleNeedingMaintenanceRepository() {
        return vehicleNeedingMaintenanceRepository;
    }

    /**
     * Gets the repository for authentication.
     * @return The AuthenticationRepository.
     */
    public AuthenticationRepository getAuthenticationRepository() {
        return authenticationRepository;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public ToDoList getToDoList() {
        return toDoList;
    }
}

