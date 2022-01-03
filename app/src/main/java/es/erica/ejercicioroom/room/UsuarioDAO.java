package es.erica.ejercicioroom.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UsuarioDAO {
    @Query("SELECT * FROM Usuario")
    List<Usuario> getAll();

    @Query("SELECT * FROM Usuario WHERE uid IN (:userIds)")
    List<Usuario> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM Usuario WHERE apellidos LIKE :apellido LIMIT 1")
    Usuario buscarPorApellido(String apellido);

    @Query("INSERT INTO Usuario (nombre, apellidos) VALUES (:nombre, :apellido)")
    void insertarUsuario(String nombre, String apellido);

}
