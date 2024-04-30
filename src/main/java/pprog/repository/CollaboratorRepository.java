package pprog.repository;

import pprog.domain.Collaborator;
import pprog.domain.Date;
import pprog.domain.IdDocType;
import pprog.domain.Job;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Repository class to manage collaborators.
 */
public class CollaboratorRepository {

    /**
     * The list of collaborators managed by the repository.
     */
    private final List<Collaborator> collaboratorsList;

    /**
     * Constructs a new CollaboratorRepository object.
     */
    public CollaboratorRepository() {
        collaboratorsList = new ArrayList<>();
    }

    /**
     * Registers a new collaborator.
     *
     * @param name          The name of the collaborator.
     * @param birthday      The birthday of the collaborator.
     * @param admissionDate The admission date of the collaborator.
     * @param address       The address of the collaborator.
     * @param phoneNumber   The phone number of the collaborator.
     * @param email         The email of the collaborator.
     * @param idDocType     The identification document type of the collaborator.
     * @param idNumber      The identification number of the collaborator.
     * @param job           The job of the collaborator.
     * @return The newly registered collaborator, or null if registration fails.
     */
    public Collaborator registerCollaborator(String name, Date birthday, Date admissionDate, String address, int phoneNumber, String email, IdDocType idDocType, int idNumber, Job job) {
        Collaborator newCollaborator = null;
        Collaborator collaborator = new Collaborator(name, birthday, admissionDate, address, phoneNumber, email, idDocType, idNumber, job);

        if (addCollaborator(collaborator)) {
            newCollaborator = collaborator;
        }
        return newCollaborator;
    }

    /**
     * Retrieves a collaborator by name.
     *
     * @param collaboratorName The name of the collaborator to retrieve.
     * @return The collaborator with the specified name, or null if not found.
     */
    public Collaborator getCollaboratorByName(String collaboratorName) {
        for (Collaborator collaborator : collaboratorsList) {
            if (collaborator.getName().equals(collaboratorName)) {
                return collaborator;
            }
        }
        return null;
    }

    /**
     * Adds a collaborator to the repository.
     *
     * @param collaborator The collaborator to add.
     * @return true if the collaborator was added successfully, false otherwise.
     */
    private boolean addCollaborator(Collaborator collaborator) {
        boolean success = false;
        if (validateCollaborator(collaborator)) {
            success = collaboratorsList.add(collaborator.clone());
        }
        return success;
    }

    /**
     * Validates whether a collaborator is unique.
     *
     * @param collaborator The collaborator to validate.
     * @return true if the collaborator is unique, false otherwise.
     */
    private boolean validateCollaborator(Collaborator collaborator) {
        return !collaboratorsList.contains(collaborator);
    }

    /**
     * Gets the list of all collaborators.
     *
     * @return The list of collaborators.
     */
    public List<Collaborator> getCollaboratorsList() {
        return collaboratorsList;
    }

    /**
     * Returns a string representation of the CollaboratorRepository.
     *
     * @return A string representation of the CollaboratorRepository.
     */
    @Override
    public String toString() {
        return "Collaborators=" + collaboratorsList + '}';
    }

}
