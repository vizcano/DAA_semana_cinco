package com.jose.mascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jose.mascotas.model.Mascota;

import java.util.ArrayList;

/**
 * Created by XI318865 on 01/10/2016.
 */
public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTabla = "CREATE TABLE " + ConstantesBaseDatos.TBL_MASCOTA + "(" +
                ConstantesBaseDatos.TBL_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TBL_MASCOTA_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TBL_MASCOTA_FOTO + " INTEGER" +
                ")";

        String queryCrearTablaLikes = "CREATE TABLE " + ConstantesBaseDatos.TBL_LIKESMASCOTA + "(" +
                ConstantesBaseDatos.TBL_LIKESMASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TBL_LIKESMASCOTA_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDatos.TBL_LIKESMASCOTA_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TBL_LIKESMASCOTA_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesBaseDatos.TBL_MASCOTA + "(" + ConstantesBaseDatos.TBL_MASCOTA_ID + ")" +
                ")";

        db.execSQL(queryCrearTabla);
        db.execSQL(queryCrearTablaLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TBL_MASCOTA);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TBL_LIKESMASCOTA);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TBL_MASCOTA ;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TBL_LIKESMASCOTA_NUMERO_LIKES+") as likes " +
                                " FROM " + ConstantesBaseDatos.TBL_LIKESMASCOTA +
                                " WHERE " + ConstantesBaseDatos.TBL_LIKESMASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);

            if (registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }else {
                mascotaActual.setLikes(0);
            }

            mascotas.add(mascotaActual);
        }

        db.close();

        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TBL_MASCOTA,null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TBL_LIKESMASCOTA, null, contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;
        String query = "SELECT COUNT("+ConstantesBaseDatos.TBL_LIKESMASCOTA_NUMERO_LIKES+")" +
                        " FROM " + ConstantesBaseDatos.TBL_LIKESMASCOTA +
                        " WHERE " + ConstantesBaseDatos.TBL_LIKESMASCOTA_ID_MASCOTA + "="+mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();
        return likes;
    }

    public void borrarBD(){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(ConstantesBaseDatos.TBL_LIKESMASCOTA,"",null);
        db.delete(ConstantesBaseDatos.TBL_MASCOTA, "",null);
        db.close();
    }

    public ArrayList<Mascota> obtenerTop5Mascotas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT m.*, COUNT(ml." + ConstantesBaseDatos.TBL_LIKESMASCOTA_NUMERO_LIKES +  ") "+
                        "FROM " + ConstantesBaseDatos.TBL_MASCOTA + " as m, " +
                                ConstantesBaseDatos.TBL_LIKESMASCOTA + " as ml " +
                        "WHERE ml." + ConstantesBaseDatos.TBL_LIKESMASCOTA_ID_MASCOTA + " = m." + ConstantesBaseDatos.TBL_MASCOTA_ID + " " +
                        "GROUP BY m." + ConstantesBaseDatos.TBL_MASCOTA_ID + " " +
                        "ORDER BY COUNT(ml." + ConstantesBaseDatos.TBL_LIKESMASCOTA_NUMERO_LIKES + ") DESC LIMIT 5";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));
            mascotaActual.setLikes(registros.getInt(3));
            mascotas.add(mascotaActual);
        }

        db.close();

        return mascotas;
    }
}