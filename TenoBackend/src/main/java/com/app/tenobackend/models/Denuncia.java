package com.app.tenobackend.models;

public class Denuncia {
    private int id;
    private int iddenunciante;
    private int iddenunciado;
    private String descripcion;
    private String state;

    public Denuncia(int id, int iddenunciante, int iddenunciado,
                    String descripcion, String state){
        this.id = id;
        this.iddenunciante = iddenunciante;
        this.iddenunciado = iddenunciado;
        this.descripcion = descripcion;
        this.state = state;
    }
}
