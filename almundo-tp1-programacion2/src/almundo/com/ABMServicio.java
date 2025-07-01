/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package almundo.com;
import static almundo.com.VerificarDato.*;
import static almundo.com.VistaConsola.*;
/**
 *
 * @author Ariel Risoluto.
 */
public class ABMServicio implements MenuAdministrador {

    @Override
    public void menu(BaseDeDatos baseDeDatos) {
        int opcion;
        
        opcion = leerNro("1) ALTA DE VUELO\n"+
                "--SALIR 0--\n"+
                "Igrese el nro de la opcion deseada:");
        
        switch (opcion) {
            case 1:
                altaServicioVuelo(baseDeDatos);
                break;
 
        }
    }
    //COMPLETAR . . . . . . . .  .
    private void altaServicioVuelo(BaseDeDatos baseDeDatos) {
        int opc2;
        boolean validar = false;
        boolean comprobarUsuario = false;
        String nombreEmpresa = "";
        String tipoDeServicio = "";
        String origen = "";
        String destino = "";
        int plazasTotales = 0;

        do {
            mostrarTexto("-SISTEMA DE VUELOS-\n");
            
            opc2 = leerNro("Ingresar/Corregir datos -1- terminar -0-: ");
                if(opc2 == 1){
                    try {
                        nombreEmpresa = leerString("ingrese el nombre: ");
                        tipoDeServicio = leerString("ingrese el tipo de sercivio: ");//ver si se pude hacer con un enum
                        origen = leerString("ingrese el origen: ");
                        destino = leerString("ingrese el destino: ");
                        plazasTotales = leerNro("Ingrese las nro de plazas totales: ");
                    } catch (Exception e) {
                            mostrarTexto("se ingresando un tipo de dato inconrrecto");
                    }
                        
                    if((validarIngreso(nombreEmpresa) || validarIngreso(tipoDeServicio) || validarIngreso(origen) || validarIngreso(destino) || validarIngreso(plazasTotales) || comprobarUsuario)){
                        validar = true;
                    }else{
                        Servicio vuelo = new Vuelo(origen, destino, plazasTotales, plazasTotales, plazasTotales, tipoDeServicio, nombreEmpresa, tipoDeServicio);
                        baseDeDatos.getServicio().add(vuelo);
                    }
                }
        }while(validar && opc2!=0);
    }
    //COMPLETAR . . . . . . . .  .
    
    private void bajaServicioVuelo(){}
    
    private void altaServicioHotel(){}
    
    private void bajaServicioHotel(){}
}
