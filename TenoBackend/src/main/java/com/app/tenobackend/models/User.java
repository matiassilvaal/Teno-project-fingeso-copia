package com.app.tenobackend.models;

public class User{
    private Integer id;
    private String correo;

    public User(Integer id, String correo){
        this.id = id;
        this.correo = correo;
    }
    public Integer getId() {return this.id;}
    public void setId(Integer id){this.id = id;}
    public String getCorreo(){return this.correo;}
    public void setCorreo(String name){this.correo = name;}
}