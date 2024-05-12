package pprog.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkillTest {

    @Test
    void validateSkill() {
        // Caso de teste: habilidade válida
        Skill skill1 = new Skill("Java Programming");
        assertTrue(skill1.validateSkill());

        // Caso de teste: habilidade inválida (contém dígitos)
        Skill skill2 = new Skill("Python 3");
        assertFalse(skill2.validateSkill());

        // Caso de teste: habilidade inválida (caracteres especiais)
        Skill skill3 = new Skill("C++");
        assertFalse(skill3.validateSkill());

        // Caso de teste: habilidade inválida (vazia)
        Skill skill4 = new Skill("");
        assertFalse(skill4.validateSkill());
    }

    @Test
    void testEquals() {
        // Caso de teste: habilidades iguais
        Skill skill1 = new Skill("Java");
        Skill skill2 = new Skill("Java");
        assertEquals(skill1, skill2);

        // Caso de teste: habilidades diferentes
        Skill skill3 = new Skill("Python");
        assertNotEquals(skill1, skill3);
    }

    @Test
    void testClone() {
        // Criar uma instância de Skill
        Skill originalSkill = new Skill("Java");

        // Clonar a instância
        Skill clonedSkill = originalSkill.clone();

        // Verificar se os valores foram copiados corretamente
        assertEquals(originalSkill.getSkill(), clonedSkill.getSkill());
        assertNotSame(originalSkill, clonedSkill);
    }
}
