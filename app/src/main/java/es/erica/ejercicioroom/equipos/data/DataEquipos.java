package es.erica.ejercicioroom.equipos.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import es.erica.ejercicioroom.R;
import es.erica.ejercicioroom.equipos.room.Equipo;
import es.erica.ejercicioroom.equipos.room.Jugador;

public class DataEquipos {

    public static List<Equipo> getDataEquipos() {
        ArrayList<Equipo> equipos = new ArrayList<Equipo>();
        Collections.addAll(
                equipos,
                new Equipo(1,"Chicago Bulls", R.drawable.bulls),
                new Equipo(2,"Cleveland Cavaliers", R.drawable.cavaliers),
                new Equipo(3,"Dallas Mavericks", R.drawable.dallas),
                new Equipo(4,"Detroit Pistons", R.drawable.detroit),
                new Equipo(5,"Charlotte Hornets", R.drawable.hornets),
                new Equipo(6,"Brooklin Nets", R.drawable.nets),
                new Equipo(7,"Denver Nuggets", R.drawable.nuggets)
        );

        return equipos;
    }

    public static List<Jugador> generarJugadoresEquipo(int uidEquipo) {

        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

        for (int i = 0; i < 5; i++) {
            int dorsal = new Random().nextInt(99);

            jugadores.add(
                    new Jugador(dorsal + "", "Posicion " + i, "Jugador " + i, uidEquipo)
            );
        }

        return jugadores;
    }
}
