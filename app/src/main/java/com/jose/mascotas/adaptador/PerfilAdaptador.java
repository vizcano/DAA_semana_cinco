package com.jose.mascotas.adaptador;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.jose.mascotas.R;
import com.jose.mascotas.model.Mascota;

import java.util.List;

import static android.support.v7.widget.RecyclerView.Adapter;
import static android.support.v7.widget.RecyclerView.ViewHolder;

/**
 * Created by XI318865 on 01/10/2016.
 */
public class PerfilAdaptador extends Adapter<PerfilAdaptador.MascotaViewHolder> {

    List<Mascota> mascotas;
    Activity activity;

    public PerfilAdaptador(List<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    public static class MascotaViewHolder extends ViewHolder{

        private ImageView imgFoto;
        private TextView tvLikesCV;
        private ImageButton btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvLikesCV = (TextView) itemView.findViewById(R.id.tvLikesCV);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, final int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.tvLikesCV.setText("" + mascota.getLikes());

        holder.btnLike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mascota.setLikes(mascota.getLikes()+1);
                holder.tvLikesCV.setText("" + mascota.getLikes());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

}
