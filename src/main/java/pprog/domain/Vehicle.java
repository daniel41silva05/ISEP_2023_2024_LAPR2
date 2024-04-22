package pprog.domain;

public class Vehicle {

    private String brand;
    private String model;
    private int tare;
    private int grossWeight;
    private int currentKm;
    private String registerDate;
    private String acquisitionDate;
    private int maintenanceCheckUpFrequency;
    private String plateNumber;
    private VehicleType type;

    public Vehicle(String brand, String model, int tare, int grossWeight, int currentKm, String registerDate, String acquisitionDate, int maintenanceCheckUpFrequency, String plateNumber, VehicleType type) {
        this.brand = brand;
        this.model = model;
        this.tare = tare;
        this.grossWeight = grossWeight;
        this.currentKm = currentKm;
        this.registerDate = registerDate;
        this.acquisitionDate = acquisitionDate;
        this.maintenanceCheckUpFrequency = maintenanceCheckUpFrequency;
        this.plateNumber = plateNumber;
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getTare() {
        return tare;
    }

    public void setTare(int tare) {
        this.tare = tare;
    }

    public int getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(int grossWeight) {
        this.grossWeight = grossWeight;
    }

    public int getCurrentKm() {
        return currentKm;
    }

    public void setCurrentKm(int currentKm) {
        this.currentKm = currentKm;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(String acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public int getMaintenanceCheckUpFrequency() {
        return maintenanceCheckUpFrequency;
    }

    public void setMaintenanceCheckUpFrequency(int maintenanceCheckUpFrequency) {
        this.maintenanceCheckUpFrequency = maintenanceCheckUpFrequency;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("Vehicle\nBrand: %s\nModel: %s\nTare: %d\nGross Weight: %d\nCurrent Km: %d\nRegister Date: %s\nAcquisition Date: %s\nMaintenance CheckUp Frequency: %d\nPlate Number: %s\nType: %s\n",
                brand, model, tare, grossWeight, currentKm, registerDate, acquisitionDate, maintenanceCheckUpFrequency, plateNumber, type);
    }

}

