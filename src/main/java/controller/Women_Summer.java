package controller;

import data.model.Men;
import data.model.Women;

import javax.faces.bean.ManagedBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@ManagedBean(name = "WomSummer")

public class Women_Summer {

    public ArrayList<Women>getSummerProducts()
    {
      ArrayList<Women> women = new ArrayList<Women>();

        try

    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Alaska", "alaska_onlineshop");
        Statement smt = con.createStatement();

        String sql = "select product_name,product_id,price,product_size from product_list where gender_id=" +
                "(select gender_id from collection where gender='Women') " +
                "and categories_id=(select categories_id from categories where categories_name='Summer')";

        ResultSet rs = smt.executeQuery(sql);

        while (rs.next()) {
            Women mn = new Women();
            mn.setProduct_ID(rs.getString("product_ID"));
            mn.setProductName(rs.getString("product_name"));
            mn.setProduct_size(rs.getString("product_size"));
            mn.setPrice(rs.getInt("price"));

            women.add(mn);

        }

    }
        catch(Exception e)

    {
        String exp = String.valueOf(e);
        Women mn = new Women();
        mn.setExp(exp);
        women.add(mn);
        return women;

    }
        return women;

}

    public  String viewSummerProduct()
    {
        return "WomenSummer";
    }

}



