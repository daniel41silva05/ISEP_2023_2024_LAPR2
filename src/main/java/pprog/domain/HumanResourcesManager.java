package pprog.domain;

import pprog.repository.CollaboratorRepository;
import pprog.repository.JobRepository;
import pprog.repository.Repositories;

/**
 * Represents a human resources manager.
 */
public class HumanResourcesManager {

    /** The name of the human resources manager. */
    private String name;

    /**
     * Constructs a human resources manager with the given name.
     * @param name The name of the human resources manager.
     */
    public HumanResourcesManager(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the human resources manager.
     * @return The name of the human resources manager.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the human resources manager.
     * @param name The new name of the human resources manager.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns a string representation of the human resources manager.
     * @return A string representation containing the name of the human resources manager.
     */
    @Override
    public String toString() {
        return String.format("Human Resources Manager: %s\n", name);
    }
}
