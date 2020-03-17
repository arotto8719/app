package org.launchcode.app.data;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Artifact {

    @Id
    @GeneratedValue
    public int id;

    private String name;
    private String location;
    private String description;

    public Artifact() {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
