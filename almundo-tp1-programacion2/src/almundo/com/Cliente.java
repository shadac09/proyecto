/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package almundo.com;

import java.text.ParseException;
import static almundo.com.VistaConsola.*;
import java.util.ArrayList;

/**
 *
 * @author Ariel Risoluto.
 */
public class Cliente extends Usuario implements MenuCliente {
    
    private ArrayList<Servicio> servicioContrado;
    private ArrayList<Sucursal> sucursalElejida;
    private int pasajesTuristaReservados;
    private int pasajesPrimeraReservados;
    private int habitacionesReservadas;
    private Usuario usuarioActul;
    
    public Cliente(String nombre, String apellido, String id_user, String Password, int Dni, String mail) throws ParseException {
        super(nombre, apellido, id_user, Password, Dni, mail);
        servicioContrado = new ArrayList<Servicio>();
        sucursalElejida = new ArrayList<Sucursal>();
        pasajesPrimeraReservados = 0;
        pasajesTuristaReservados = 0;
        habitacionesReservadas = 0;
    }

    public ArrayList<Servicio> getServicioContrado() {
        return servicioContrado;
    }

    public ArrayList<Sucursal> getSucursalElejida() {
        return sucursalElejida;
    }

   
    public int getHabitacionesReservadas() {
        return habitacionesReservadas;
    }

    public void setHabitacionesReservadas(int habitacionesReservadas) {
        this.habitacionesReservadas = habitacionesReservadas;
    }

    public int getPasajesTuristaReservados() {
        return pasajesTuristaReservados;
    }

    public void setPasajesTuristaReservados(int pasajesTuristaReservados) {
        this.pasajesTuristaReservados = pasajesTuristaReservados;
    }

    public int getPasajesPrimeraReservados() {
        return pasajesPrimeraReservados;
    }

    public void setPasajesPrimeraReservados(int pasajesPrimeraReservados) {
        this.pasajesPrimeraReservados = pasajesPrimeraReservados;
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
                    "1) VER DATOS DE MI USUARIO\n"
                    + "0) CERRAR SESION\n"
                    + "Ingrese el nro de opcion deseada: ");

            switch (opcion) {

                case 1:
                    baseDeDatos.mostrarDatosUsuario(usuarioActul);
                    break;
                    
                case 2:
                    consultar(new ConsultaCliente(), baseDeDatos);
                    break;

                case 0:
                default:
                    mostrarTexto("\n--Se ha cerrado la sesion--\n");
                    entrada = false;
                    break;
            }

        }
    }
    
    private void consultar(MenuCliente trabajar, BaseDeDatos baseDeDatos) {
        trabajar.menu(baseDeDatos);
    }
    
}
