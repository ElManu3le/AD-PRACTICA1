package Practica1;

import java.sql.*;

import utilidades.Leer;

public class App {

    public static void main(String[] args) {

        try {

            Connection conn = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/jardineria?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                                "root", "gt2rsmanuel620");

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

            } while ((opcion < 0) && (opcion > 5));

            switch (opcion) {

                case 1:

                    System.out.println("Introduzca los valores del cliente para añadir");

                    try {
                        int codigo_cliente = 39;
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

                        

                        String sql = "insert into cliente (codigo_cliente, nombre_cliente, nombre_contacto,apellido_contacto, telefono, linea_direccion1, ciudad, region, pais, codigo_postal) "
                                + "values(?, ?, ?, ?, ?, ?,?, ?,?, ?)";

                        PreparedStatement statement = conn.prepareStatement(sql);
                        statement.setInt(1, 39);
                        statement.setString(2, nombre_cliente);
                        statement.setString(3, nombre_contacto);
                        statement.setString(4, apellido_contacto);
                        statement.setInt(5, telefono);
                        statement.setString(6, direccion1);
                        statement.setString(7, ciudad);
                        statement.setString(8, region);
                        statement.setString(9, pais);
                        statement.setString(10, codigo_postal);

                        statement.executeUpdate(sql);

                    } catch (Exception e) {

                    }

                    // Caso para añadir un nuevo cliente
                    App.main(args);
                    break;

                case 2:

                    break;

                case 3:
                   

                    Statement statement = conn.createStatement();
                    ResultSet rs = statement.executeQuery("Select * from cliente");

                    System.out.println("Aquí te muestro a todos los clientes de nuestra base de datos.");

                    while (rs.next()) {

                        String id = rs.getString("codigo_cliente");
                        System.out.print(id);
                        String name = rs.getString("nombre_cliente");
                        System.out.println("\t" + name);

                    }

                    App.main(args);

                    break;

                case 4:
                    break;

                default:
                    break;
            }

        } catch (SQLException ex) {

            ex.printStackTrace();
        }

    }

}
