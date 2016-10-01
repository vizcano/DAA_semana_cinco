package com.jose.mascotas.fragment;

import com.jose.mascotas.adaptador.MascotaAdaptador;
import com.jose.mascotas.model.Mascota;

import java.util.ArrayList;

/**
 * Created by XI318865 on 01/10/2016.
 */
public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> contactos);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
