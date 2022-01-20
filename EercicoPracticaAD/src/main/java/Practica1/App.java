package Practica1;

import java.sql.*;

import utilidades.Leer;

public class App {

    public static void main(String[] args) {

        Connection conn = null;
        try {

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jardineria?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "admin");//contraseña DB en itaca es admin, sino gt2rsmanuel620

        } catch (SQLException ex) {

            ex.printStackTrace();
        }

        int opcion = 0;

        do {

            System.out.println("\n****Menu Interactivo****");

            System.out.println("1. Insertar Cliente");

            System.out.println("2. Mostrar un cliente");

            System.out.println("3. Mostrar todos los clientes ");

            System.out.println("4. Buscar un cliente");

            System.out.println("5. Editar un producto");

            System.out.println("************************************");

            try {
                System.out.println("opcion a realizar");
                opcion = Leer.pedirEnteroValidar();
            } catch (Exception e) {
                System.out.println("Mal!!!");
            }

        } while ((opcion < 0) && (opcion > 6));

        switch (opcion) {

            case 1:

                System.out.println("Introduzca los valores del cliente para añadir");

                try {
                    System.out.println("Codigo de cliente nuevo");
                    int codigo_cliente = Leer.pedirEnteroValidar();

                    System.out.println("Dime el nombre del nuevo cliente");
                    String nombre_cliente = Leer.pedirCadena();

                    System.out.println("Dime el nombre del nuevo contacto");
                    String nombre_contacto = Leer.pedirCadena();

                    System.out.println("Dime el apllido del nuevo contacto");
                    String apellido_contacto = Leer.pedirCadena();

                    System.out.println("Dime el telefono");
                    String telefono = Leer.pedirCadena();

                    System.out.println("Dime el fax");
                    String fax = Leer.pedirCadena();

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

                    String sql = "insert into cliente (codigo_cliente, nombre_cliente, nombre_contacto,apellido_contacto, telefono, fax, linea_direccion1, ciudad, region, pais, codigo_postal) "
                            + "values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

                    PreparedStatement statement = conn.prepareStatement(sql);

                    statement.setInt(1, codigo_cliente);
                    statement.setString(2, nombre_cliente);
                    statement.setString(3, nombre_contacto);
                    statement.setString(4, apellido_contacto);
                    statement.setString(5, telefono);
                    statement.setString(6, fax);
                    statement.setString(7, direccion1);
                    statement.setString(8, ciudad);
                    statement.setString(9, region);
                    statement.setString(10, pais);
                    statement.setString(11, codigo_postal);

                    statement.executeUpdate();

                } catch (Exception e) {
                    e.printStackTrace();

                }

                App.main(args);
                break;

            case 2:
                System.out.println("codigo cliente a mostrar");
                String idcod = Leer.pedirCadena();

                try {
                    Statement statement = conn.createStatement();
                    ResultSet rs = statement
                            .executeQuery("SELECT * FROM cliente where codigo_cliente = " + idcod + "; ");
                    while (rs.next()) {

                        String id = rs.getString("codigo_cliente");

                        String name = rs.getString("nombre_cliente");

                        String contacname = rs.getString("nombre_contacto");

                        String contacapell = rs.getString("apellido_contacto");

                        String tel = rs.getString("telefono");

                        String fax = rs.getString("fax");

                        String direccion = rs.getString("linea_direccion1");

                        String ciudad = rs.getString("ciudad");

                        String region = rs.getString("region");

                        String pais = rs.getString("pais");

                        String cp = rs.getString("codigo_postal");

                        System.out.println(id + " " + name + " " + contacname + " " + contacapell + " " + tel + " "
                                + fax + " " + direccion + " " + ciudad + " " + region + " " + pais + " " + cp);

                    }

                } catch (Exception e) {

                }

                App.main(args);
                break;

            case 3:

                ResultSet rs = null;
                try {
                    Statement statement = conn.createStatement();
                    rs = statement.executeQuery("Select * from cliente");

                    System.out.println("Aquí te muestro a todos los clientes de nuestra base de datos.");

                    while (rs.next()) {

                        String id = rs.getString("codigo_cliente");
                        System.out.print(id);
                        String name = rs.getString("nombre_cliente");
                        System.out.println("\t" + name);

                    }

                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace(); //
                }

                App.main(args);

                break;

            case 4:

                break;

            case 5:

                break;

            default:
                break;
        }

    }
}
