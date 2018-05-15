package data.model;

public class Developer {

    private String Developer_name;
    private int Phone_no;
    private String designation;
    private String email;

    public Developer() {
    }

    public String getDeveloper_name() {
        return Developer_name;
    }

    public void setDeveloper_name(String developer_name) {
        Developer_name = developer_name;
    }

    public int getPhone_no() {
        return Phone_no;
    }

    public void setPhone_no(int phone_no) {
        Phone_no = phone_no;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
