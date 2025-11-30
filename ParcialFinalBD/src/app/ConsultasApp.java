package app;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasApp {

    public static void main(String[] args) {

        // Consulta 1: Listar todos los congresistas
        ejecutarConsulta("SELECT nombre, apellido, email FROM congresista", 
                "Consulta 1: Listado de todos los congresistas");

        // Consulta 2: Contar cuántos congresistas están registrados
        ejecutarConsulta("SELECT COUNT(*) AS total FROM congresista", 
                "Consulta 2: Total de congresistas");

        // Consulta 3: Mostrar solo los congresistas de Colombia
        ejecutarConsulta("SELECT nombre, apellido FROM congresista WHERE pais = 'Colombia'", 
                "Consulta 3: Congresistas de Colombia");

        // Consulta 4: Ordenar congresistas por apellido
        ejecutarConsulta("SELECT nombre, apellido FROM congresista ORDER BY apellido ASC", 
                "Consulta 4: Congresistas ordenados por apellido");

        // Consulta 5: Buscar congresistas por institución
        ejecutarConsulta("SELECT nombre, apellido, institucion FROM congresista WHERE institucion = 'Universidad de Cartagena'", 
                "Consulta 5: Congresistas de la Universidad de Cartagena");
    }

    public static void ejecutarConsulta(String sql, String descripcion) {

        System.out.println("\n------------------------------");
        System.out.println(descripcion);
        System.out.println("------------------------------");

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            int columnas = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columnas; i++) {
                    System.out.print(rs.getString(i) + " | ");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("Error ejecutando consulta: " + e.getMessage());
        }
    }
}
