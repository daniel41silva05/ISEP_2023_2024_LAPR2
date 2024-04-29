package pprog.domain;

import java.util.Objects;

public class Job {

    private String name;

    public Job (String name) {
        this.name = name;
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

    public void setName(String name) {
        this.name = name;
    }

    public Job clone() {
        return new Job(this.name);
    }

    @Override
    public String toString() {
        return name;
    }

}
