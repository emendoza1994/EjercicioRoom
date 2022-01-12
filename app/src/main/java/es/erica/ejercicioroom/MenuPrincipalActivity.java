package es.erica.ejercicioroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import es.erica.ejercicioroom.equipos.ui.EquiposActivity;

public class MenuPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    public void clickRoomEquipos(View view) {
        Intent i=new Intent(this, EquiposActivity.class);
        startActivity(i);
    }

    public void clickRoomUsuarios(View view) {
        Intent i=new Intent(this, MainActivity.class);
        startActivity(i);
    }
}