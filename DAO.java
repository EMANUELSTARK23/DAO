import java.util.List;

public interface DAO<T> {
    void guardar(T entidad);
    List<T> obtenerTodos();
}