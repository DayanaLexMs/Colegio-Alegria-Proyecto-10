/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.JFElecciones;
import java.util.ArrayList;
import modelo.Candidato;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Votante;
import modelo.Personero;
import modelo.Representante;
import modelo.Estudiante;
import modelo.Mascota;
import modelo.Tipo;

/**
 *
 * @author USUARIO
 */
public class ControladorElecciones implements ActionListener {

    private JFElecciones frmElecciones;
    private ArrayList<Candidato> listaCandidatos;
    private ArrayList<Votante> listaVotantes;
    private ArrayList<Estudiante> listaEstudiantes;
    private ArrayList<Mascota> listaMascotas;
    private Votante votanteActual;

    public ControladorElecciones(JFElecciones frmElecciones) {
        this.frmElecciones = frmElecciones;
        this.listaCandidatos = new ArrayList<>();
        this.listaVotantes = new ArrayList<>();
        this.listaEstudiantes = new ArrayList<>();
        this.listaMascotas = new ArrayList<>();
        mostrarMensajeInicio();
        deshabilitarInicio();
        registrarEstudianteF();
        registrarMascota();
        registrarCanRepres();
        registrarCanPersos();

        this.frmElecciones.btnRegistrar.addActionListener(this);
        this.frmElecciones.btnPersonero.addActionListener(this);
        this.frmElecciones.btnRepre.addActionListener(this);
        this.frmElecciones.btnVotarP.addActionListener(this);
        this.frmElecciones.btnVotarR.addActionListener(this);
        this.frmElecciones.cmbPersos.addActionListener(this);
        this.frmElecciones.cmbRepres.addActionListener(this);
        this.frmElecciones.btnCerrarVot.addActionListener(this);
        this.frmElecciones.btnElectos.addActionListener(this);

        this.frmElecciones.pack(); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frmElecciones.btnRegistrar) {
            System.out.println("Sí sirve, bro");
            registrarVotante();
        }
        if (e.getSource() == this.frmElecciones.btnPersonero) {
            habilitarVotPersonero();
        }
        if (e.getSource() == this.frmElecciones.btnRepre) {
            habilitarVotRepresentante();
        }
        if (e.getSource() == this.frmElecciones.btnVotarP) {
            realizarVotacionPersonero();
        }
        if (e.getSource() == this.frmElecciones.btnVotarR) {
            realizarVotacionRepre();
        }
        if (e.getSource() == this.frmElecciones.cmbPersos) {
            mostrarInfoPerso();
        }
        if (e.getSource() == this.frmElecciones.cmbRepres) {
            mostrarInfoRepre();
        }
        if (e.getSource() == this.frmElecciones.btnCerrarVot) {
            cerrarVotaciones();
        }
        if (e.getSource() == this.frmElecciones.btnElectos) {
            mostrarGanadores();
        }

    }

    private void mostrarMensajeInicio() {
        JOptionPane.showMessageDialog(frmElecciones, "Bienvenido a las elecciones de personería y representante");
        JOptionPane.showMessageDialog(frmElecciones, "A continuación se le dará paso a realizar su proceso de votación");

    }

    public void registrarVotante() {
        String nombre = this.frmElecciones.txtNombreVot.getText();
        String id = this.frmElecciones.txtId.getText();

        if (nombre.isEmpty() || id.isEmpty()) {
            JOptionPane.showMessageDialog(frmElecciones, "CAMPOS INCOMPLETOS, LLENE TODO");
            return;
        }
        if (this.validarIdentidadVot(id)) {
            return;
        }
        Votante v = new Votante(nombre, id);
        this.listaVotantes.add(v);
        this.votanteActual = v;
        JOptionPane.showMessageDialog(frmElecciones, "REGISTRADO CON ÉXITO, VAYA A VOTAR");
        this.frmElecciones.panelEscogerTipoVoto.setVisible(true);
        this.frmElecciones.btnRepre.setEnabled(true);
        this.frmElecciones.btnPersonero.setEnabled(true);
        this.frmElecciones.btnCerrarVot.setVisible(true);
        this.frmElecciones.pack(); 

    }

    public void habilitarVotPersonero() {
        if (votanteActual.isVotoPerso()) {
            JOptionPane.showMessageDialog(frmElecciones, "YA HA VOTADO");
            return;
        }
        this.frmElecciones.panelPersonero.setVisible(true);
        this.frmElecciones.pack(); 
    }

    public void habilitarVotRepresentante() {

        if (votanteActual.isVotoRepre()) {
            JOptionPane.showMessageDialog(frmElecciones, "YA HA VOTADO");
            return;
        }
        this.frmElecciones.panelRepresentante.setVisible(true);
        this.frmElecciones.pack(); // ← AJUSTAR TAMAÑO
    }

    public boolean validarIdentidadVot(String id) {
        if (!this.listaVotantes.isEmpty()) {
            for (Votante v : listaVotantes) {
                if (v.getId().equalsIgnoreCase(id)) {
                    JOptionPane.showMessageDialog(frmElecciones, "ESTE ESTUDIANTE YA HA VOTADO");
                    return true;
                }
            }
        }
        return false;
    }

    private void deshabilitarInicio() {
        this.frmElecciones.panelEscogerTipoVoto.setVisible(false);
        this.frmElecciones.panelPersonero.setVisible(false);
        this.frmElecciones.panelRepresentante.setVisible(false);
        this.frmElecciones.btnCerrarVot.setVisible(false);
        this.frmElecciones.panelResumen.setVisible(false);
    }

    private void registrarEstudianteF() {
        listaEstudiantes.add(new Estudiante("Lucia"));
        listaEstudiantes.add(new Estudiante("Pedro"));

    }

    private void registrarMascota() {
        Mascota m1 = new Mascota("1", "pepe", "Macho", "4", "Grande y feo", Tipo.ACUATICO);
        listaMascotas.add(m1);
        Mascota m2 = new Mascota("2", "pepa", "Hembra", "17", "Prosti", Tipo.TERRESTRE);
        listaMascotas.add(m2);

    }

    private void registrarCanPersos() {
        Personero p1 = new Personero(listaMascotas.get(0), "Andrés", "López", 11, "A", "Algún lema", 46, 0);
        listaCandidatos.add(p1);
        this.frmElecciones.cmbPersos.addItem(p1.getNombre() + " " + p1.getApellido());
        Personero p2 = new Personero(listaMascotas.get(1), "Carlos", "Ospina", 11, "B", "Otro lema", 47, 0);
        listaCandidatos.add(p2);
        this.frmElecciones.cmbPersos.addItem(p2.getNombre() + " " + p2.getApellido());

    }

    private void registrarCanRepres() {

        Representante r1 = new Representante(listaEstudiantes.get(0), "Ian", "Carrillo", 2, "A", "Firmes por la paja", 01, 0);
        listaCandidatos.add(r1);
        this.frmElecciones.cmbRepres.addItem(r1.getNombre() + " " + r1.getApellido());
        Representante r2 = new Representante(listaEstudiantes.get(1), "Fabian", "Diaz", 3, "B", "Firmes por la patria", 02, 0);
        listaCandidatos.add(r2);
        this.frmElecciones.cmbRepres.addItem(r2.getNombre() + " " + r2.getApellido());

    }

    //Para los dos casos
    private void mostrarInfoPerso() {
        System.out.println("mostrarInfoPerso ejecutado");
        String seleccionadoP = this.frmElecciones.cmbPersos.getSelectedItem().toString();
        if (seleccionadoP == null || seleccionadoP.equalsIgnoreCase("VOTO EN BLANCO")) {
            this.frmElecciones.txtInfoCanP.setText(" ");
            return;
        }
        for (Candidato c : listaCandidatos) {
            if (c instanceof Personero && (c.getNombre() + " " + c.getApellido()).equals(seleccionadoP)) {
                this.frmElecciones.txtInfoCanP.setText(c.toString());
            }
        }
    }

    private void mostrarInfoRepre() {
        System.out.println("mostrarInfoRepre ejecutado");
        String cursorR = this.frmElecciones.cmbRepres.getSelectedItem().toString();
        if (cursorR == null || cursorR.equalsIgnoreCase("VOTO EN BLANCO")) {
            this.frmElecciones.txtInfoCanR.setText(" ");
            return;
        }
        for (Candidato c : listaCandidatos) {
            if (c instanceof Representante && (c.getNombre() + " " + c.getApellido()).equals(cursorR)) {
                this.frmElecciones.txtInfoCanR.setText(c.toString());
            }
        }
    }

    private void realizarVotacionRepre() {
        int votosBlanco = 0;
        if (this.frmElecciones.cmbRepres.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(frmElecciones, "VOTE POR ALGUNA DE LAS OPCIONES");
            return;

        }
        String selectedR = this.frmElecciones.cmbRepres.getSelectedItem().toString();
        //Validación pa no votar otra vez
        if (votanteActual.isVotoRepre()) {
            JOptionPane.showMessageDialog(frmElecciones, "YA HA VOTADO");
            return;
        }
        if (selectedR.equals("VOTO EN BLANCO")) {
            votanteActual.setVotoRepre(true);
            votosBlanco++;
            JOptionPane.showMessageDialog(frmElecciones, "VOTO EN BLANCO REGISTRADO");

        } else {
            for (Candidato c : listaCandidatos) {
                if (c instanceof Representante && (c.getNombre() + " " + c.getApellido()).equalsIgnoreCase(selectedR)) {
                    c.setCantVotos(c.getCantVotos() + 1);
                    System.out.println("✅ Voto para REPRESENTANTE: " + c.getNombre() + " " + c.getApellido() + " → Total: " + c.getCantVotos());
                    votanteActual.setVotoRepre(true);
                    JOptionPane.showMessageDialog(frmElecciones, "VOTO REGISTRADO");

                    break;
                }
            }

        }
        this.frmElecciones.panelRepresentante.setVisible(false);
        this.frmElecciones.btnRepre.setEnabled(false);
        this.frmElecciones.pack(); 
        mostrarInfoRepre();
    }

    private void realizarVotacionPersonero() {
        int votosBlanco = 0;
        if (this.frmElecciones.cmbPersos.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(frmElecciones, "VOTE POR ALGUNA DE LAS OPCIONES");
            return;

        }
        String selectedP = this.frmElecciones.cmbPersos.getSelectedItem().toString();
        //Validación pa no votar otra vez
        if (votanteActual.isVotoPerso()) {
            JOptionPane.showMessageDialog(frmElecciones, "YA HA VOTADO");
            return;
        }
        if (selectedP.equals("VOTO EN BLANCO")) {
            votanteActual.setVotoPerso(true);
            votosBlanco++;
            JOptionPane.showMessageDialog(frmElecciones, "VOTO EN BLANCO REGISTRADO");

        } else {
            for (Candidato c : listaCandidatos) {
                if (c instanceof Personero && (c.getNombre() + " " + c.getApellido()).equalsIgnoreCase(selectedP)) {
                    c.setCantVotos(c.getCantVotos() + 1);
                    System.out.println("✅ Voto para PERSONERO: " + c.getNombre() + " " + c.getApellido() + " → Total: " + c.getCantVotos());
                    votanteActual.setVotoPerso(true);
                    JOptionPane.showMessageDialog(frmElecciones, "VOTO REGISTRADO");

                    break;
                }
            }

        }
        this.frmElecciones.panelPersonero.setVisible(false);
        this.frmElecciones.btnPersonero.setEnabled(false);
        this.frmElecciones.pack(); // ← AJUSTAR TAMAÑO
        mostrarInfoPerso();
    }

    private void cerrarVotaciones() {
        this.frmElecciones.panelInfoVot.setVisible(false);
        this.frmElecciones.panelEscogerTipoVoto.setVisible(false);
        this.frmElecciones.panelResumen.setVisible(true);
        this.frmElecciones.btnCerrarVot.setVisible(false);
        this.frmElecciones.pack(); // ← AJUSTAR TAMAÑO
    }

    private void mostrarGanadores() {
        //Ganador de Repre
        Representante electoR = null;
        if (!this.listaCandidatos.isEmpty()) {
            for (Candidato c : listaCandidatos) {
                if (c instanceof Representante) {
                    Representante r = (Representante) c;
                    if (electoR == null || r.getCantVotos() > electoR.getCantVotos()) {
                        electoR = r;

                    }
                }
            }
        }
        //Ganador de Perso
        Personero electoP = null;
        if (!this.listaCandidatos.isEmpty()) {
            for (Candidato c : listaCandidatos) {
                if (c instanceof Personero) {
                    Personero p = (Personero) c;
                    if (electoP == null || p.getCantVotos() > electoP.getCantVotos()) {
                        electoP = p;

                    }
                }
            }
        }
        //Ganadores
        String cad = " -PERSONERO-" + "\n \n " + electoP.getNombre() + " " + electoP.getApellido()
                + "\n \n -REPRESENTANTE-" + "\n \n" + electoR.getNombre() + " " + electoR.getApellido();
        this.frmElecciones.txtResumen.setText(cad);

        this.frmElecciones.pack(); 
    }
}
