package com.example.practicainventada;

import java.util.ArrayList;

public class Persona {
    private String nombre;
    private String sexo;
    private int edad;
    private ArrayList<String> hobies;
    private String urlFoto;

    public Persona(String nombre, String sexo, int edad, ArrayList<String> hobies,String urlFoto) {
        this.hobies=new ArrayList<>();
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.hobies = hobies;
        this.urlFoto=urlFoto;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<String> getHobies() {
        return hobies;
    }

    public void setHobies(ArrayList<String> hobies) {
        this.hobies = hobies;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", sexo='" + sexo + '\'' +
                ", edad=" + edad +
                ", urlFoto='" + urlFoto + '\'' +
                '}';
    }
}
