package es.erica.ejercicioroom.equipos.ui;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import es.erica.ejercicioroom.R;
import es.erica.ejercicioroom.equipos.room.Equipo;

public class EquipoAdapter extends RecyclerView.Adapter<EquipoAdapter.ViewHolder> {

    public List<Equipo> equiposLista;
    private Context context;
    private static ClickItemEquipo clickItemEquipo;


    /**
     * Nuestro adaptador se construye con la lista de datos (equipos) y el contexto para la carga de
     * imagenes.
     */
    public EquipoAdapter(List<Equipo> dataSet, Context contexto) {
        equiposLista = dataSet;
        context = contexto;
    }

    public void setClickItemEquipo(ClickItemEquipo clickItemEquipo) {
        this.clickItemEquipo = clickItemEquipo;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_equipo, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        //Por cada item que recojamos dibujamos en el textview el titulo
        viewHolder.nombreEquipo.setText(equiposLista.get(position).equipo);
        //Usamos a libreria glide para cargar imagenes desde la URL importante activar en el manifest
        //el permiso de internet
        Glide.with(context).load(context.getDrawable(equiposLista.get(position).logo)).into(viewHolder.logo);

    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return equiposLista.size();
    }

    /**
     * Creamos un ViewHolder que nos permite definir que componentes tendrá nuestro item
     * En nuestro caso una imagen para el poster y un textview para el titulo.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final ImageView logo;
        final TextView nombreEquipo;

        public ViewHolder(View view) {
            super(view);
            nombreEquipo = (TextView) view.findViewById(R.id.item_equipo_nombre);
            logo = (ImageView) view.findViewById(R.id.item_equipo_imagen);
            //Agregamos a este item la escucha del evento click
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickItemEquipo.onClickItem(getAdapterPosition(), view);
        }


    }

    /*Creamos nuestra interface que define el click del item*/
    public interface ClickItemEquipo {
        void onClickItem(int position, View view);
    }
}

