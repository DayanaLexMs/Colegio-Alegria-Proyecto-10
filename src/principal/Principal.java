/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package principal;
import vista.JFElecciones;
import controlador.ControladorElecciones;

/**
 *
 * @author USUARIO
 */
public class Principal {

    public static void main(String[] args) {
        JFElecciones frmElecciones = new JFElecciones();
        ControladorElecciones cntr = new ControladorElecciones(frmElecciones);
        frmElecciones.setVisible(true);
        frmElecciones.setLocationRelativeTo(null);
    }
}
