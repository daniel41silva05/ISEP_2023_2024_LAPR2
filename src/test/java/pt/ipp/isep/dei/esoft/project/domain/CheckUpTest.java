package pt.ipp.isep.dei.esoft.project.domain;

import pprog.domain.CheckUp;
import pprog.domain.Vehicle;
import pprog.domain.VehicleType;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class responsible for testing the CheckUp class.
 */
class CheckUpTest {

    /**
     * Tests if a CheckUp object is successfully created.
     */
    @Test
    void ensureCheckUpIsCreatedSuccessfully() {
        // Given
        Vehicle vehicle = new Vehicle("brand", "model", 1000, 2000, 50000,
                new Date(1, 1, 2024), new Date(1, 1, 2020), 5000, "plateNumber", new VehicleType(VehicleType.TypeTransport.PASSENGERS, VehicleType.PackageWeight.HEAVY, VehicleType.Transport.TRUCKS));

        // When
        CheckUp checkUp = new CheckUp(new Date(1, 1, 2024), vehicle, 50000);
    }

    /**
     * Tests if the check-up date of a CheckUp object is not null.
     */
    @Test
    void ensureCheckUpDateIsNotNull() {
        // Arrange
        Vehicle vehicle = new Vehicle("brand", "model", 1000, 2000, 50000,
                new Date(1, 1, 2024), new Date(1, 1, 2020), 5000, "plateNumber", new VehicleType(VehicleType.TypeTransport.PASSENGERS, VehicleType.PackageWeight.HEAVY, VehicleType.Transport.TRUCKS));

        // Act and Assert
        assertThrows(IllegalArgumentException.class,
                () -> new CheckUp(null, vehicle, 50000));
    }

    /**
     * Tests if two CheckUp objects are equal when they are the same instance.
     */
    @Test
    void testEqualsSameObject() {
        // Given
        Vehicle vehicle = new Vehicle("brand", "model", 1000, 2000, 50000,
                new Date(1, 1, 2024), new Date(1, 1, 2020), 5000, "plateNumber", new VehicleType(VehicleType.TypeTransport.PASSENGERS, VehicleType.PackageWeight.HEAVY, VehicleType.Transport.TRUCKS));
        CheckUp checkUp = new CheckUp(new Date(1, 1, 2024), vehicle, 50000);

        // Then
        assertEquals(checkUp, checkUp);
    }

    /**
     * Tests if a CheckUp object is not equal to an object of a different class.
     */
    @Test
    void testEqualsDifferentClass() {
        // Given
        Vehicle vehicle = new Vehicle("brand", "model", 1000, 2000, 50000,
                new Date(1, 1, 2024), new Date(1, 1, 2020), 5000, "plateNumber", new VehicleType(VehicleType.TypeTransport.PASSENGERS, VehicleType.PackageWeight.HEAVY, VehicleType.Transport.TRUCKS));
        CheckUp checkUp = new CheckUp(new Date(1, 1, 2024), vehicle, 50000);

        // Then
        assertNotEquals(checkUp, new Object());
    }

    /**
     * Tests if a CheckUp object is not equal to null.
     */
    @Test
    void testEqualsNull() {
        // Given
        Vehicle vehicle = new Vehicle("brand", "model", 1000, 2000, 50000,
                new Date(1, 1, 2024), new Date(1, 1, 2020), 5000, "plateNumber", new VehicleType(VehicleType.TypeTransport.PASSENGERS, VehicleType.PackageWeight.HEAVY, VehicleType.Transport.TRUCKS));
        CheckUp checkUp = new CheckUp(new Date(1, 1, 2024), vehicle, 50000);

        // Then
        assertNotEquals(checkUp, null);
    }

    /**
     * Tests if two different CheckUp objects are not equal.
     */
    @Test
    void testEqualsDifferentObject() {
        // Given
        Vehicle vehicle = new Vehicle("brand", "model", 1000, 2000, 50000,
                new Date(1, 1, 2024), new Date(1, 1, 2020), 5000, "plateNumber", new VehicleType(VehicleType.TypeTransport.PASSENGERS, VehicleType.PackageWeight.HEAVY, VehicleType.Transport.TRUCKS));
        CheckUp checkUp = new CheckUp(new Date(1, 1, 2024), vehicle, 50000);
        CheckUp checkUp1 = new CheckUp(new Date(2, 1, 2024), vehicle, 60000);

        // Then
        assertNotEquals(checkUp, checkUp1);
    }

    /**
     * Tests if the hashCode method returns the same value for the same CheckUp object.
     */
    @Test
    void testHashCodeSameObject() {
        // Given
        Vehicle vehicle = new Vehicle("brand", "model", 1000, 2000, 50000,
                new Date(1, 1, 2024), new Date(1, 1, 2020), 5000, "plateNumber", new VehicleType(VehicleType.TypeTransport.PASSENGERS, VehicleType.PackageWeight.HEAVY, VehicleType.Transport.TRUCKS));
        CheckUp checkUp = new CheckUp(new Date(1, 1, 2024), vehicle, 50000);

        // Then
        assertEquals(checkUp.hashCode(), checkUp.hashCode());
    }

    /**
     * Tests if the hashCode method returns different values for different CheckUp objects.
     */
    @Test
    void testHashCodeDifferentObject() {
        // Given
        Vehicle vehicle = new Vehicle("brand", "model", 1000, 2000, 50000,
                new Date(1, 1, 2024), new Date(1, 1, 2020), 5000, "plateNumber", new VehicleType(VehicleType.TypeTransport.PASSENGERS, VehicleType.PackageWeight.HEAVY, VehicleType.Transport.TRUCKS));
        CheckUp checkUp = new CheckUp(new Date(1, 1, 2024), vehicle, 50000);
        CheckUp checkUp1 = new CheckUp(new Date(2, 1, 2024), vehicle, 60000);

        // Then
        assertNotEquals(checkUp.hashCode(), checkUp1.hashCode());
    }

    /**
     * Tests if the clone method creates an identical CheckUp object.
     */
    @Test
    void ensureCloneWorks() {
        // Given
        Vehicle vehicle = new Vehicle("brand", "model", 1000, 2000, 50000,
                new Date(1, 1, 2024), new Date(1, 1, 2020), 5000, "plateNumber", new VehicleType(VehicleType.TypeTransport.PASSENGERS, VehicleType.PackageWeight.HEAVY, VehicleType.Transport.TRUCKS));
        CheckUp checkUp = new CheckUp(new Date(1, 1, 2024), vehicle, 50000);

        // When
        CheckUp clone = checkUp.clone();

        // Then
        assertEquals(checkUp, clone);
    }
}
