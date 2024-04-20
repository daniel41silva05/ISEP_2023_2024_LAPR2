package pprog.repository;

import pprog.domain.Collaborator;
import java.util.ArrayList;
import java.util.List;

public class CollaboratorRepository {

    private List<Collaborator> collaborators;

    public CollaboratorRepository() {
        this.collaborators = new ArrayList<>();
    }

    public void save(Collaborator collaborator) {
        collaborators.add(collaborator);
    }

    public List<Collaborator> getAllCollaborators() {
        return collaborators;
    }

}
