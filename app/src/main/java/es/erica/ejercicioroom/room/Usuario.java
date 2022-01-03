package es.erica.ejercicioroom.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Usuario {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "nombre")
    public String nombre;

    @ColumnInfo(name = "apellidos")
    public String apellidos;

}
