package pprog.domain;

public class CheckUp {

    private int date;
    private double plate, KMS;

    public CheckUp(int date, double plate, double KMS) {
        this.date = date;
        this.plate = plate;
        this.KMS = KMS;
    }

    public double getKMS() {
        return KMS;
    }

    public int getDate() {
        return date;
    }
    public double getPlate() {
        return plate;
    }
    public void setDate(int date) {
        this.date = date;
    }

    public void setKMS(double KMS) {
        this.KMS = KMS;
    }

    public void setPlate(double plate) {
        this.plate = plate;
    }

}
