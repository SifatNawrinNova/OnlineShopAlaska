package controller;

import data.model.Men;
import data.model.Select;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;

import java.sql.*;

@ManagedBean(name = "Select")

public class SelectControl {

    Select sl=new Select();

    public Select getSl() {
        return sl;
    }

    public void setSl(Select sl) {
        this.sl = sl;
    }

    public ArrayList<Men>getMenproduct()
    {
        ArrayList<Men> men=new ArrayList<Men>();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Alaska", "alaska_onlineshop");
            Statement smt = con.createStatement();

               String sql1="select product_ID,product_name,product_size,price from product_list where " +
                       "Gender_ID=(select gender_id from collection"+" where gender='"+sl.getSelection()+"') " +
                       "and categories_id=" + "(select categories_id from Categories where " +
                       "categories_name='"+sl.getCategory()+"')";

               ResultSet rs=smt.executeQuery(sql1);
               while (rs.next())
               {
                   Men mn=new Men();
                   mn.setProduct_id(rs.getString(1));
                   mn.setProduct_name(rs.getString(2));
                   mn.setSize(rs.getString(5));
                   mn.setPrice(rs.getInt(6));

                   men.add(mn);


               }
               rs.next();
               con.close();
            }

        catch (Exception e)
        {
            String exp=String.valueOf(e);
            Men mn=new Men();
            mn.setExp(exp);

            }
        return men;

        }

    public String viewselection()
    {
        return "Men";

        }
}


