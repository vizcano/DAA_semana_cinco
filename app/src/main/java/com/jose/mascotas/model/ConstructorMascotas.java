package com.jose.mascotas.model;

import android.content.ContentValues;
import android.content.Context;

import com.jose.mascotas.R;
import com.jose.mascotas.db.BaseDatos;
import com.jose.mascotas.db.ConstantesBaseDatos;

import java.util.ArrayList;

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);
        if(db.obtenerTodasLasMascotas().size() == 0){
            insertarMascotas(db);
        }

        return  db.obtenerTodasLasMascotas();
    }

    public ArrayList<Mascota> obtenerTop5Mascotas() {
        BaseDatos db = new BaseDatos(context);

        if(db.obtenerTodasLasMascotas().size() == 0){
            insertarMascotas(db);
        }

        return  db.obtenerTop5Mascotas();
    }

    public void insertarMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        String[] nomMascotas = new String[]{"Perro","Gato","Gallina","Oveja","Cerdo"};
        int[] imgMascotas = new int[]{R.drawable.bulldog, R.drawable.cat,R.drawable.hen,
                R.drawable.sheep, R.drawable.pig};

        for(int i = 0; i < nomMascotas.length; i++){
            contentValues.put(ConstantesBaseDatos.TBL_MASCOTA_NOMBRE, nomMascotas[i]);
            contentValues.put(ConstantesBaseDatos.TBL_MASCOTA_FOTO, imgMascotas[i]);
            db.insertarMascota(contentValues);
        }
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TBL_LIKESMASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TBL_LIKESMASCOTA_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }
}