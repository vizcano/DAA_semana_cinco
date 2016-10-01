package com.jose.mascotas.fragment;

import com.jose.mascotas.adaptador.MascotaFavoritaAdaptador;
import com.jose.mascotas.model.Mascota;

import java.util.ArrayList;

/**
 * Created by XI318865 on 01/10/2016.
 */

public interface IRVFavoritosView {

    public void generarLinearLayoutVertical();

    public MascotaFavoritaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaFavoritaAdaptador adaptador);
}
