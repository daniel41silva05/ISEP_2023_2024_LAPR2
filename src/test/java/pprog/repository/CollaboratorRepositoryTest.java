package pprog.repository;

import org.junit.jupiter.api.Test;
import pprog.domain.Collaborator;
import pprog.domain.IdDocType;
import pprog.domain.Job;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollaboratorRepositoryTest {

    @Test
    void registerCollaborator() {

        CollaboratorRepository repository = new CollaboratorRepository();

        Collaborator collaborator = new Collaborator("Daniel Silva", new Date(90,5,31),
                new Date(), "123 Street", 123456789, "daniel.silva@example.com", 3, 123456, new Job("Software Engineer", "Developing software applications"));

        Collaborator registeredCollaborator = repository.registerCollaborator(collaborator.getName(), collaborator.getBirthday(),
                collaborator.getAdmissionDate(), collaborator.getAddress(), collaborator.getPhoneNumber(),
                collaborator.getEmail(), IdDocType.PASSPORT.ordinal(), collaborator.getIdNumber(), collaborator.getJob());

        assertNotNull(registeredCollaborator);
        assertEquals(collaborator, registeredCollaborator);

        List<Collaborator> collaboratorsList = repository.getCollaboratorsList();

        assertTrue(collaboratorsList.contains(registeredCollaborator));

        assertThrows(IllegalArgumentException.class, () ->
                repository.registerCollaborator(collaborator.getName(), collaborator.getBirthday(),
                        collaborator.getAdmissionDate(), collaborator.getAddress(), collaborator.getPhoneNumber(),
                        collaborator.getEmail(), IdDocType.PASSPORT.ordinal(), collaborator.getIdNumber(), collaborator.getJob()));
    }


    @Test
    void getCollaboratorByName() {

        CollaboratorRepository repository = new CollaboratorRepository();

        Collaborator collaborator = new Collaborator("Daniel Silva", new Date(90,5,31),
                new Date(), "123 Street", 123456789, "daniel.silva@example.com", 3, 123456, new Job("Software Engineer", "Developing software applications"));
        repository.registerCollaborator(collaborator.getName(), collaborator.getBirthday(),
                collaborator.getAdmissionDate(), collaborator.getAddress(), collaborator.getPhoneNumber(),
                collaborator.getEmail(), IdDocType.PASSPORT.ordinal(), collaborator.getIdNumber(), collaborator.getJob());

        Collaborator retrievedCollaborator = repository.getCollaboratorByName("Daniel Silva");

        assertNotNull(retrievedCollaborator);
        assertEquals(collaborator, retrievedCollaborator);


        Collaborator nonExistentCollaborator = repository.getCollaboratorByName("Non Existent");
        assertNull(nonExistentCollaborator);
    }
}
