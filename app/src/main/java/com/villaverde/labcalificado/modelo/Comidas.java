package com.villaverde.labcalificado.modelo;

public class Comidas {
    private String id;
    private String fullname;
    private String number;
    private String picture;
    private String email;
    private String descripcion;
    private String direccion;
    private String categoria;
    private String url;

    public Comidas() {
    }

    public Comidas(String id, String fullname, String number, String picture, String email, String descripcion, String direccion, String categoria, String url) {
        this.id = id;
        this.fullname = fullname;
        this.number = number;
        this.picture = picture;
        this.email = email;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.categoria = categoria;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Comidas{" +
                "id='" + id + '\'' +
                ", fullname='" + fullname + '\'' +
                ", number='" + number + '\'' +
                ", picture='" + picture + '\'' +
                ", email='" + email + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", direccion='" + direccion + '\'' +
                ", categoria='" + categoria + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

