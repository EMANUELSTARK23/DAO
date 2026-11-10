// Archivo: EstudianteDAOArchivo.java
import java.io.*;
import java.util.ArrayList;
import java.util.List;
 
public class EstudianteDAOArchivo implements DAO<Estudiante> {
    private final String archivoRuta = "estudiantes_uaemex.dat";
 
    @Override
    public void guardar(Estudiante est) {
        List<Estudiante> lista = obtenerTodos();
        lista.add(est);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoRuta))) {
            oos.writeObject(lista);
        } catch (IOException e) { e.printStackTrace(); }
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Estudiante> obtenerTodos() {
        File f = new File(archivoRuta);
        if (!f.exists()) return new ArrayList<Estudiante>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            return (List<Estudiante>) ois.readObject();
        } catch (Exception e) { return new ArrayList<Estudiante>(); }
    }
}