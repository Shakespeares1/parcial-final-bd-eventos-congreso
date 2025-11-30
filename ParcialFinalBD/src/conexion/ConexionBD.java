package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/eventos_congreso?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";  // mi usuaario
    private static final String PASSWORD = "Tupapazzxx123";  // mi contraseña

    public static Connection conectar() {
        Connection conexion = null;

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a MySQL");

        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el Driver JDBC de MySQL");
        } catch (SQLException e) {
            System.out.println("Error conectando a MySQL: " + e.getMessage());
        }

        return conexion;
    }
}
