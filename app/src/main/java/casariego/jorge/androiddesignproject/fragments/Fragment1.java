package casariego.jorge.androiddesignproject.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;

import casariego.jorge.androiddesignproject.R;
import casariego.jorge.androiddesignproject.adapter.PeliculasAdapter;
import casariego.jorge.androiddesignproject.modelo.Pelicula;

/**
 * Cuando decidíamos utilizar un ListView ya sabemos que nuestros datos se representarían de forma
 * lineal con la posibilidad de hacer scroll en un sentido u otro, y en el caso de elegir un
 * GridView la representación sería tabular.
 *
 * Una vista de tipo RecyclerView por el contrario no determina por sí sola la forma en que se van
 * a mostrar en pantalla los elementos de nuestra colección, sino que va a delegar esa tarea a otro
 * componente llamado LayoutManager, que también tendremos que crear y asociar al RecyclerView para
 * su correcto funcionamiento.
 *
 * El SDK de Android incorpora 3 LayoutManagers para las 3 representaciones mas habituales
 * 1. Lista vertical y horizontal (LinearLayoutManager)
 * 2. Tabla Tradicional (GridLayoutManager)
 * 3. Tabla apilada o no alineada (StaggeredGridLayoutManager)
 *
 */
public class Fragment1 extends Fragment {

    private  RecyclerView recyclerView;
    private ArrayList<Pelicula> peliculas;

    public Fragment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_fragment1, container, false);

        //Inicializamos la lista de peliculas
        peliculas = new ArrayList<Pelicula>();
        for (int i=0; i<20; i++){
            peliculas.add(new Pelicula("Pelicula " + i, "Descripcion: sin descripcion"));
        }

        //Inicializamos el recycler View
        recyclerView = (RecyclerView) rootView.findViewById(R.id.lista_peliculas);
        // Esta llamada no es obligatoria pero es una manera de optimizar el recyclerView cuando
        // sabemos con certeza el tamaño de nuestro recyclerView
        recyclerView.setHasFixedSize(true);

        final PeliculasAdapter adapter = new PeliculasAdapter(peliculas);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        //Probar el resultado con el siguiente tipo de Layout
        //recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return rootView;
    }

}
