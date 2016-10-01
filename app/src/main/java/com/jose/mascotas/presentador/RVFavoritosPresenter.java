package com.jose.mascotas.presentador;

import android.content.Context;
import android.util.Log;

import com.jose.mascotas.fragment.IRVFavoritosView;
import com.jose.mascotas.model.ConstructorMascotas;
import com.jose.mascotas.model.Mascota;

import java.util.ArrayList;

public class RVFavoritosPresenter implements IRVFavoritosPresenter {

    private IRVFavoritosView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RVFavoritosPresenter(IRVFavoritosView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasFavoritas();
    }

    @Override
    public void obtenerMascotasFavoritas() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerTop5Mascotas();
        mostrarMascotasFavoritasRV();
    }


    @Override
    public void mostrarMascotasFavoritasRV() {
        Log.e("RVFavoritosPresenter", "mascotas: " + mascotas.size());
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
