package es.erica.ejercicioroom.equipos.room;


import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class EquipoConJugadores {
    @Embedded public Equipo equipo;
    @Relation(
            parentColumn = "uid",
            entityColumn = "uidEquipo"
    )
    public List<Jugador> jugadores;
}
