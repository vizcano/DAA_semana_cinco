package com.jose.mascotas.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jose.mascotas.R;
import com.jose.mascotas.adaptador.PerfilAdaptador;
import com.jose.mascotas.model.Mascota;

import java.util.ArrayList;

/**
 * Created by XI318865 on 01/10/2016.
 */
public class PerfilFragment extends Fragment {
    private ArrayList<Mascota> mascotas;
    private RecyclerView rvListaMascostas;
    PerfilAdaptador adaptador;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_perfil, container, false);

        rvListaMascostas = (RecyclerView) v.findViewById(R.id.rvDetalleMascota);
        GridLayoutManager glm = new GridLayoutManager(getContext(),3);
        rvListaMascostas.setLayoutManager(glm);
        inicializarListaContactos();
        inicializarAdaptador();

        return v;
    }

    public void inicializarListaContactos(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.bulldog,"Perro"));
        mascotas.add(new Mascota(R.drawable.cat,"Gato"));
        mascotas.add(new Mascota(R.drawable.hen,"Gallina"));
        mascotas.add(new Mascota(R.drawable.pig,"Cerdo"));
        mascotas.add(new Mascota(R.drawable.sheep,"Oveja"));
    }

    public void inicializarAdaptador(){
        adaptador = new PerfilAdaptador(mascotas,getActivity());
        rvListaMascostas.setAdapter(adaptador);
    };

}
