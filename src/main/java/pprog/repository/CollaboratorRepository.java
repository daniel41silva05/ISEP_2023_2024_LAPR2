package pprog.repository;

import pprog.domain.Collaborator;
import pprog.domain.IdDocType;
import pprog.domain.Job;
import pt.ipp.isep.dei.esoft.project.domain.Organization;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CollaboratorRepository {

    private final List<Collaborator> collaboratorsList;

    public CollaboratorRepository() {
        collaboratorsList = new ArrayList<>();
    }

    public Optional<Collaborator> registerCollaborator (String name, String birthday, String admissionDate, String address, int phoneNumber, String email, IdDocType idDocType, int idNumber, Job job) {
        Optional<Collaborator> newCollaborator = Optional.empty();
        Collaborator collaborator = new Collaborator(name, birthday, admissionDate, address, phoneNumber, email, idDocType, idNumber, job);

        if (addCollaborator(collaborator)) {
            newCollaborator = Optional.of(collaborator);
        }
        return newCollaborator;
    }

    public Optional<Collaborator> getCollaboratorByName (String collaboratorName) {

        Optional<Collaborator> returnCollaborator = Optional.empty();

        for (Collaborator collaborator : collaboratorsList) {
            if (collaborator.getName().equals(collaboratorName)) {
                returnCollaborator = Optional.of(collaborator);
            }
        }
        return returnCollaborator;
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
