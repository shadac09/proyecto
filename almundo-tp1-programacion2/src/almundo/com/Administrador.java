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
public class Administrador extends Usuario implements MenuAdministrador {

    private Usuario usuarioActul;

    public Administrador(String nombre, String apellido, String id_user, String Password, int Dni, String mail) throws ParseException {
        super(nombre, apellido, id_user, Password, Dni, mail);
    }

    @Override
    public boolean inciarSesion(BaseDeDatos baseDeDatos, Usuario usuarioActul) {
        this.usuarioActul = usuarioActul;
        mostrarTexto("Bienvenido Admin: " + usuarioActul.nombre);
        menu(baseDeDatos);

        return false;
    }

    @Override
    public void menu(BaseDeDatos baseDeDatos) {

        int opcion = 0;
        boolean entrada = true;

        while (entrada) {
            opcion = leerNro(
                    "1) ABM DE USUARIOS INTERNOS\n"
                    + "2) ABM DE CLIENTES\n"
                    + "3) ABM DE SERVICIOS\n"
                    + "4) ABM DE SUCURSALES\n"
                    + "5) VER DATOS DE MI USUARIO\n"
                    + "0) CERRAR SESION\n"
                    + "Ingrese el nro de opcion deseada: ");

            switch (opcion) {
                case 1:
                    administrar(new ABMUsuarios(), baseDeDatos);
                    break;

                case 2:
                    administrar(new AMBCliente(), baseDeDatos);

                    break;

                case 3:
                    administrar(new ABMServicio(), baseDeDatos);
                    break;
                    
                case 4:
                    administrar(new ABMSurcursal(), baseDeDatos);
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

    private void administrar(MenuAdministrador trabajar, BaseDeDatos baseDeDatos) {
        trabajar.menu(baseDeDatos);
    }

}
