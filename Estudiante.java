import java.io.Serializable;

public class Estudiante implements Serializable {
    private static final long serialVersionUID = 1234567L;
    private int id;
    private String nombre;

    public Estudiante(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
}