package com.jose.mascotas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.jose.mascotas.adaptador.MascotaFavoritaAdaptador;
import com.jose.mascotas.fragment.IRVFavoritosView;
import com.jose.mascotas.model.Mascota;
import com.jose.mascotas.presentador.IRVFavoritosPresenter;
import com.jose.mascotas.presentador.RVFavoritosPresenter;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity implements IRVFavoritosView {

    private RecyclerView rvFavMascotas;
    private IRVFavoritosPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar miActionBar =  (Toolbar) findViewById(R.id.appBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvFavMascotas = (RecyclerView) findViewById(R.id.rvFavMascotas);
        presenter = new RVFavoritosPresenter(this, this);
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvFavMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaFavoritaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaFavoritaAdaptador adaptador = new MascotaFavoritaAdaptador(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaFavoritaAdaptador adaptador) {
        rvFavMascotas.setAdapter(adaptador);
    }
}
