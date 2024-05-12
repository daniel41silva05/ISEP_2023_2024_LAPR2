package pprog.repository;

import org.junit.jupiter.api.Test;
import pprog.domain.CheckUp;
import pprog.domain.Vehicle;
import pprog.domain.VehicleType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehicleNeedingMaintenanceRepositoryTest {

    @Test
    void getVehiclesNeedingMaintenanceList() {
        // Arrange
        List<Vehicle> allVehicles = new ArrayList<>();
        List<CheckUp> allCheckUps = new ArrayList<>();

        // Create vehicles
        VehicleType vehicleType = new VehicleType(VehicleType.TypeTransport.PASSENGERS, VehicleType.PackageWeight.LIGHT, VehicleType.Transport.OPEN_BOX);

        Vehicle vehicle1 = new Vehicle("Toyota", "Corolla", 1500, 2000, 52000, new Date(), new Date(), 5000, "123ABC", vehicleType);
        Vehicle vehicle2 = new Vehicle("Honda", "Civic", 1600, 2100, 64000, new Date(), new Date(), 6000, "456DEF", vehicleType);
        Vehicle vehicle3 = new Vehicle("Ford", "Focus", 1700, 2200, 72000, new Date(), new Date(), 7000, "789GHI", vehicleType);

        // Create check-ups
        CheckUp checkUp1 = new CheckUp(null, vehicle1, 52000);
        CheckUp checkUp2 = new CheckUp(null, vehicle2, 64000);
        CheckUp checkUp3 = new CheckUp(null, vehicle3, 72000);

        // Add vehicles and check-ups to lists
        allVehicles.add(vehicle1);
        allVehicles.add(vehicle2);
        allVehicles.add(vehicle3);

        allCheckUps.add(checkUp1);
        allCheckUps.add(checkUp2);
        allCheckUps.add(checkUp3);

        // Create repository
        VehicleNeedingMaintenanceRepository repository = new VehicleNeedingMaintenanceRepository();

        // Act
        List<String> vehiclesNeedingMaintenanceList = repository.getVehiclesNeedingMaintenanceList(allVehicles, allCheckUps);

        // Assert
        assertNotNull(vehiclesNeedingMaintenanceList);
        assertFalse(vehiclesNeedingMaintenanceList.isEmpty());
        assertEquals(4, vehiclesNeedingMaintenanceList.size()); // Including the header line
    }
}
