package Practica1;

import java.sql.*;

public class App {
    //Enlace para hacer: https://gist.githubusercontent.com/josejuansanchez/c408725e848afd64dd9a20ab37fba8c9/raw/94f317604fda43e5dc7b5e859be82307c62c4488/jardineria.sql

    public static void main(String[] args) {

        Connection conn = null;

        try {
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jardineria", "admin", "4DM1n4DM1n");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria?", "admin", "4DM1n4DM1n");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from cast");

            while (rs.next()) {
                String id = rs.getString("id");
                System.out.println(id);
                String name = rs.getString("name");
                System.out.println(name);

            }

            conn.close();
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }

    }

}
