/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package almundo.com;

import java.text.ParseException;
import static almundo.com.VistaConsola.*;
/**
 *
 * @author Ariel Risoluto.
 */
public class Vendedor extends Usuario implements MenuVendedor{
    
    private Usuario usuarioActul;
    
    public Vendedor(String nombre, String apellido, String id_user, String Password, int Dni, String mail) throws ParseException {
        super(nombre, apellido, id_user, Password, Dni, mail);
    }


    @Override
    public boolean inciarSesion(BaseDeDatos baseDeDatos,Usuario usuarioActul) {
        this.usuarioActul = usuarioActul;
        mostrarTexto("Bienvenido Vendedor: " + usuarioActul.nombre);
        menu(baseDeDatos);

        return false;
    }

    @Override
    public void menu(BaseDeDatos baseDeDatos) {
        int opcion = 0;
        boolean entrada = true;

        while (entrada) {
            opcion = leerNro(
                    "1) ABM DE CLIENTES\n"
                    + "5) VER DATOS DE MI USUARIO\n"
                    + "0) CERRAR SESION\n"
                    + "Ingrese el nro de opcion deseada: ");

            switch (opcion) {

                case 2:
                    vender(new AMBCliente(), baseDeDatos);
                    break;
                    
                case 5:
                    baseDeDatos.mostrarDatosUsuario(usuarioActul);
                    break;

                case 0:
                default:
                    mostrarTexto("\n--Se ha cerrado la sesion--\n");
                    entrada = false;
                    break;
            }

        }
    }
    
    private void vender(MenuVendedor trabajar, BaseDeDatos baseDeDatos) {
        trabajar.menu(baseDeDatos);
    }


}
