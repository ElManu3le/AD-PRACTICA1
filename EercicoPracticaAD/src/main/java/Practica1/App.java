package Practica1;

import java.sql.*;

public class App {

    public static void main(String[] args) {

        Connection conn = null;

        try {
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "admin", "4DM1n4DM1n");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from cliente"); 

            while (rs.next()) {
                String id = rs.getString("codigo_cliente");
                System.out.print(id);
                String name = rs.getString("nombre_cliente");
                System.out.println(name);

            }

            conn.close();
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }

    }

}
