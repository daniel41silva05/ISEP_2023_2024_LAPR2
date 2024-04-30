package pt.ipp.isep.dei.esoft.project.domain;

import pprog.domain.Job;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JobTest {

    @Test
    void ensureJobIsCreatedSuccessfully() {
        Job job = new Job("name", "description");
    }

    @Test
    void ensureJobNameIsNotNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Job(null, "description"));
    }

    @Test
    void testEqualsSameObject() {
        Job job = new Job("name", "description");
        assertEquals(job, job);
    }

    @Test
    void testEqualsDifferentClass() {
        Job job = new Job("name", "description");
        assertNotEquals(job, new Object());
    }

    @Test
    void testEqualsNull() {
        Job job = new Job("name", "description");
        assertNotEquals(job, null);
    }

    @Test
    void testEqualsDifferentObject() {
        Job job = new Job("name", "description");
        Job job1 = new Job("name1", "description1");
        assertNotEquals(job, job1);
    }

    @Test
    void testEqualsSameObjectDifferentDescription() {
        Job job = new Job("name", "description");
        Job job1 = new Job("name", "description1");
        assertNotEquals(job, job1);
    }

    @Test
    void testEqualsSameObjectSameDescription() {
        Job job = new Job("name", "description");
        Job job1 = new Job("name", "description");
        assertEquals(job, job1);
    }

    @Test
    void testHashCodeSameObject() {
        Job job = new Job("name", "description");
        assertEquals(job.hashCode(), job.hashCode());
    }

    @Test
    void testHashCodeDifferentObject() {
        Job job = new Job("name", "description");
        Job job1 = new Job("name1", "description1");
        assertNotEquals(job.hashCode(), job1.hashCode());
    }

    @Test
    void ensureCloneWorks() {
        Job job = new Job("name", "description");
        Job clone = job.clone();
        assertEquals(job, clone);
    }
}
