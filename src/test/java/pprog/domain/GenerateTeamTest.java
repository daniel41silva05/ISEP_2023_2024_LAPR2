package pprog.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GenerateTeamTest {

    @Test
    void seeCollaboratorsWithSkillsNeeded() {
        // Criar algumas habilidades
        Skill skill1 = new Skill("Java");
        Skill skill2 = new Skill("Python");
        Skill skill3 = new Skill("SQL");

        // Criar alguns colaboradores com conjuntos de habilidades diferentes
        Collaborator collaborator1 = new Collaborator("John", null, null, null, 0, null, null, 0, null);
        collaborator1.getSkillAssign().add(skill1);
        collaborator1.getSkillAssign().add(skill2);

        Collaborator collaborator2 = new Collaborator("Alice", null, null, null, 0, null, null, 0, null);
        collaborator2.getSkillAssign().add(skill2);
        collaborator2.getSkillAssign().add(skill3);

        Collaborator collaborator3 = new Collaborator("Bob", null, null, null, 0, null, null, 0, null);
        collaborator3.getSkillAssign().add(skill1);
        collaborator3.getSkillAssign().add(skill3);

        // Lista de colaboradores disponíveis
        List<Collaborator> collaboratorList = new ArrayList<>();
        collaboratorList.add(collaborator1);
        collaboratorList.add(collaborator2);
        collaboratorList.add(collaborator3);

        // Criar uma instância de GenerateTeam
        GenerateTeam generateTeam = new GenerateTeam(1, 3, List.of(skill1, skill3));

        // Chamar o método para encontrar colaboradores com as habilidades necessárias
        List<Collaborator> collaboratorsWithSkills = generateTeam.seeColaboratorsWithSkillsNeeded(collaboratorList, List.of(skill1, skill3));

        // Verificar o resultado
        assertEquals(2, collaboratorsWithSkills.size());
        assertTrue(collaboratorsWithSkills.contains(collaborator1));
        assertTrue(collaboratorsWithSkills.contains(collaborator3));
    }

    @Test
    void generateRandomTeam() {
        // Criar alguns colaboradores
        Collaborator collaborator1 = new Collaborator("John", null, null, null, 0, null, null, 0, null);
        Collaborator collaborator2 = new Collaborator("Alice", null, null, null, 0, null, null, 0, null);
        Collaborator collaborator3 = new Collaborator("Bob", null, null, null, 0, null, null, 0, null);

        // Lista de colaboradores disponíveis
        List<Collaborator> collaboratorList = List.of(collaborator1, collaborator2, collaborator3);

        // Criar uma instância de GenerateTeam
        GenerateTeam generateTeam = new GenerateTeam(1, 3, new ArrayList<>());

        // Chamar o método para gerar uma equipe aleatória
        List<Collaborator> randomTeam = generateTeam.generateRandomTeam(collaboratorList, 3, 1);

        // Verificar o resultado
        assertTrue(randomTeam.size() >= 1 && randomTeam.size() <= 3);
        assertTrue(collaboratorList.containsAll(randomTeam));
    }

    @Test
    void testClone() {
        // Criar uma instância de GenerateTeam
        GenerateTeam generateTeam = new GenerateTeam(1, 3, List.of(new Skill("Java"), new Skill("Python")));

        // Clonar a instância
        GenerateTeam clonedGenerateTeam = generateTeam.clone();

        // Verificar se os valores foram copiados corretamente
        assertEquals(generateTeam.getMinSize(), clonedGenerateTeam.getMinSize());
        assertEquals(generateTeam.getMaxSize(), clonedGenerateTeam.getMaxSize());
        assertEquals(generateTeam.getSkillAssign(), clonedGenerateTeam.getSkillAssign());
    }
}
