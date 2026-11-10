import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAOMySQL implements DAO<Estudiante> {
    private static final String URL = "jdbc:mysql://localhost:3306/universidad_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = ""; // Credencial por defecto en XAMPP

    @Override
    public void guardar(Estudiante est) {
        String sql = "INSERT INTO estudiantes (id, nombre) VALUES (?, ?)";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstat = con.prepareStatement(sql)) {
            pstat.setInt(1, est.getId());
            pstat.setString(2, est.getNombre());
            pstat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Estudiante> obtenerTodos() {
        List<Estudiante> lista = new ArrayList<>(); // Colección dinámica
        String sql = "SELECT id, nombre FROM estudiantes";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstat = con.prepareStatement(sql);
             ResultSet rs = pstat.executeQuery()) {
            while (rs.next()) {
                lista.add(new Estudiante(rs.getInt("id"), rs.getString("nombre")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}