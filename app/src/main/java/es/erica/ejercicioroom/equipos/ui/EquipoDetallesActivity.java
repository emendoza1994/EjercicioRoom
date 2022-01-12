package es.erica.ejercicioroom.equipos.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import es.erica.ejercicioroom.R;

public class EquipoDetallesActivity extends AppCompatActivity {

    private TextView nombreEquipo, nombreJugadores;
    private ImageView imgEquipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo_detalles);
        nombreEquipo = findViewById(R.id.tvNombreEquipo);
        nombreJugadores = findViewById(R.id.tvJugadoresLista);
        imgEquipo = findViewById(R.id.ivEquipo);

    }
}