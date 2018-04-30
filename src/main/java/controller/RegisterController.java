package controller;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ResultTreeType;
import data.model.Register;
import java.sql.*;

import javax.faces.bean.ManagedBean;
import javax.swing.plaf.nimbus.State;

@ManagedBean(name = "RegisterControl")

public class RegisterController {

    Register rg=new Register();

    public Register getRg() {
        return rg;
    }

    public void setRg(Register rg) {
        this.rg = rg;
    }

   public String sucessReg()
   {
       int ph_no=Integer.valueOf(rg.getPhoneNo());
       try {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Alaska", "alaska_onlineshop");
           Statement smt = con.createStatement();
           ResultSet rs = smt.executeQuery("select*from SignUp");

           while (rs.next())

           {
               if (rg.getPassword().equals(rs.getString("Password"))) {

                   if (ph_no == rs.getInt("phone_no")) {

                       if (rg.getEmail().equals(rs.getString("email"))) {
                           return "equal";

                           }
                   }
               }
               else {

                   String sql1 = "insert into SignUp(First_name,last_name,city,phone_no,password,email, signUp_DateTime ) " +
                           "values('" + rg.getFirstName() + "','" +rg.getLastName()+"','"+rg.getCity()+"'," +
                           "" + rg.getPhoneNo() + ",'" + rg.getPassword()+ "','" + rg.getEmail() + "',systimestamp)";

                   smt.executeUpdate(sql1);


                   if (rg.getUserType().equalsIgnoreCase("Customer")) {
                       String sql2 = "update SIGNUP set user_id=(select user_id from ALASKAUSER where user_type='" + rg.getUserType() + "') where password='" + rg.getPassword()+ "'";
                       smt.executeUpdate(sql2);
                   } else if (rg.getUserType().equalsIgnoreCase("Administrator")) {
                       String sql2 = "update SIGNUP set USER_ID=(select user_id from ALASKAUSER where user_type='" +rg.getUserType()+ "') where password='" + rg.getPassword() + "'";
                       smt.executeUpdate(sql2);

                   }



                   }
               rs=smt.executeQuery("Select sign_up_id from signUp where password='"+rg.getPassword()+"'");
               while(rs.next()) {
                   rg.setSignUpID(rs.getInt(1));
               }
                  rs.close();

                   return "success";
                   }
           con.close();
       }

       catch(Exception e)
       {
          String ep=String.valueOf(e);
          rg.setExp(ep);


       }
       return "exception";

   }
}
