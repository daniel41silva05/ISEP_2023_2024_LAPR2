package pprog.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GenerateTeamTest {

//    @Test
//    void seeCollaboratorsWithSkillsNeeded() {
//        // Create some skills
//        Skill skill1 = new Skill("Java");
//        Skill skill2 = new Skill("Python");
//        Skill skill3 = new Skill("SQL");
//
//        // Create some collaborators with different sets of skills
//        Collaborator collaborator1 = new Collaborator("John", null, null, null, 0, null, null, 0, null);
//        collaborator1.getSkillAssign().add(skill1);
//        collaborator1.getSkillAssign().add(skill2);
//
//        Collaborator collaborator2 = new Collaborator("Alice", null, null, null, 0, null, null, 0, null);
//        collaborator2.getSkillAssign().add(skill2);
//        collaborator2.getSkillAssign().add(skill3);
//
//        Collaborator collaborator3 = new Collaborator("Bob", null, null, null, 0, null, null, 0, null);
//        collaborator3.getSkillAssign().add(skill1);
//        collaborator3.getSkillAssign().add(skill3);
//
//        // List of available collaborators
//        List<Collaborator> collaboratorList = new ArrayList<>();
//        collaboratorList.add(collaborator1);
//        collaboratorList.add(collaborator2);
//        collaboratorList.add(collaborator3);
//
//        // Create an instance of GenerateTeam
//        GenerateTeam generateTeam = new GenerateTeam(1, 3, List.of(skill1, skill3));
//
//        // Call the method to find collaborators with the necessary skills
//        List<Collaborator> collaboratorsWithSkills = generateTeam.seeColaboratorsWithSkillsNeeded(collaboratorList, List.of(skill1, skill3));
//
//        // Verify the result
//        assertEquals(2, collaboratorsWithSkills.size());
//        assertTrue(collaboratorsWithSkills.contains(collaborator1));
//        assertTrue(collaboratorsWithSkills.contains(collaborator3));
//    }
//
//    @Test
//    void generateRandomTeam() {
//        // Create some collaborators
//        Collaborator collaborator1 = new Collaborator("John", null, null, null, 0, null, null, 0, null);
//        Collaborator collaborator2 = new Collaborator("Alice", null, null, null, 0, null, null, 0, null);
//        Collaborator collaborator3 = new Collaborator("Bob", null, null, null, 0, null, null, 0, null);
//
//        // List of available collaborators
//        List<Collaborator> collaboratorList = List.of(collaborator1, collaborator2, collaborator3);
//
//        // Create an instance of GenerateTeam
//        GenerateTeam generateTeam = new GenerateTeam(1, 3, new ArrayList<>());
//
//        // Call the method to generate a random team
//        List<Collaborator> randomTeam = generateTeam.generateRandomTeam(collaboratorList, 3, 1);
//
//        // Verify the result
//        assertTrue(randomTeam.size() >= 1 && randomTeam.size() <= 3);
//        assertTrue(collaboratorList.containsAll(randomTeam));
//    }
//
//    @Test
//    void testClone() {
//        // Create an instance of GenerateTeam
//        GenerateTeam generateTeam = new GenerateTeam(1, 3, List.of(new Skill("Java"), new Skill("Python")));
//
//        // Clone the instance
//        GenerateTeam clonedGenerateTeam = generateTeam.clone();
//
//        // Verify if the values were copied correctly
//        assertEquals(generateTeam.getMinSize(), clonedGenerateTeam.getMinSize());
//        assertEquals(generateTeam.getMaxSize(), clonedGenerateTeam.getMaxSize());
//        assertEquals(generateTeam.getSkillAssign(), clonedGenerateTeam.getSkillAssign());
//    }
}
