package pprog.ui.classesUI;

import pprog.controller.RegisterVehicleController;
import pprog.domain.Vehicle;
import pprog.domain.VehicleType;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class RegisterVehicleUI implements Runnable {
    private RegisterVehicleController controller;

    private String brand;
    private String model;
    private int tare;
    private int grossWeight;
    private int currentKm;
    private Date registerDate;
    private Date acquisitionDate;
    private int maintenanceCheckUpFrequency;
    private String plateNumber;
    private VehicleType type;

    public RegisterVehicleUI() {
        controller = new RegisterVehicleController();
    }

    private RegisterVehicleController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\n\n--- Register a Vehicle ------------------------");

        requestData();
        submitData();

    }

    private void submitData() {
        Vehicle vehicle = controller.registerVehicle(brand, model, tare, grossWeight, currentKm, registerDate, acquisitionDate, maintenanceCheckUpFrequency, plateNumber, type);
        if (vehicle != null) {
            System.out.println("\nVehicle successfully registed!");
        } else {
            System.out.println("\nVehicle not registed!");
        }

    }

    private void requestData() {
        brand = requestBrand();
        model = requestModel();
        tare = requestTare();
        grossWeight = requestGrossWeight();
        currentKm = requestCurrentKm();
        registerDate = requestRegisterDate();
        acquisitionDate = requestAcquisitionDate();
        maintenanceCheckUpFrequency = requestMaintenanceCheckUpFrequency();
        plateNumber = requestPlateNumber();
        type = requestVehicleType();

    }

    private String requestBrand() {
        Scanner input = new Scanner(System.in);
        System.out.print("Brand: ");
        return input.nextLine();
    }

    private String requestModel() {
        Scanner input = new Scanner(System.in);
        System.out.print("Model: ");
        return input.nextLine();
    }

    private int requestTare() {
        Scanner input = new Scanner(System.in);
        int tare;
        do {
            System.out.print("Tare: ");
            tare = input.nextInt();
            if (tare < 0) {
                System.out.println("Please enter a non-negative number.");
            }
        } while (tare < 0);
        return tare;
    }

    private int requestGrossWeight() {
        Scanner input = new Scanner(System.in);
        int grossWeight;
        do {
            System.out.print("Gross Weight: ");
            grossWeight = input.nextInt();
            if (grossWeight < 0) {
                System.out.println("Please enter a non-negative number.");
            }
        } while (grossWeight < 0);
        return grossWeight;
    }

    private int requestCurrentKm() {
        Scanner input = new Scanner(System.in);
        int currentKm;
        do {
            System.out.print("Current Km: ");
            currentKm = input.nextInt();
            if (currentKm < 0) {
                System.out.println("Please enter a non-negative number.");
            }
        } while (currentKm < 0);
        return currentKm;
    }

    private Date requestRegisterDate() {
        Scanner input = new Scanner(System.in);
        System.out.print("Register Date (format: dd/MM/yyyy): ");
        String dateStr = input.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy format.");
            return requestRegisterDate();
        }
    }

    private Date requestAcquisitionDate() {
        Scanner input = new Scanner(System.in);
        System.out.print("Acquisition Date (format: dd/MM/yyyy): ");
        String dateStr = input.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy format.");
            return requestAcquisitionDate();
        }
    }

    private int requestMaintenanceCheckUpFrequency() {
        Scanner input = new Scanner(System.in);
        int maintenanceCheckUpFrequency;
        do {
            System.out.print("Maintenance CheckUp Frequency: ");
            maintenanceCheckUpFrequency = input.nextInt();
            if (maintenanceCheckUpFrequency < 0) {
                System.out.println("Please enter a non-negative number.");
            }
        } while (maintenanceCheckUpFrequency < 0);
        return maintenanceCheckUpFrequency;
    }

    private String requestPlateNumber() {
        Scanner input = new Scanner(System.in);
        String plateNumber;
        do {
            System.out.print("Plate Number (format: XX XX XX): ");
            plateNumber = input.nextLine();
            if (!plateNumber.matches("[A-Z0-9]{2} [A-Z0-9]{2} [A-Z0-9]{2}")) {
                System.out.println("Please enter a plate number in the format XX XX XX.");
            }
        } while (!plateNumber.matches("[A-Z0-9]{2} [A-Z0-9]{2} [A-Z0-9]{2}"));
        return plateNumber;
    }

    private VehicleType requestVehicleType() {
        Scanner input = new Scanner(System.in);
        System.out.print("Vehicle Type: ");
        System.out.println("- Type Transport");
        System.out.println("1. Passengers");
        System.out.println("2. Mixed");
        int typeTransportInput = input.nextInt();
        VehicleType.TypeTransport typeTransport = null;
        if (typeTransportInput == 1) {
            typeTransport = VehicleType.TypeTransport.PASSENGERS;
        }
        if (typeTransportInput == 2) {
            typeTransport = VehicleType.TypeTransport.MIXED;
        }
        System.out.println("- Package Weight");
        System.out.println("1. Light");
        System.out.println("2. Heavy");
        int packageWeightInput = input.nextInt();
        VehicleType.PackageWeight packageWeight = null;
        if (packageWeightInput == 1) {
            packageWeight = VehicleType.PackageWeight.LIGHT;
        }
        if (packageWeightInput == 2) {
            packageWeight = VehicleType.PackageWeight.HEAVY;
        }
        System.out.println("- Transport");
        System.out.println("1. Open Box");
        System.out.println("2. Closed Vans");
        System.out.println("3. Trucks");
        int transportInput = input.nextInt();
        VehicleType.Transport transport = null;
        if (transportInput == 1) {
            transport = VehicleType.Transport.OPEN_BOX;
        }
        if (transportInput == 2) {
            transport = VehicleType.Transport.CLOSED_VANS;
        }
        if (transportInput == 3) {
            transport = VehicleType.Transport.TRUCKS;
        }

        return new VehicleType(typeTransport, packageWeight, transport);
    }
}
