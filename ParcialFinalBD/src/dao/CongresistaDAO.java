package dao;

import conexion.ConexionBD;
import modelo.Congresista;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CongresistaDAO {

    // INSERTAR
    public boolean insertar(Congresista c) {
        String sql = "INSERT INTO congresista(nombre, apellido, email, pais, institucion) VALUES(?,?,?,?,?)";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getPais());
            ps.setString(5, c.getInstitucion());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error INSERTANDO congresista: " + e.getMessage());
            return false;
        }
    }

    // ACTUALIZAR
    public boolean actualizar(Congresista c) {
        String sql = "UPDATE congresista SET nombre=?, apellido=?, email=?, pais=?, institucion=? WHERE id_congresista=?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getPais());
            ps.setString(5, c.getInstitucion());
            ps.setInt(6, c.getId_congresista());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error ACTUALIZANDO congresista: " + e.getMessage());
            return false;
        }
    }

    // ELIMINAR
    public boolean eliminar(int id) {
        String sql = "DELETE FROM congresista WHERE id_congresista=?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error ELIMINANDO congresista: " + e.getMessage());
            return false;
        }
    }

    // LISTAR TODOS
    public List<Congresista> listar() {
        List<Congresista> lista = new ArrayList<>();
        String sql = "SELECT * FROM congresista";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Congresista c = new Congresista(
                    rs.getInt("id_congresista"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("email"),
                    rs.getString("pais"),
                    rs.getString("institucion")
                );
                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Error LISTANDO congresistas: " + e.getMessage());
        }

        return lista;
    }

    // BUSCAR POR ID
    public Congresista buscar(int id) {
        String sql = "SELECT * FROM congresista WHERE id_congresista=?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Congresista(
                    rs.getInt("id_congresista"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("email"),
                    rs.getString("pais"),
                    rs.getString("institucion")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error BUSCANDO congresista: " + e.getMessage());
        }
        return null;
    }
}
