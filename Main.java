public class Main {
    public static void main(String[] args) {
        DAO<Estudiante> estudianteDAO = new EstudianteDAOArchivo();

        Estudiante nuevoEstudiante = new Estudiante(2324495, "Emanuel García");
        estudianteDAO.guardar(nuevoEstudiante);

        for (Estudiante e : estudianteDAO.obtenerTodos()) {
            System.out.println("ID: " + e.getId() + " | Nombre: " + e.getNombre());
        }
    }
}