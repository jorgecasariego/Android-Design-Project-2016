package casariego.jorge.androiddesignproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import casariego.jorge.androiddesignproject.R;
import casariego.jorge.androiddesignproject.modelo.Pelicula;

/**
 * Created by jorgecasariego on 31/5/16.
 *
 * 1. Crear layout que almacenara el item de la pelicula
 * 2. Crear ViewHolder
 * 3. Extender PeliculasAdapter de RecyclerView.Adapter<PeliculasAdapter.PeliculasViewHolder>
 * 4. Crear arraylist de peliculas
 * 5. Crear constructor y recibir como parametro la lista de peliculas y setear
 * 6. Implementar onCreateViewHolder
 * 7. Implementar onBindViewHolder
 * 8. Implementar getItemCount
 *
 */
public class PeliculasAdapter extends RecyclerView.Adapter<PeliculasAdapter.PeliculasViewHolder>{
    private ArrayList<Pelicula> peliculas;

    public PeliculasAdapter(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    // Encargado de crear los nuevos objetos ViewHolder (Peliculas) necesarios para los elementos de la coleccion
    @Override
    public PeliculasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_pelicula, parent, false);

        PeliculasViewHolder pvh = new PeliculasViewHolder(itemView);

        return pvh;
    }

    // Encargado de actualizar los datos de un ViewHolder existente
    // Para ello obtenemos una pelicula en una posicion especifica
    @Override
    public void onBindViewHolder(PeliculasViewHolder holder, int position) {
        Pelicula item = peliculas.get(position);

        holder.bindPelicula(item);
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }


    public static class PeliculasViewHolder extends RecyclerView.ViewHolder {
        public TextView nombrePelicula;
        public TextView descripcionPelicula;

        public PeliculasViewHolder(View itemView) {
            super(itemView);

            nombrePelicula = (TextView) itemView.findViewById(R.id.nombre);
            descripcionPelicula = (TextView) itemView.findViewById(R.id.descripcion);
        }

        // Asigna el contenido de una pelicula
        public void bindPelicula(Pelicula p){
            nombrePelicula.setText(p.getNombre());
            descripcionPelicula.setText(p.getDescripcion());
        }
    }
}
