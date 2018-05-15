package controller;
import data.model.Tailor;

import javax.faces.bean.ManagedBean;
import java.util.*;
import java.sql.*;
@ManagedBean(name = "Tailor")
public class TailorInfoControl {

   public  ArrayList<Tailor>getTailorInfo()
    {
        ArrayList<Tailor>tail=new ArrayList<Tailor>();
        try{

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Alaska", "alaska_onlineshop");
            Statement smt = con.createStatement();

            String sql="select tailor_name,sector,service_charge, email_address ,contact_no from Tailors_info";
            ResultSet rs=smt.executeQuery(sql);

            while (rs.next())
            {
                Tailor tl=new Tailor();
                tl.setTailorName(rs.getString("Tailor_name"));
                tl.setSector(rs.getString("Sector"));
                tl.setContact_no(rs.getInt("contact_no"));
                tl.setEmail(rs.getString("email_address"));
                tl.setServiceChrage(rs.getString("Service_charge"));

                tail.add(tl);
            }

        }
        catch (Exception e)
        {
            String exp=String.valueOf(e);
            Tailor tl=new Tailor();
            tl.setExp(exp);
            tail.add(tl);
            return tail;

        }
        return tail;
    }

    public String viewTailorInfo()
    {
        return "TailorInfo";
    }
}
