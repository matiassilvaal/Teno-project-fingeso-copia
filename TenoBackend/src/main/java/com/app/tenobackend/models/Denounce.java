package com.app.tenobackend.models;

public class Denounce {
    private Integer id;
    private Integer iddenunciante;
    private Integer iddenounced;
    private Integer idfiscal;
    private String descripcion;
    private String state;

    public Denounce(Integer id, Integer iddenunciante, Integer iddenounced, Integer idfiscal, String descripcion, String state){
        this.id = id;
        this.iddenunciante = iddenunciante;
        this.iddenounced = iddenounced;
        this.idfiscal = idfiscal;
        this.descripcion = descripcion;
        this.state = state;
    }

    public Integer getId(){return this.id;}
    public Integer getIddenunciante(){return this.iddenunciante;}
    public Integer getIddenounced(){return this.iddenounced;}
    public Integer getIdfiscal(){return this.idfiscal;}
    public String getDescripcion(){return this.descripcion;}
    public String getState(){return this.state;}

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIddenounced(Integer iddenounced) {
        this.iddenounced = iddenounced;
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
