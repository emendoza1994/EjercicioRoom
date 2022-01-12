package es.erica.ejercicioroom.equipos.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Jugador {

public Jugador(String dorsal, String posicion, String nombre, int uidEquipo){
    this.dorsal=dorsal;
    this.posicion=posicion;
    this.nombre = nombre;
    this.uidEquipo = uidEquipo;
}
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "nombre")
    public String nombre;

    @ColumnInfo(name = "dorsal")
    public String dorsal;

    @ColumnInfo(name = "posicion")
    public String posicion;

    @ColumnInfo(name = "uidEquipo")
    public int uidEquipo;



}
