/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Representante extends Candidato {

    private Estudiante formula;

    public Representante(Estudiante formula, String nombre, String apellido, int grado, String grupo, String lema, int numTarjeton, int cantVotos) {
        super(nombre, apellido, grado, grupo, lema, numTarjeton, cantVotos);
        this.formula = formula;
    }

    public Estudiante getFormula() {
        return formula;
    }

    public void setFormula(Estudiante formula) {
        this.formula = formula;
    }

    @Override
    public String toString() {
        return super.toString() + "\n Fórmula: " + formula;
    }

}
