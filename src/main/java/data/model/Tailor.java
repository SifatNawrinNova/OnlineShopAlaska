package data.model;

import javax.xml.soap.SAAJResult;

public class Tailor {

    private String TailorName;
    private String Sector;
    private String ServiceChrage;
    private String Email;
    private int contact_no;

    private String exp;


    public Tailor() {
    }

    public String getTailorName() {
        return TailorName;
    }

    public void setTailorName(String tailorName) {
        TailorName = tailorName;
    }

    public String getSector() {
        return Sector;
    }

    public void setSector(String sector) {
        Sector = sector;
    }

    public String getServiceChrage() {
        return ServiceChrage;
    }

    public void setServiceChrage(String serviceChrage) {
        ServiceChrage = serviceChrage;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getContact_no() {
        return contact_no;
    }

    public void setContact_no(int contact_no) {
        this.contact_no = contact_no;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }
}
