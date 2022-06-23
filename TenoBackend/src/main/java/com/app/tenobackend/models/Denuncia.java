package com.app.tenobackend.models;

public class Denuncia {
    private Integer id;
    private Integer iddenunciante;
    private Integer iddenunciado;
    private Integer idfiscal;
    private String descripcion;
    private String state;

    public Denuncia(Integer id, Integer iddenunciante, Integer iddenunciado, Integer idfiscal, String descripcion, String state){
        this.id = id;
        this.iddenunciante = iddenunciante;
        this.iddenunciado = iddenunciado;
        this.idfiscal = idfiscal;
        this.descripcion = descripcion;
        this.state = state;
    }

    public Integer getId(){return this.id;}
    public Integer getIddenunciante(){return this.iddenunciante;}
    public Integer getIddenunciado(){return this.iddenunciado;}
    public Integer getIdfiscal(){return this.idfiscal;}
    public String getDescripcion(){return this.descripcion;}
    public String getState(){return this.state;}

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIddenunciado(Integer iddenunciado) {
        this.iddenunciado = iddenunciado;
    }

    public void setIddenunciante(Integer iddenunciante) {
        this.iddenunciante = iddenunciante;
    }

    public void setIdfiscal(Integer idfiscal) {
        this.idfiscal = idfiscal;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setState(String state) {
        this.state = state;
    }
}
