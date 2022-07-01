package com.app.tenobackend.models;

public class Denounce {
    private Integer id;
    private Integer iddenunciante;
    private Integer iddenounced;
    private Integer idfiscal;
    private String description;
    private String state;
    private String security;

    public Denounce(Integer id, Integer iddenunciante, Integer iddenounced, Integer idfiscal, String descripcion, String state, String security){
        this.id = id;
        this.iddenunciante = iddenunciante;
        this.iddenounced = iddenounced;
        this.idfiscal = idfiscal;
        this.description = descripcion;
        this.state = state;
        this.security = security;
    }

    public Integer getId(){return this.id;}
    public Integer getIddenunciante(){return this.iddenunciante;}
    public Integer getIddenounced(){return this.iddenounced;}
    public Integer getIdfiscal(){return this.idfiscal;}
    public String getDescription(){return this.description;}
    public String getState(){return this.state;}
    public String getSecurity(){return this.security;}

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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setState(String state) {
        this.state = state;
    }
    public void setSecurity(String security){this.security=security;}
}
