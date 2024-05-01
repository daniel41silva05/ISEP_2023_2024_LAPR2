package pprog.domain;

import pprog.controller.RegisterVehicleController;
import pprog.controller.RegisterCheckUpController;
import pprog.controller.VehicleNeedingMaintenanceController;

import java.util.Scanner;
import java.util.List;

public class mainTestarUs6eUs7eUs8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegisterVehicleController vehicleController = new RegisterVehicleController();
        RegisterCheckUpController checkUpController = new RegisterCheckUpController();
        VehicleNeedingMaintenanceController maintenanceController = new VehicleNeedingMaintenanceController();

        boolean exit = false;
        while (!exit) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Registrar um novo veículo");
            System.out.println("2 - Registrar uma manutenção para um veículo");
            System.out.println("3 - Ver a lista de veículos registrados");
            System.out.println("4 - Ver a lista de manutenções registradas");
            System.out.println("5 - Ver a lista de veículos que precisam de manutenção");
            System.out.println("6 - Sair");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (choice) {
                case 1:
                    registerVehicle(scanner, vehicleController);
                    break;
                case 2:
                    registerCheckUp(scanner, checkUpController);
                    break;
                case 3:
                    listVehicles(vehicleController);
                    break;
                case 4:
                    listCheckUps(checkUpController);
                    break;
                case 5:
                    listVehiclesNeedingMaintenance(maintenanceController);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }

        scanner.close();
    }

    private static void registerVehicle(Scanner scanner, RegisterVehicleController vehicleController) {
        System.out.println("\nRegistrar um novo veículo:");
        System.out.print("Marca: ");
        String brand = scanner.nextLine();
        System.out.print("Modelo: ");
        String model = scanner.nextLine();
        System.out.print("Peso TARA: ");
        int tare = scanner.nextInt();
        System.out.print("Peso Bruto: ");
        int grossWeight = scanner.nextInt();
        System.out.print("Quilômetros atuais: ");
        int currentKm = scanner.nextInt();
        System.out.print("Data de registro (AAAA MM DD): ");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        Date registerDate = new Date(year, month, day);
        System.out.print("Data de aquisição (AAAA MM DD): ");
        year = scanner.nextInt();
        month = scanner.nextInt();
        day = scanner.nextInt();
        Date acquisitionDate = new Date(year, month, day);
        System.out.print("Frequência de verificação de manutenção: ");
        int maintenanceCheckUpFrequency = scanner.nextInt();
        System.out.print("Número da placa: ");
        String plateNumber = scanner.next();

        System.out.println("Escolha o tipo de transporte:");
        System.out.println("1 - Passageiros");
        System.out.println("2 - Carga Mista");

        int typeChoice = scanner.nextInt();
        VehicleType.TypeTransport typeTransport;
        if (typeChoice == 1) {
            typeTransport = VehicleType.TypeTransport.PASSENGERS;
        } else if (typeChoice == 2) {
            typeTransport = VehicleType.TypeTransport.MIXED;
        } else {
            System.out.println("Opção inválida. Escolha novamente.");
            return; // Saímos do programa se a opção for inválida
        }

        System.out.println("Escolha a categoria de peso do pacote:");
        System.out.println("1 - Leve");
        System.out.println("2 - Pesada");

        int weightChoice = scanner.nextInt();
        VehicleType.PackageWeight packageWeight;
        if (weightChoice == 1) {
            packageWeight = VehicleType.PackageWeight.LIGHT;
        } else if (weightChoice == 2) {
            packageWeight = VehicleType.PackageWeight.HEAVY;
        } else {
            System.out.println("Opção inválida. Escolha novamente.");
            return; // Saímos do programa se a opção for inválida
        }

        System.out.println("Escolha o tipo de transporte do veículo:");
        System.out.println("1 - Caixa Aberta");
        System.out.println("2 - Furgão Fechado");
        System.out.println("3 - Caminhão");

        int transportChoice = scanner.nextInt();
        VehicleType.Transport transport;
        if (transportChoice == 1) {
            transport = VehicleType.Transport.OPEN_BOX;
        } else if (transportChoice == 2) {
            transport = VehicleType.Transport.CLOSED_VANS;
        } else if (transportChoice == 3) {
            transport = VehicleType.Transport.TRUCKS;
        } else {
            System.out.println("Opção inválida. Escolha novamente.");
            return; // Saímos do programa se a opção for inválida
        }

        VehicleType type = new VehicleType(typeTransport, packageWeight, transport);

        Vehicle registeredVehicle = vehicleController.registerVehicle(brand, model, tare, grossWeight, currentKm, registerDate, acquisitionDate, maintenanceCheckUpFrequency, plateNumber, type);
        System.out.println("Veículo registrado com sucesso: " + registeredVehicle);
    }

    private static void registerCheckUp(Scanner scanner, RegisterCheckUpController checkUpController) {
        System.out.println("\nRegistrar uma manutenção para um veículo:");
        System.out.print("Placa do veículo: ");
        String vehiclePlateNumber = scanner.next();
        System.out.print("Data da manutenção (AAAA MM DD): ");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        Date checkUpDate = new Date(year, month, day);
        System.out.print("Quilômetros atuais: ");
        int kms = scanner.nextInt();

        checkUpController.registerCheckUp(vehiclePlateNumber, checkUpDate, kms);
        System.out.println("Manutenção registrada para o veículo de placa " + vehiclePlateNumber + ".");
    }

    private static void listVehicles(RegisterVehicleController vehicleController) {
        System.out.println("\nLista de veículos registrados:");
        List<Vehicle> vehiclesList = vehicleController.getVehiclesList();
        if (vehiclesList.isEmpty()) {
            System.out.println("Nenhum veículo registrado.");
        } else {
            for (Vehicle vehicle : vehiclesList) {
                System.out.println(vehicle);
            }
        }
    }

    private static void listCheckUps(RegisterCheckUpController checkUpController) {
        System.out.println("\nLista de manutenções registradas:");
        List<CheckUp> checkUpsList = checkUpController.getCheckUpList();
        if (checkUpsList.isEmpty()) {
            System.out.println("Nenhuma manutenção registrada.");
        } else {
            for (CheckUp checkUp : checkUpsList) {
                System.out.println(checkUp);
            }
        }
    }

    private static void listVehiclesNeedingMaintenance(VehicleNeedingMaintenanceController maintenanceController) {
        List<String> vehiclesNeedingMaintenanceList = maintenanceController.getVehiclesNeedingMaintenanceList();

        if (vehiclesNeedingMaintenanceList.isEmpty()) {
            System.out.println("Nenhum veículo precisa de manutenção.");
        } else {
            System.out.println("\nVeículos que precisam de manutenção:");
            for (String vehicleInfo : vehiclesNeedingMaintenanceList) {
                System.out.println(vehicleInfo);
            }
        }
    }
}
