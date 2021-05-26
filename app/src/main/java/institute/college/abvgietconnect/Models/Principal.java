package institute.college.abvgietconnect.Models;

public class Principal {

    private String name;
    private String designation;
    private String body;
    private String email;
    private String phoneno;

    public Principal(String name, String designation, String body, String email, String phoneno) {
        this.name = name;
        this.designation = designation;
        this.body = body;
        this.email = email;
        this.phoneno = phoneno;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
}
