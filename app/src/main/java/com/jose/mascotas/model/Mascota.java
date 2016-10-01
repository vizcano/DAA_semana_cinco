package com.jose.mascotas.model;

/**
 * Created by XI318865 on 01/10/2016.
 */
public class Mascota {
    private int id;
    private String nombre;
    private int foto;
    private int likes;

    public Mascota(){}

    public Mascota(int foto, String nombre, int likes){
        this.foto = foto;
        this.nombre = nombre;
        this.likes = likes;
    }

    public Mascota(int foto, String nombre){
        this.foto = foto;
        this.nombre = nombre;
        this.likes = 0;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
