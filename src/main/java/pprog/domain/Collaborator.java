package pprog.domain;

import pprog.repository.SkillRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Represents a collaborator.
 */
public class Collaborator {

    /** The name of the collaborator. */
    private String name;

    /** The birthday of the collaborator. */
    private String birthday;

    /** The admission date of the collaborator. */
    private String admissionDate;

    /** The address of the collaborator. */
    private String address;

    /** The phone number of the collaborator. */
    private int phoneNumber;

    /** The email of the collaborator. */
    private String email;

    /** The identification document type of the collaborator. */
    private IdDocType idDocType;

    /** The identification number of the collaborator. */
    private int idNumber;

    /** The job of the collaborator. */
    private Job job;

    private List<Skill> skillAssign;

    /**
     * Constructs a new Collaborator object with the specified attributes.
     *
     * @param name          The name of the collaborator.
     * @param birthday      The birthday of the collaborator.
     * @param admissionDate The admission date of the collaborator.
     * @param address       The address of the collaborator.
     * @param phoneNumber   The phone number of the collaborator.
     * @param email         The email of the collaborator.
     * @param idDocType     The identification document type of the collaborator.
     * @param idNumber      The identification number of the collaborator.
     * @param job           The job of the collaborator.
     */
    public Collaborator(String name, String birthday, String admissionDate, String address, int phoneNumber, String email, IdDocType idDocType, int idNumber, Job job) {
        this.name = name;
        this.birthday = birthday;
        this.admissionDate = admissionDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idDocType = idDocType;
        this.idNumber = idNumber;
        this.job = job;
        this.skillAssign = new ArrayList<>();
    }

    /**
     * Gets the name of the collaborator.
     *
     * @return The name of the collaborator.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the collaborator.
     *
     * @param name The new name of the collaborator.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the birthday of the collaborator.
     *
     * @return The birthday of the collaborator.
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * Sets the birthday of the collaborator.
     *
     * @param birthday The new birthday of the collaborator.
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * Gets the admission date of the collaborator.
     *
     * @return The admission date of the collaborator.
     */
    public String getAdmissionDate() {
        return admissionDate;
    }

    /**
     * Sets the admission date of the collaborator.
     *
     * @param admissionDate The new admission date of the collaborator.
     */
    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    /**
     * Gets the address of the collaborator.
     *
     * @return The address of the collaborator.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the collaborator.
     *
     * @param address The new address of the collaborator.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the phone number of the collaborator.
     *
     * @return The phone number of the collaborator.
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the collaborator.
     *
     * @param phoneNumber The new phone number of the collaborator.
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the email of the collaborator.
     *
     * @return The email of the collaborator.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the collaborator.
     *
     * @param email The new email of the collaborator.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the identification document type of the collaborator.
     *
     * @return The identification document type of the collaborator.
     */
    public IdDocType getIdDocType() {
        return idDocType;
    }

    /**
     * Sets the identification document type of the collaborator.
     *
     * @param idDocType The new identification document type of the collaborator.
     */
    public void setIdDocType(IdDocType idDocType) {
        this.idDocType = idDocType;
    }

    /**
     * Gets the identification number of the collaborator.
     *
     * @return The identification number of the collaborator.
     */
    public int getIdNumber() {
        return idNumber;
    }

    /**
     * Sets the identification number of the collaborator.
     *
     * @param idNumber The new identification number of the collaborator.
     */
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * Gets the job of the collaborator.
     *
     * @return The job of the collaborator.
     */
    public Job getJob() {
        return job;
    }

    /**
     * Sets the job of the collaborator.
     *
     * @param job The new job of the collaborator.
     */
    public void setJob(Job job) {
        this.job = job;
    }


    public List<Skill> getSkillAssign() {
        return skillAssign;
    }

    public void setSkillAssign(List<Skill> skillAssign) {
        this.skillAssign = skillAssign;
    }

    public void assignSkill (Skill skill) {
        skillAssign.add(skill);
    }

    /**
     * Creates and returns a copy of this collaborator.
     *
     * @return A new Collaborator object with the same attributes.
     */
    public Collaborator clone() {
        return new Collaborator(this.name, this.birthday, this.admissionDate, this.address, this.phoneNumber, this.email, this.idDocType, this.idNumber, this.job);
    }

    /**
     * Returns a string representation of the Collaborator.
     *
     * @return A string representation of the Collaborator.
     */
    @Override
    public String toString() {
        return String.format("Collaborator\nName: %s\nBirthday: %s\nAdmission Date: %s\nAddress: %s\nPhone Number: %d\nEmail: %s\nID Document Type: %s\nID Number: %d\nJob: %s\n",
                name, birthday, admissionDate, address, phoneNumber, email, idDocType, idNumber, job);
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Collaborator outroCollaborator = (Collaborator) outroObjeto;
        return name.equalsIgnoreCase(outroCollaborator.name) &&
                birthday.equals(outroCollaborator.birthday) &&
                admissionDate.equals(outroCollaborator.admissionDate) &&
                address.equalsIgnoreCase(outroCollaborator.address) &&
                phoneNumber == outroCollaborator.phoneNumber &&
                email.equalsIgnoreCase(outroCollaborator.email) &&
                idDocType.equals(outroCollaborator.idDocType) &&
                idNumber == outroCollaborator.idNumber &&
                job.equals(outroCollaborator.job);
    }


}