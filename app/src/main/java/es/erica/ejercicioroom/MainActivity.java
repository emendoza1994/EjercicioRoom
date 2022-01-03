package es.erica.ejercicioroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import es.erica.ejercicioroom.room.AppDatabase;
import es.erica.ejercicioroom.room.Usuario;

public class MainActivity extends AppCompatActivity {

    private AppDatabase db;

    private Button btnGuardar, btnVerTodos;
    private TextView tvUsuarios;
    private TextInputEditText etNombre, etApellidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarRoom();
        inicializarComponentes();
        cargarUsuarios();

    }
    private void inicializarComponentes(){
        btnGuardar = findViewById(R.id.btnGuardar);
        btnVerTodos = findViewById(R.id.btnVerTodos);
        tvUsuarios = findViewById(R.id.tvUsuarios);
        etNombre = findViewById(R.id.textNombre);
        etApellidos = findViewById(R.id.textApellido);
    }
    private void inicializarRoom(){
          db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "usuarios-db").allowMainThreadQueries().build();
    }
    private void cargarUsuarios(){
        List<Usuario> usuarios = db.usuarioDAO().getAll();
        tvUsuarios.setText("");
        for (Usuario usuario: usuarios) {
            String textoAnterior = tvUsuarios.getText().toString();
            tvUsuarios.setText(textoAnterior+"\n"+usuario.nombre+" "+usuario.apellidos);

        }
    }
    private void insertarUsuario(){
        String nombre = etNombre.getText().toString();
        String apellidos = etApellidos.getText().toString();

        if(TextUtils.isEmpty(nombre)  || TextUtils.isEmpty(apellidos)){
            Toast.makeText(this, "Debes de indicar nombre y apellido", Toast.LENGTH_SHORT).show();
        }else{
            db.usuarioDAO().insertarUsuario(nombre, apellidos);
            Toast.makeText(this, "Usuario insertado", Toast.LENGTH_SHORT).show();
            etNombre.setText("");
            etApellidos.setText("");
            cargarUsuarios();
        }
    }

    public void guardar(View view) {
        insertarUsuario();
    }

    public void verTodos(View view) {
        cargarUsuarios();
    }
}