package es.erica.ejercicioroom.equipos.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import es.erica.ejercicioroom.room.Usuario;
import es.erica.ejercicioroom.room.UsuarioDAO;

@Database(entities = {Equipo.class, Jugador.class}, version = 1)
public abstract class AppDatabaseEquipos extends RoomDatabase {
    public abstract EquipoDAO equipoDAO();
    public abstract JugadorDAO jugadorDAO();
}
