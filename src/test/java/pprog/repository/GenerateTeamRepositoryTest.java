package pprog.repository;

import org.junit.jupiter.api.Test;
import pprog.domain.Collaborator;
import pprog.domain.GenerateTeam;
import pprog.domain.IdDocType;
import pprog.domain.Skill;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenerateTeamRepositoryTest {

    @Test
    void team() {
        // Create skills
        Skill programmingSkill = new Skill("Programming");
        Skill designSkill = new Skill("Design");

        // Create collaborators with skills
        Collaborator john = new Collaborator("John", new Date(), new Date(), "Address 1", 123456789, "john@example.com", IdDocType.TAXPAYER_NUMBER, 123456789, null);
        john.getSkillAssign().add(programmingSkill);

        Collaborator alice = new Collaborator("Alice", new Date(), new Date(), "Address 2", 987654321, "alice@example.com", IdDocType.CITIZEN_CARD, 987654321, null);
        alice.getSkillAssign().add(designSkill);

        Collaborator bob = new Collaborator("Bob", new Date(), new Date(), "Address 3", 555555555, "bob@example.com", IdDocType.PASSPORT, 555555555, null);
        bob.getSkillAssign().add(programmingSkill);
        bob.getSkillAssign().add(designSkill);

        // Add collaborators to the list
        List<Collaborator> collaborators = new ArrayList<>();
        collaborators.add(john);
        collaborators.add(alice);
        collaborators.add(bob);

        // Create GenerateTeamRepository instance
        GenerateTeamRepository repository = new GenerateTeamRepository();

        // Generate a team
        List<Collaborator> generatedTeam = repository.team(1, 3, (List<Skill>) programmingSkill, collaborators);

        // Assert that the generated team is not null and has at least one member
        assertNotNull(generatedTeam);
        assertFalse(generatedTeam.isEmpty());
    }

    @Test
    void addTeams() {
        // Create GenerateTeamRepository instance
        GenerateTeamRepository repository = new GenerateTeamRepository();

        // Create a list of teams
        List<GenerateTeam> teams = new ArrayList<>();
        teams.add(new GenerateTeam(1, 3, new ArrayList<>()));
        teams.add(new GenerateTeam(2, 4, new ArrayList<>()));
        teams.add(new GenerateTeam(1, 2, new ArrayList<>()));

        // Add teams to the repository
        int addedTeamsCount = repository.addTeams(teams);

        // Assert that the number of added teams matches the size of the input list
        assertEquals(teams.size(), addedTeamsCount);
    }
}
