package pprog.domain;

import java.io.Serializable;

/**
 * Represents the status of a task.
 */
public enum TaskStatus implements Serializable {
    PENDING,
    PROCESSED;

    /**
     * Converts an integer value to the corresponding TaskStatus enum.
     *
     * @param value the integer value to convert
     * @return the TaskStatus enum corresponding to the value
     */
    public static TaskStatus fromInt(int value) {
        switch (value) {
            case 1:
                return PENDING;
            case 2:
                return PROCESSED;
        }
        return null;
    }

    /**
     * Returns a string representation of the task status.
     *
     * @return a string representation of the task status
     */
    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
    }
}
