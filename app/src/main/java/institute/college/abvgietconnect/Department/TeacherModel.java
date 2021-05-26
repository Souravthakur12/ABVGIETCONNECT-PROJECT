package institute.college.abvgietconnect.Department;

public class TeacherModel {

    private String name,email,designation,image,key;

    public TeacherModel() {
    }

    public TeacherModel(String name, String email, String designation, String image, String key) {
        this.name = name;
        this.email = email;
        this.designation = designation;
        this.image = image;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
