package pprog.domain;

/**
 * Represents a fleet manager.
 */
public class FleetManager {

    /** The name of the fleet manager. */
    private String name;

    /**
     * Constructs a fleet manager with the given name.
     * @param name The name of the fleet manager.
     */
    public FleetManager(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the fleet manager.
     * @return The name of the fleet manager.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the fleet manager.
     * @param name The new name of the fleet manager.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns a string representation of the fleet manager.
     * @return A string representation containing the name of the fleet manager.
     */
    @Override
    public String toString() {
        return String.format("Fleet Manager: %s\n", name);
    }
}
