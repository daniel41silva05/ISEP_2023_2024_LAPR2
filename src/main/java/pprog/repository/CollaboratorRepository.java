package pprog.repository;

import pprog.domain.Collaborator;
import pprog.domain.Job;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CollaboratorRepository {

    private final List<Collaborator> collaboratorsList;

    public CollaboratorRepository() {
        collaboratorsList = new ArrayList<>();
    }

    public Optional<Collaborator> registerCollaborator (String name, String birthday, String admissionDate, String address, int phoneNumber, String email, Collaborator.IdDocType idDocType, int idNumber, Job job) {
        Optional<Collaborator> newCollaborator = Optional.empty();
        Collaborator collaborator = new Collaborator(name, birthday, admissionDate, address, phoneNumber, email, idDocType, idNumber, job );

        if (addCollaborator(collaborator)) {
            newCollaborator = Optional.of(collaborator);
        }
        return newCollaborator;
    }

    private boolean addCollaborator (Collaborator collaborator) {
        boolean success = false;
        if (validateCollaborator(collaborator)) {
            success = collaboratorsList.add(collaborator.clone());
        }
        return success;
    }

    private boolean validateCollaborator (Collaborator collaborator) {
        boolean isValid = !collaboratorsList.contains(collaborator);
        return isValid;
    }

    public List<Collaborator> getCollaboratorsList() {
        return collaboratorsList;
    }

    @Override
    public String toString() {
        return "Collaborators=" + collaboratorsList + '}';
    }

}
