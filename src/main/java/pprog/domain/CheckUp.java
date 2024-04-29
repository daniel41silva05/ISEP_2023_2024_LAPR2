package pprog.domain;

import pprog.domain.Date;
import java.util.ArrayList;
import java.util.List;


public class CheckUp {

    private String plate;
    private Date date;
    private double KMS;

    public CheckUp(Date date, String plate, double KMS) {
        this.date = date;
        this.plate = plate;
        this.KMS = KMS;
    }

    public double getKMS() {
        return KMS;
    }

    public int getDate() {
        return date.toString();
    }

    public double getPlate() {
        String plate;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setKMS(double KMS) {
        this.KMS = KMS;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    @Override
    public String toString(){ return date + " " + plate + " " + KMS; }
}
