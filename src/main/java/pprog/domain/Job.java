package pprog.domain;

import java.util.Objects;

public class Job {

    private String name;
    private String description;

    public Job (String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Job)) {
            return false;
        }
        Job that = (Job) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public String getDescription(){ return description; }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Job clone() {
        return new Job(this.name);
    }

    @Override
    public String toString() {
        return name;
    }

}
