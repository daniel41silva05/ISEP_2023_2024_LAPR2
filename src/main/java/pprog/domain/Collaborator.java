package pprog.domain;

import java.util.Objects;

public class Collaborator {
    public enum IdDocType {
        taxpayerNumber, citizenCard, passport
    }
    private String name;
    private String birthday;
    private String admissionDate;
    private String address;
    private int phoneNumber;
    private String email;
    private IdDocType idDocType;
    private int idNumber;
    private Job job;

    public Collaborator (String name, String birthday, String admissionDate, String address, int phoneNumber, String email, IdDocType idDocType, int idNumber, Job job) {
        this.name = name;
        this.birthday = birthday;
        this.admissionDate = admissionDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idDocType = idDocType;
        this.idNumber = idNumber;
        this.job = job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Collaborator)) {
            return false;
        }
        Collaborator that = (Collaborator) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public IdDocType getIdDocType() {
        return idDocType;
    }

    public void setIdDocType(IdDocType idDocType) {
        this.idDocType = idDocType;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Collaborator clone() {
        return new Collaborator(this.name, this.birthday, this.admissionDate, this.address, this.phoneNumber, this.email, this.idDocType, this.idNumber, this.job);
    }

    @Override
    public String toString() {
        return String.format("Collaborator\nName: %s\nBirthday: %s\nAdmission Date: %s\nAddress: %s\nPhone Number: %d\nEmail: %s\nID Document Type: %s\nID Number: %d\nJob: %s\n",
                name, birthday, admissionDate, address, phoneNumber, email, idDocType, idNumber, job);
    }

}
