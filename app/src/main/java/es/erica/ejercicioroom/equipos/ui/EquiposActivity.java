package es.erica.ejercicioroom.equipos.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import es.erica.ejercicioroom.R;
import es.erica.ejercicioroom.equipos.data.DataEquipos;
import es.erica.ejercicioroom.equipos.room.AppDatabaseEquipos;
import es.erica.ejercicioroom.equipos.room.Equipo;
import es.erica.ejercicioroom.equipos.room.EquipoConJugadores;
import es.erica.ejercicioroom.equipos.room.Jugador;
import es.erica.ejercicioroom.room.AppDatabase;

public class EquiposActivity extends AppCompatActivity {

    private RecyclerView rvEquipos;
    private EquipoAdapter equipoAdapter;
    private AppDatabaseEquipos dbEquipos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos);
        rvEquipos = findViewById(R.id.rvEquipos);
        inicializamosRoom();
    }
    private void inicializamosAdaptador(List<Equipo> equipos){
        //Inicializamos el adaptador con la base de datos fake y el contexto
        equipoAdapter = new EquipoAdapter(equipos,this);
        equipoAdapter.setClickItemEquipo(new EquipoAdapter.ClickItemEquipo() {
            @Override
            public void onClickItem(int position, View view) {
                Equipo equipo = equipos.get(position);
                EquipoConJugadores equipoJugadores = dbEquipos.equipoDAO().obtenerEquiposConJugadores(equipo.uid);

                String jugadoresInfo = "Jugadores de "+equipo.equipo;
                for (Jugador j: equipoJugadores.jugadores
                     ) {
                    jugadoresInfo = jugadoresInfo+"\n"+j.nombre+"|"+j.dorsal+"|"+j.posicion;
                }
                Toast.makeText(getApplicationContext(), jugadoresInfo, Toast.LENGTH_SHORT).show();
            }
        });
        //Le añadimos la recycler el adaptador.
        rvEquipos.setAdapter(equipoAdapter);
    }

    private void inicializamosRoom(){
        //Creamos la base de datos
        dbEquipos=  Room.databaseBuilder(getApplicationContext(),
                AppDatabaseEquipos.class, "equipos-db").allowMainThreadQueries().build();

        //Obtenemos la lista de equipos
        List<Equipo> equiposRoom = dbEquipos.equipoDAO().obtenerEquipos();
        //Si esta vacía porque es la primera vez cargamos los datos desde el archivo local
        if( equiposRoom.size() == 0 ){
            List<Equipo> equiposData = DataEquipos.getDataEquipos();
            for (Equipo e: equiposData
                 ) {
                dbEquipos.equipoDAO().insertarEquipo(e.uid, e.equipo, e.logo);
                List<Jugador> jugadoresData = DataEquipos.generarJugadoresEquipo(e.uid);
                for (Jugador j: jugadoresData
                     ) {
                    dbEquipos.jugadorDAO().insertarJugador(j.dorsal, j.posicion,j.nombre, e.uid);
                }
            }
            inicializamosAdaptador(equiposData);
        }else{
            //Si existen datos en Room cargamos los datos desde Room
            inicializamosAdaptador(equiposRoom);
        }
    }

}