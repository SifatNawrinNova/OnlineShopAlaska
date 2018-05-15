package controller;

import data.model.Men;

import javax.faces.bean.ManagedBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

@ManagedBean(name = "Footwear")
public class Men_FootWear {

    public ArrayList<Men> getFootWearProduct() {
        ArrayList<Men> men = new ArrayList<Men>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Alaska", "alaska_onlineshop");
            Statement smt = con.createStatement();

            String sql = "select product_name,product_id,price,product_size from product_list where gender_id=" +
                    "(select gender_id from collection where gender='Men') " +
                    "and categories_id=(select categories_id from categories where categories_name='Foot_wear')";

            ResultSet rs = smt.executeQuery(sql);

            while (rs.next()) {
                Men mn = new Men();
                mn.setProduct_ID(rs.getString("product_ID"));
                mn.setProductName(rs.getString("product_name"));
                mn.setProduct_size(rs.getString("product_size"));
                mn.setPrice(rs.getInt("price"));

                men.add(mn);

            }

        } catch (Exception e) {
            String exp = String.valueOf(e);
            Men mn = new Men();
            mn.setExp(exp);
            men.add(mn);
            return men;

        }
        return men;

    }

    public  String viewFootwearProduct()
    {
        return "MenFootWear";
    }
}

