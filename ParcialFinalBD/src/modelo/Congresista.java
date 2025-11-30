package modelo;

public class Congresista {
    
    private int id_congresista;
    private String nombre;
    private String apellido;
    private String email;
    private String pais;
    private String institucion;

    public Congresista() {}

    public Congresista(int id_congresista, String nombre, String apellido, String email, String pais, String institucion) {
        this.id_congresista = id_congresista;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.pais = pais;
        this.institucion = institucion;
    }

    // Getters y setters
    public int getId_congresista() {
        return id_congresista;
    }

    public void setId_congresista(int id_congresista) {
        this.id_congresista = id_congresista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }
}
