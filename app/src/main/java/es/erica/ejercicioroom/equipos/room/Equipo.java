package es.erica.ejercicioroom.equipos.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Equipo {

    public Equipo(int uid, String equipo, int logo){
        this.uid = uid;
        this.equipo = equipo;
        this.logo=logo;
    }
    @PrimaryKey()
    @ColumnInfo(name = "uid")
    public int uid;

    @ColumnInfo(name = "equipo")
    public String equipo;

    @ColumnInfo(name = "logo")
    public int logo;

}
