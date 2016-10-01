package com.jose.mascotas.db;

/**
 * Created by XI318865 on 01/10/2016.
 */
public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TBL_MASCOTA           = "mascota";
    public static final String TBL_MASCOTA_ID        = "id";
    public static final String TBL_MASCOTA_NOMBRE    = "nombre";
    public static final String TBL_MASCOTA_FOTO      = "foto";

    public static final String TBL_LIKESMASCOTA              = "mascota_likes";
    public static final String TBL_LIKESMASCOTA_ID           = "id";
    public static final String TBL_LIKESMASCOTA_ID_MASCOTA   = "id_mascota";
    public static final String TBL_LIKESMASCOTA_NUMERO_LIKES = "likes";
}
