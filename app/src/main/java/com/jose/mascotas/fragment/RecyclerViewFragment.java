package com.jose.mascotas.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jose.mascotas.R;
import com.jose.mascotas.adaptador.MascotaAdaptador;
import com.jose.mascotas.model.Mascota;
import com.jose.mascotas.presentador.IRecylerViewFragmentPresenter;
import com.jose.mascotas.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XI318865 on 01/10/2016.
 */
public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{
    List<Mascota> mascotas;
    private RecyclerView rvMascotas;
    MascotaAdaptador adaptador;
    private IRecylerViewFragmentPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        /*listaContactos = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this,2);


        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();*/

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());

        return v;
    }

    /*public void inicializarListaContactos(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.perro1,"Juan"));
        mascotas.add(new Mascota(R.drawable.perro2,"Andres"));
        mascotas.add(new Mascota(R.drawable.perro3,"Miriam"));
        mascotas.add(new Mascota(R.drawable.arana,"Roberto"));
        mascotas.add(new Mascota(R.drawable.canario,"Luis"));
        mascotas.add(new Mascota(R.drawable.cerdo,"Diana"));
        mascotas.add(new Mascota(R.drawable.conejo,"Jose"));
        mascotas.add(new Mascota(R.drawable.gato,"Henry"));
        mascotas.add(new Mascota(R.drawable.pez,"Juana"));
        mascotas.add(new Mascota(R.drawable.tortuga,"Carlos"));

    }

    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas,getActivity());
        rvMascotas.setAdapter(adaptador);
    };*/

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
}
