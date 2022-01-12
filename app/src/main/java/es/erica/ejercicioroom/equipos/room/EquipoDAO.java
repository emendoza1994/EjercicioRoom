package es.erica.ejercicioroom.equipos.room;


import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;


@Dao
public interface EquipoDAO {
    @Query("SELECT * FROM Equipo")
    List<Equipo> obtenerEquipos();

    @Query("SELECT * FROM Equipo WHERE uid=:uid")
    EquipoConJugadores obtenerEquiposConJugadores(int uid);

    @Query("INSERT INTO Equipo (uid, equipo, logo) VALUES (:uid, :equipo, :logo)")
    void insertarEquipo(int uid, String equipo, int logo);

}
