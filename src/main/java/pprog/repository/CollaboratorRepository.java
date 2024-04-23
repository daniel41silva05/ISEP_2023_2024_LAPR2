package pprog.repository;

import pprog.domain.Collaborator;
import java.util.ArrayList;
import java.util.List;

public class CollaboratorRepository {

    private List<Collaborator> collaboratorsList;

    public CollaboratorRepository() {
        this.collaboratorsList = new ArrayList<>();
    }

    private void addCollaborator (Collaborator collaborator) {
        this.collaboratorsList.add(collaborator);
    }
    private boolean validateCollaborator (Collaborator collaborator) {
        // falta me implementar as validações
        return true;
    }

    public void registerCollaborator(Collaborator collaborator) {
        if (validateCollaborator(collaborator)) {
            addCollaborator(collaborator);
        }
    }

    public List<Collaborator> getCollaboratorsList() {
        return collaboratorsList;
    }
}
