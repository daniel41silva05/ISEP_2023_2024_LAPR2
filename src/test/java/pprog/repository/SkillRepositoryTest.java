package pprog.repository;

import org.junit.jupiter.api.Test;
import pprog.domain.Skill;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SkillRepositoryTest {

    @Test
    void getSkillByName() {
        // Arrange
        Skill javaSkill = new Skill("Java");
        Skill pythonSkill = new Skill("Python");
        List<Skill> skills = new ArrayList<>();
        skills.add(javaSkill);
        skills.add(pythonSkill);
        SkillRepository repository = new SkillRepository(skills);

        // Act
        Skill foundJavaSkill = repository.getSkillByName("Java");
        Skill foundPythonSkill = repository.getSkillByName("Python");
        Skill notFoundSkill = repository.getSkillByName("C++");

        // Assert
        assertNotNull(foundJavaSkill);
        assertNotNull(foundPythonSkill);
        assertNull(notFoundSkill);
    }

    @Test
    void addSkill() {
        // Arrange
        Skill javaSkill = new Skill("Java");
        SkillRepository repository = new SkillRepository();

        // Act
        boolean addedFirstSkill = repository.addSkill(javaSkill);
        boolean addedDuplicateSkill = repository.addSkill(javaSkill);

        // Assert
        assertTrue(addedFirstSkill);
        assertFalse(addedDuplicateSkill);
    }

    @Test
    void isSkillInList() {
        // Arrange
        Skill javaSkill = new Skill("Java");
        SkillRepository repository = new SkillRepository();
        repository.addSkill(javaSkill);

        // Act
        boolean isInList = repository.isSkillInList(javaSkill);
        Skill nonExistingSkill = new Skill("Python");
        boolean isNotInList = repository.isSkillInList(nonExistingSkill);

        // Assert
        assertTrue(isInList);
        assertFalse(isNotInList);
    }

    @Test
    void registerSkill() {
        // Arrange
        String name = "Java";
        SkillRepository repository = new SkillRepository();

        // Act
        boolean firstRegistration = repository.registerSkill(name);
        boolean duplicateRegistration = repository.registerSkill(name);

        // Assert
        assertTrue(firstRegistration);
        assertThrows(IllegalArgumentException.class, () -> repository.registerSkill(name));
    }
}
