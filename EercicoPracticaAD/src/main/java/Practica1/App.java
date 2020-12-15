package Practica1;

import java.sql.*;

import utilidades.Leer;

public class App {

    public static void main(String[] args) {

        

        try {

             Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jardineria?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "admin", "4DM1n4DM1n");

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * from cliente");

            int opcion = 0;

            do {

                System.out.println("\n****Menu Interactivo****");

                System.out.println("1. Insertar Cliente");

                System.out.println("2. Listar a un cliente");

                System.out.println("3. Mostrar todos los clientes ");

                System.out.println("4. Buscar un cliente");

                System.out.println("************************************");

                try {
                    System.out.println("opcion a realizar");
                    opcion = Leer.pedirEnteroValidar();
                } catch (Exception e) {
                    System.out.println("Mal!!!");
                }

            } while (opcion != 0);

            switch (opcion) {
                case 1:
                    System.out.println("Dime el codigo del nuevo cliente");
                    int codigo_cliente  = Leer.pedirEnteroValidar();

                    System.out.println("Dime el nombre del nuevo cliente");
                    String nombre_cliente = Leer.pedirCadena();

                    System.out.println("Dime el nombre del nuevo contacto");
                    String nombre_contacto = Leer.pedirCadena();

                    System.out.println("Dime el apllido del nuevo contacto");
                    String apellido_contacto = Leer.pedirCadena();

                    System.out.println("Dime el telefono");
                    int telefono = Leer.pedirEnteroValidar();

                    System.out.println("Dime la dirreción del cliente");
                    String direccion1 = Leer.pedirCadena();

                    System.out.println("Dime la ciudad");
                    String ciudad = Leer.pedirCadena();

                    System.out.println("Dime la region del cliente");
                    String region = Leer.pedirCadena();

                    System.out.println("Dime el pais del cliente");
                    String pais = Leer.pedirCadena();

                    System.out.println("Dime el codigo postal cliente");
                    String codigo_postal = Leer.pedirCadena();
                    

                    statement.executeUpdate("Insert into cliente" + "values('"+ codigo_cliente +" "+ nombre_cliente +"')");



                    break;

                case 2:

                System.out.println("Introduce el codigo del cliente a mostrar");



                    break;

                case 3:

                    break;

                case 4:
                    break;

                default:
                    break;
            }

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
    public void crear(App clienteApp) throws SQLException {

        
              
    }

}
