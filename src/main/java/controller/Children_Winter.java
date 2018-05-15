package controller;

import data.model.Children;

import javax.faces.bean.ManagedBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@ManagedBean(name="chWinter")

public class Children_Winter {

    public ArrayList<Children> getWinterProduct()
    {
        ArrayList<Children>child=new ArrayList<Children>();

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Alaska", "alaska_onlineshop");
            Statement smt = con.createStatement();

            String sql="select product_name,product_id,price,product_size from product_list where gender_id=" +
                    "(select gender_id from collection where gender='Children') " +
                    "and categories_id=(select categories_id from categories where categories_name='Winter')";

            ResultSet rs=smt.executeQuery(sql);

            while(rs.next())
            {
                Children mn=new Children();
                mn.setProduct_ID(rs.getString("product_ID"));
                mn.setProductName(rs.getString("product_name"));
                mn.setProduct_size(rs.getString("product_size"));
                mn.setPrice(rs.getInt("price"));

                child.add(mn);

            }

        }
        catch (Exception e)
        {
            String exp=String.valueOf(e);
            Children mn=new Children();
            mn.setExp(exp);
            child.add(mn);
            return  child;

        }
        return child;

    }

    public  String viewWinterProduct()
    {
        return "ChildWinter";
    }

}

