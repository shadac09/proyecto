/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package almundo.com;

import static almundo.com.VerificarDato.validarIngreso;
import static almundo.com.VistaConsola.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 *
 * @author Ariel Risoluto.
 */
public class AMBCliente implements MenuVendedor, MenuAdministrador {

    @Override
    public void menu(BaseDeDatos baseDeDatos) {

        int opcion = 0;
        boolean entrada = true;
        String idUser;
        Usuario user;

        while (entrada) {   
            mostrarTexto("-SISTEMA DE GESTION DE CLIENTES-\n");
            opcion = leerNro(
                  "1) ALTA DE CLIENTE\n"
                + "2) ASIGNAR RESERVA A CLIENTE\n"
                + "0) SALIR DE MENU\n"
                + "Ingrese el nro de la opcion deseada:");
            
            switch (opcion) {
                case 1:
                    altaCliente(baseDeDatos);
                    break;
                case 2:
                    idUser = leerString("ingrese el id de usaurios para asignar una reserva: ");

                    user = baseDeDatos.buscarPorTipoDeUsuario(idUser, "almundo.com.Cliente");//crea constantes para no pasar los tipos de clase asi
                    if (user == null) {
                        mostrarTexto("\n---El usaurio " + idUser + "no existe  o no es un cliente---\n");
                    } else {
                        asignarReserva(baseDeDatos, (Cliente) user);
                        asignarSucursal(baseDeDatos, (Cliente) user);
                    }
                    break;
                case 0:
                default:
                    entrada = false;
                    break;
            }
        }
    }

    private void altaCliente(BaseDeDatos baseDeDatos) {
        int opc1;
        boolean validar = false;
        boolean comprobarUsuario = false;
        String nombre = "";
        String apellido = "";
        String idUser = "";
        String password = "";
        String email = "";
        int dni = 0;

        do {
            mostrarTexto("-SISTEMA DE ALTA DE CLIENTES-\n");

            opc1 = leerNro("Ingresar/Corregir datos -1- terminar -0-: ");
            if (opc1 == 1) {
                try {
                    nombre = leerString("ingrese el nombre: ");
                    apellido = leerString("ingrese el apellido: ");
                    idUser = leerString("ingrese el ID User: ");
                    password = leerString("ingrese el password: ");
                    dni = leerNro("Ingrese el DNI: ");
                } catch (Exception e) {
                    mostrarTexto("se ingresando un tipo de dato inconrrecto");
                }

                if ((validarIngreso(nombre) || validarIngreso(apellido) || validarIngreso(idUser) || validarIngreso(password) || validarIngreso(dni) || comprobarUsuario)) {
                    validar = true;
                } else if (baseDeDatos.buscarUsuario(idUser) != null) {
                    mostrarTexto("\n---el usuario ya se encuentra registrado---\n");
                    comprobarUsuario = true;
                } else if (!comprobarUsuario) {
                    try {
                        Usuario p = new Cliente(nombre, apellido, idUser, password, dni, email);
                        baseDeDatos.getPersona().add(p);
                    } catch (ParseException ex) {
                        Logger.getLogger(AMBCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        } while (validar && opc1 != 0);

    }

    private void asignarReserva(BaseDeDatos baseDeDatos, Cliente user) {

        String idService;
        int opc1;
        int cantidad;
        boolean confirmar;
        Class<?> clase;

        mostrarTexto("-ASIGNACION DE RESERVAS-\n");
        
        baseDeDatos.mostrarDatosServicios();
        idService = leerString("Ingrese el id del servicio a asiganar");

        Servicio service = baseDeDatos.buscarServicio(idService);
        
        confirmar = siNo("¿ DESEA CONFIRMAR LA ASIGNACION DEL SERVICIO ? \n ingrese solo si o no por favor");
        
        if (confirmar && service != null) {
            user.getServicioContrado().add(service);
            // restar plaza disponible
            clase = service.getClass();
            if(clase.getName().equals("almundo.com.Vuelo")){
                Vuelo serVuelo = (Vuelo) service;
                opc1 = leerNro("\nSeleccione el tipo asisento: \n"
                                + "1) Clase Turista\n"
                                +"2) Clase Primera\n"
                                +"Ingrese el nro de la opcion deseada:");
                switch(opc1){
                
                    case 1:
                        cantidad = leerNro("elija la cantidad de asientos que requiera");
                        serVuelo.modificarPlazasTuristas(cantidad);
                        user.setPasajesTuristaReservados(cantidad);
                        break;
                    case 2:
                        cantidad = leerNro("elija la cantidad de asientos que requiera");
                        serVuelo.modificarPlazasPrimera(cantidad);
                        user.setPasajesPrimeraReservados(cantidad);
                        break;
                }
                
            }else if(clase.getName().equals("almundo.com.Hotel")){
                Hotel serHotel= (Hotel) service;
                cantidad = leerNro("elija la cantidad de habitaciones que requiera:");
                serHotel.modificarPlazas(cantidad);
                user.setHabitacionesReservadas(cantidad);
            }else{
                mostrarTexto("SERVICIO DESCONOCIDO");
            }
            
            mostrarTexto("\nSE REALIZO LA RESERVA DEL SERVICIO: " + idService);
   
        } else if(!confirmar) {
            mostrarTexto("\nOPERACION CANCELADA\n");
        }else{
            mostrarTexto("\nSERVICIO NO ENCONTRADO\n");
        }
    }
    
    private void asignarSucursal(BaseDeDatos baseDeDatos, Cliente user){
        
        String elegirSucursal;
        boolean confirmar;
        
        baseDeDatos.mostrarDatosSucursales();
        elegirSucursal = leerString("Elija la sucursal para el retiro y pago de la reserva: ");
            
        Sucursal suc = baseDeDatos.buscarSucursal(elegirSucursal);
        
        confirmar = siNo("¿ DESEA CONFIRMAR LA SUCURSAL ? \n ingrese solo si o no por favor");
            
        if(confirmar && suc != null){
            user.getSucursalElejida().add(suc);
            mostrarTexto("\nLUGAR DE RETIRO: " + suc.getDireccion());
                
        }else if(!confirmar){
            mostrarTexto("\nOPERACION CANCELADA\n");
        }else{
            mostrarTexto("\nSUCURSAL NO ENCONTRADA\n");
        }
    }

}
