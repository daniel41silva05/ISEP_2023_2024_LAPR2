package pprog.domain;

import java.util.Objects;

/**
 * Represents a job with a name and description.
 */
public class Job {

    /** The name of the job. */
    private String name;

    /** The description of the job. */
    private String description;

    /**
     * Constructs a job with the given name and description.
     * @param name The name of the job.
     * @param description The description of the job.
     */
    public Job(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Gets the name of the job.
     * @return The name of the job.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the description of the job.
     * @return The description of the job.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the name of the job.
     * @param name The new name of the job.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the description of the job.
     * @param description The new description of the job.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Creates a copy of this job.
     * @return A new Job object with the same name and description.
     */
    public Job clone() {
        return new Job(this.name, this.description);
    }

    /**
     * Returns a string representation of this job.
     * @return The name of the job.
     */
    @Override
    public String toString() {
        return String.format("Job\nName: %s\nDescription: %s\n", name, description);
    }

}
