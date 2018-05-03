package controller;
import javax.faces.bean.ManagedBean;
import java.sql.*;

import data.model.Login;

@ManagedBean(name = "AlaskaControl")

public class AlaskaController {

    Login lg=new Login();
    int count=0;

    public Login getLg() {
        return lg;
    }

    public void setLg(Login lg) {
        this.lg = lg;
    }

    public String check()
    {
        try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Alaska", "alaska_onlineshop");
                Statement smt = con.createStatement();

                ResultSet rs=smt.executeQuery("Select email,password from signUp");
                while(rs.next())
                {
                    if(lg.getUsername().equals(rs.getString("email"))&&lg.getPassword().equals(rs.getString("password"))) {

                        smt.executeUpdate("ALTER SESSION SET NLS_TIMESTAMP_FORMAT='YY-MON-DD HH24:MI:SS'");
                        smt.executeUpdate("ALTER SESSION SET TIME_ZONE = '+6:00'");

                        String str1 = "insert into login(sign_up_id) select SIGN_UP_ID from SIGNUP where email='" + lg.getUsername() + "'";
                        String str2 = "Update login set login_DateTime=systimestamp where SIGN_UP_ID=(select SIGN_UP_ID from SIGNUP where email='" + lg.getUsername() + "')";
                        String str3="delete from LOGIN where sign_up_id=(select sign_up_id from SIGNUP where email='"+lg.getUsername()+"')";
                            smt.executeUpdate(str3);
                            smt.executeUpdate(str1);
                            smt.executeUpdate(str2);
                            return "view";
                    }
                    else
                    {

                       continue;
                    }


                }
                rs.close();
                con.close();
                return "fail";

        }
            catch (Exception e)
            {
                String exp=String.valueOf(e);
                lg.setLog_exp(exp);

            }
            return "LogException";
        }




}
