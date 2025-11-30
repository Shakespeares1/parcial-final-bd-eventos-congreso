package app;

import dao.CongresistaDAO;
import modelo.Congresista;


public class TestCRUD {
    public static void main(String[] args) {

        CongresistaDAO dao = new CongresistaDAO();

        // INSERTAR
        Congresista nuevo = new Congresista(0, "Carlos", "López", "carlos.lopez2@example.com", "Chile", "UC");
        boolean insertado = dao.insertar(nuevo);
        System.out.println("Insertado: " + insertado);

        // LISTAR
        System.out.println("Listado de congresistas:");
        dao.listar().forEach(c -> {
            System.out.println(
                c.getId_congresista() + " - " +
                c.getNombre() + " " +
                c.getApellido() + " - " +
                c.getEmail()
            );
        });

        // BUSCAR POR ID
        Congresista buscado = dao.buscar(1);
        if (buscado != null) {
            System.out.println("Encontrado: " + buscado.getNombre());
        } else {
            System.out.println("No se encontró congresista con ID 1");
        }

        // ACTUALIZAR
        Congresista actualizar = new Congresista(1, "Ana", "Pérez", "ana.actualizada@example.com", "Colombia", "Unicartagena");
        boolean actualizado = dao.actualizar(actualizar);
        System.out.println("Actualizado: " + actualizado);

        // ELIMINAR
        boolean eliminado = dao.eliminar(3);
        System.out.println("Eliminado ID 3: " + eliminado);
    }
}
