package Datos;

import Usuarios.Administrador;
import Usuarios.Cliente;
import Usuarios.Vendedor;

public class Main {

    private static BaseDeDatos baseDeDatos;

    public static void main(String[] args) {
        boolean salida = true;
        baseDeDatos = new BaseDeDatos();

         Sistema sistema = new Sistema(baseDeDatos);

        do{
         salida = sistema.ingresarAlMenu(sistema.menuDeBusqueda());
      }while(salida);
    }
}
