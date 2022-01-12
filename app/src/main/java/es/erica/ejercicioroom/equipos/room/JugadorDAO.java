package es.erica.ejercicioroom.equipos.room;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface JugadorDAO {

    @Query("INSERT INTO Jugador (dorsal,  posicion,  nombre,  uidEquipo) VALUES (:dorsal, :posicion, :nombre, :uidEquipo)")
    void insertarJugador(String dorsal, String posicion, String nombre, int uidEquipo);
}
