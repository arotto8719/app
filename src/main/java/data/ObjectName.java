package data;

public class ObjectName<string> {
    public int id;
    private string name;
    private string location;
    private string description;

    public ObjectName(String value) {

    }

    public string getName() {
        return name;
    }

    public void setName(string name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public string getLocation() {
        return location;
    }

    public void setLocation(string location) {
        this.location = location;
    }

    public string getDescription() {
        return description;
    }

    public void setDescription(string description) {
        this.description = description;
    }
}
