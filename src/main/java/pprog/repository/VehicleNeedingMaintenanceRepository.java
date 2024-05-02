package pprog.repository;

import pprog.domain.CheckUp;
import pprog.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleNeedingMaintenanceRepository {
    private final List<String> vehiclesNeedingMaintenanceList;

    public VehicleNeedingMaintenanceRepository() {
        vehiclesNeedingMaintenanceList = new ArrayList<>();
    }

    public List<String> getVehiclesNeedingMaintenanceList (List<Vehicle> allVehicles, List<CheckUp> allCheckUps) {

        for (Vehicle vehicle : allVehicles) {
            if (needsCheckUp(vehicle, allCheckUps)) {
                int nextCheckUpKms = getLastCheckUpKms(vehicle, allCheckUps) + vehicle.getMaintenanceCheckUpFrequency();

                String line = String.format("%s\t%s\t%s\t%d\t%d\t%d\t%d",
                        vehicle.getPlateNumber(), vehicle.getBrand(), vehicle.getModel(), vehicle.getCurrentKm(), vehicle.getMaintenanceCheckUpFrequency(), getLastCheckUpKms(vehicle, allCheckUps), nextCheckUpKms);

                vehiclesNeedingMaintenanceList.add(line);
            }
        }

        return vehiclesNeedingMaintenanceList;
    }

    private boolean needsCheckUp(Vehicle vehicle, List<CheckUp> allCheckUps) {
        int lastCheckUpKms = getLastCheckUpKms(vehicle, allCheckUps);
        int maintenanceCheckUpFrequency = vehicle.getMaintenanceCheckUpFrequency();
        int currentKms = vehicle.getCurrentKm();
        int nextCheckUpKms = lastCheckUpKms + maintenanceCheckUpFrequency;

        return currentKms >= nextCheckUpKms;
    }

    private int getLastCheckUpKms(Vehicle vehicle, List<CheckUp> allCheckUps) {
        int lastCheckUpKms = 0;
        for (CheckUp checkUp : allCheckUps) {
            if (checkUp.getVehicle().equals(vehicle)) {
                if (checkUp.getKMS() > lastCheckUpKms) {
                    lastCheckUpKms = checkUp.getKMS();
                }
            }
        }
        return lastCheckUpKms;
    }

    // QUANDO O CHECKUP.GETDATE ESTIVER EM DATE E NÃO EM STRING, APAGAR O METODO ANTERIOR E COLOCAR ESTE
//    private int getLastCheckUpKms(Vehicle vehicle, List<CheckUp> allCheckUps) {
//        int lastCheckUpKms = 0;
//        Date lastCheckUpDate = null;
//
//        for (CheckUp checkUp : allCheckUps) {
//            if (checkUp.getVehicle().equals(vehicle)) {
//                Date checkUpDate = checkUp.getDate();
//                if (lastCheckUpDate == null || checkUpDate.after(lastCheckUpDate)) {
//                    lastCheckUpDate = checkUpDate;
//                    if (checkUp.getKMS() > lastCheckUpKms) {
//                        lastCheckUpKms = checkUp.getKMS();
//                    }
//                }
//            }
//        }
//        return lastCheckUpKms;
//    }

    @Override
    public String toString() {
        return "Vehicles Needing Maintenance = " + vehiclesNeedingMaintenanceList+'}';
    }

}
