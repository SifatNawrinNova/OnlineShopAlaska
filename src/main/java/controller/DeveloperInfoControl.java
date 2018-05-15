package controller;
import data.model.Developer;

import javax.faces.bean.ManagedBean;
import java.util.*;
import java.sql.*;

@ManagedBean(name = "Developer")

public class DeveloperInfoControl {

    public ArrayList<Developer>getDeveloperInfo()
    {

        ArrayList<Developer>dev=new ArrayList<Developer>();
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Alaska", "alaska_onlineshop");
            Statement smt = con.createStatement();

            String sql="select developer_name,email,phone_no,designation from developer_info";

            ResultSet rs=smt.executeQuery(sql);

            while (rs.next())
            {
                Developer dv=new Developer();
                dv.setDeveloper_name(rs.getString("developer_name"));
                dv.setEmail(rs.getString("email"));
                dv.setDesignation(rs.getString("designation"));
                dv.setPhone_no(rs.getInt("phone_no"));
                dev.add(dv);
            }
        }
       catch (Exception e)
       {

       }
       return  dev;

    }


    public String viewINFO()
    {
        return "DevelopeInformation";
    }

}
