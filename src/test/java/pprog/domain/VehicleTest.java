package pprog.domain;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void testEquals() {

        VehicleType vehicleType = new VehicleType(VehicleType.TypeTransport.PASSENGERS, VehicleType.PackageWeight.LIGHT, VehicleType.Transport.OPEN_BOX);

        Vehicle vehicle1 = new Vehicle("Toyota", "Corolla", 1200, 1500, 10000,
                new Date(), new Date(), 5000, "ABC1234", vehicleType);
        Vehicle vehicle2 = new Vehicle("Honda", "Civic", 1100, 1400, 9000,
                new Date(), new Date(), 5000, "ABC1234", vehicleType);

        assertEquals(vehicle1, vehicle2);

        vehicle2.setPlateNumber("DEF5678");

        assertNotEquals(vehicle1, vehicle2);
    }

    @Test
    void testClone() {

        VehicleType vehicleType = new VehicleType(VehicleType.TypeTransport.PASSENGERS, VehicleType.PackageWeight.LIGHT, VehicleType.Transport.OPEN_BOX);

        Vehicle originalVehicle = new Vehicle("Ford", "Fiesta", 1000, 1300, 8000,
                new Date(), new Date(), 5000, "XYZ9876", vehicleType);

        Vehicle clonedVehicle = originalVehicle.clone();

        assertEquals(originalVehicle, clonedVehicle);

        originalVehicle.setModel("Focus");

        assertNotEquals(originalVehicle.getModel(), clonedVehicle.getModel());
    }
}
