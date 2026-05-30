/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Votante {

    private String nombre;
    private String id;
    private boolean votoPerso;
    private boolean votoRepre;
    
    public Votante(String nombre, String id){
        this.nombre = nombre;
        this.id = id;
    }

    public Votante(String nombre, String id, boolean votoPerso, boolean votoRepre) {
        this.nombre = nombre;
        this.id = id;
        this.votoPerso = votoPerso;
        this.votoRepre = votoRepre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isVotoPerso() {
        return votoPerso;
    }

    public void setVotoPerso(boolean votoPerso) {
        this.votoPerso = false;
    }

    public boolean isVotoRepre() {
        return votoRepre;
    }

    public void setVotoRepre(boolean votoRepre) {
        this.votoRepre = false;
    }

    

}
