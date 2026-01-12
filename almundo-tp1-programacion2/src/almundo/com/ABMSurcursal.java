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
public class ABMSurcursal implements MenuAdministrador {

    @Override
    public void menu(BaseDeDatos baseDeDatos) {
        int opcion;
        
        opcion = leerNro(
                "1) ALTA DE SUCURSAL\n"+
                "2) BAJA DE SUCURSAL\n"+
                "--SALIR 0--\n"+
                "Ingrese el nro de la opcion deseada:");
        
        switch (opcion) {
            case 1:
                altaSucursal(baseDeDatos);
                break;
 
        }
    }
    //COMPLETAR . . . . . . . .  .
    private void altaSucursal(BaseDeDatos baseDeDatos) {
       int opc1;
        int opc2;
        boolean validar = false;
        boolean comprobarUsuario = false;
        String codSucursal = "";
        String direccion = "";
        int telefono = 0;

        do {
            mostrarTexto("-SISTEMA DE GESTION DE SUCURSALES-\n");
            
            opc2 = leerNro("Ingresar/Corregir datos -1- terminar -0-: ");
                if(opc2 == 1){
                    try {
                        codSucursal = leerString("ingrese el codigo de sucursal: ");
                        direccion = leerString("ingrese la direccion: ");
                        telefono = leerNro("Ingrese el telefono: ");
                    } catch (Exception e) {
                            mostrarTexto("se ingresando un tipo de dato inconrrecto");
                    }
                        
                    if((validarIngreso(codSucursal) || validarIngreso(direccion) || comprobarUsuario)){
                        validar = true;
                    }else{
                        Sucursal sucursal = new Sucursal(codSucursal, direccion, telefono);
                        baseDeDatos.getSucursal().add(sucursal);
                    }
                }
        }while(validar && opc2!=0);
    }
    //COMPLETAR . . . . . . . .  .
}
