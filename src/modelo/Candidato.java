/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Candidato {

    private String nombre;
    private String apellido;
    private int grado;
    private String grupo;
    private String lema;
    private int numTarjeton;
    private int cantVotos;

    public Candidato(String nombre, String apellido, int grado, String grupo, String lema, int numTarjeton, int cantVotos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.grado = grado;
        this.grupo = grupo;
        this.lema = lema;
        this.numTarjeton = numTarjeton;
        this.cantVotos = cantVotos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getLema() {
        return lema;
    }

    public void setLema(String lema) {
        this.lema = lema;
    }

    public int getNumTarjeton() {
        return numTarjeton;
    }

    public void setNumTarjeton(int numTarjeton) {
        this.numTarjeton = numTarjeton;
    }

    public int getCantVotos() {
        return cantVotos;
    }

    public void setCantVotos(int cantVotos) {
        this.cantVotos = cantVotos;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n Apellido: " + apellido + 
                "\n Grado: " + grado + "\n Grupo: " + grupo + "\n Lema: " + lema + 
                "\n Número de tarjetón: " + numTarjeton;
    }
    
    

}
