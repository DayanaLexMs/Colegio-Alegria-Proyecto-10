/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Personero extends Candidato {

    private Mascota mascota;

    public Personero(Mascota mascota, String nombre, String apellido, int grado, String grupo, String lema, int numTarjeton, int cantVotos) {
        super(nombre, apellido, grado, grupo, lema, numTarjeton, cantVotos);
        this.mascota = mascota;
    }
    
    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    @Override
    public String toString() {
        return super.toString() + "\n Mascota: " + mascota ;
    }
    
    
}
