package institute.college.abvgietconnect.Administration;

public class Staffmodel {

    String name;
    String designation;

    public Staffmodel(){

    }

    public Staffmodel(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
