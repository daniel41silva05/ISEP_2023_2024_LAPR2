package pprog.domain;

import org.junit.jupiter.api.Test;
import pprog.domain.collaborator.Collaborator;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CollaboratorTest {


    @Test
    void validateBirthdayIsOver18() {

        Collaborator collaborator = new Collaborator("Daniel Silva", new Date(90, 5, 31),
                new Date(), "123 Street", 123456789, "daniel.silva@example.com", 3, 123456, new Job("Software Engineer", "Developing software applications"));

        assertTrue(collaborator.validateBirthdayIsOver18());

        Collaborator underageCollaborator = new Collaborator("Daniel Silva", new Date(120, 5, 31),
                new Date(), "456 Avenue", 987654321, "daniel.silva@example.com", 3, 654321, new Job("Software Engineer", "Developing software applications"));

        assertFalse(underageCollaborator.validateBirthdayIsOver18());
    }

    @Test
    void testEquals() {

        Collaborator collaborator1 = new Collaborator("Daniel Silva", new Date(), new Date(), "123 Street", 123456789,
                "daniel.silva@example.com", 3, 123456, new Job("Software Engineer", "Developing software applications"));
        Collaborator collaborator2 = new Collaborator("Daniel Silva", new Date(), new Date(), "123 Street", 123456789,
                "daniel.silva@example.com", 3, 123456, new Job("Software Engineer", "Developing software applications"));

        assertEquals(collaborator1, collaborator2);

        collaborator2.setName("João Silva");

        assertNotEquals(collaborator1, collaborator2);
    }

    @Test
    void testClone() {

        Collaborator originalCollaborator = new Collaborator("Daniel Silva", new Date(), new Date(), "123 Street", 123456789,
                "daniel.silva@example.com", 2, 123456, new Job("Software Engineer", "Developing software applications"));

        Collaborator clonedCollaborator = originalCollaborator.clone();

        assertEquals(originalCollaborator, clonedCollaborator);

        originalCollaborator.setName("João Silva");

        assertNotEquals(originalCollaborator.getName(), clonedCollaborator.getName());
    }

}