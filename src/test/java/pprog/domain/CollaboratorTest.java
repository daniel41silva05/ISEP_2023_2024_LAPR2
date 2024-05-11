package pprog.domain;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CollaboratorTest {


    @Test
    void validateBirthdayIsOver18() {
        // Criar um objeto de colaborador com 19 anos de idade
        Collaborator collaborator = new Collaborator("John Doe", new Date(System.currentTimeMillis() - 19L * 365 * 24 * 60 * 60 * 1000),
                new Date(), "123 Street", 123456789, "john.doe@example.com", IdDocType.ID, 123456, Job.DEVELOPER);

        // Verificar se o método retorna true para um colaborador com mais de 18 anos
        assertTrue(collaborator.validateBirthdayIsOver18());

        // Criar um objeto de colaborador com 17 anos de idade
        Collaborator underageCollaborator = new Collaborator("Jane Doe", new Date(System.currentTimeMillis() - 17L * 365 * 24 * 60 * 60 * 1000),
                new Date(), "456 Avenue", 987654321, "jane.doe@example.com", IdDocType.PASSPORT, 654321, Job.TESTER);

        // Verificar se o método retorna false para um colaborador com menos de 18 anos
        assertFalse(underageCollaborator.validateBirthdayIsOver18());
    }

    @Test
    void testEquals() {
        // Criar dois colaboradores iguais
        Collaborator collaborator1 = new Collaborator("John Doe", new Date(), new Date(), "123 Street", 123456789,
                "john.doe@example.com", IdDocType.PASSPORT, 123456, Job.DEVELOPER);
        Collaborator collaborator2 = new Collaborator("John Doe", new Date(), new Date(), "123 Street", 123456789,
                "john.doe@example.com", IdDocType.PASSPORT, 123456, Job.DEVELOPER);

        // Verificar se os objetos são iguais
        assertEquals(collaborator1, collaborator2);

        // Alterar o nome de um dos colaboradores
        collaborator2.setName("Jane Doe");

        // Verificar se os objetos não são mais iguais
        assertNotEquals(collaborator1, collaborator2);
    }

    @Test
    void testClone() {
        // Criar um colaborador
        Collaborator originalCollaborator = new Collaborator("John Doe", new Date(), new Date(), "123 Street", 123456789,
                "john.doe@example.com", IdDocType.CITIZEN_CARD, 123456, Job.DEVELOPER);

        // Fazer uma cópia do colaborador
        Collaborator clonedCollaborator = originalCollaborator.clone();

        // Verificar se os objetos têm os mesmos atributos
        assertEquals(originalCollaborator, clonedCollaborator);

        // Alterar um atributo no colaborador original
        originalCollaborator.setName("Jane Doe");

        // Verificar se a alteração não afetou a cópia
        assertNotEquals(originalCollaborator.getName(), clonedCollaborator.getName());
    }

}