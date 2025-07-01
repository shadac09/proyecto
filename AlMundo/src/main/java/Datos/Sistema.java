package Datos;

import Usuarios.Administrador;
import Usuarios.Cliente;
import Usuarios.Usuario;
import Usuarios.Vendedor;
import Menu.StrategyMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema implements Busqueda,StrategyMenu {

    private Usuario usuario;
    private BaseDeDatos baseDeDatos;
    Scanner datos;
    String dato;
    public Sistema(BaseDeDatos baseDeDatos){

       this.baseDeDatos = baseDeDatos;
       datos = new Scanner(System.in);
       dato = "";
    }
    public boolean ingresarAlMenu(StrategyMenu strategyMenu){
       try{
           strategyMenu.menuUsuario();
       }catch (Exception exception){
           System.out.println("INGRESE UN NUEVO USUARIO");
           return true;
       }
       return false;
    }
    public Usuario buscarUsuario( String u ){

        List<Cliente> clientes = baseDeDatos.obtenerClientes();
        if(clientes != null){
        for( Cliente cliente : clientes){
            if(cliente.obtenerUsuario().equals(u)){
               if( gestionarClave(u, cliente) )
                   return cliente;
            }
        }}

        List<Vendedor> vendedores = baseDeDatos.obtenerVendedores();
        if(vendedores != null){
        for( Vendedor vendedor : vendedores){
            if(vendedor.obtenerUsuario().equals(u)) {
                if (gestionarClave(u, vendedor))
                    return vendedor;
            }
            }}

        List<Administrador> administradores = baseDeDatos.obtenerAdministradores();
        if(administradores != null){
        for( Administrador administrador : administradores){
            if(administrador.obtenerUsuario().equals( u)) {
                if (gestionarClave(u, administrador))
                    return administrador;
            }
        }}
       System.out.println(" NO SE ENCONTRÓ USUARIO ");
        return null;
    }

    @Override
    public StrategyMenu menuDeBusqueda() {
        String cadena="";
        menuUsuario();
        cadena = datos.next();
        return  (StrategyMenu)buscarUsuario(cadena);
    }

    public boolean gestionarClave( String usuario , Usuario u ){
        System.out.println("**  INGRESE LA CONTRASEÑA : ");
        int cont=3;
        do{ dato = datos.next();
            if(u.obtenerClave().equals( dato)) {
                System.out.println("**  BIENVENID@ "+usuario);
                return true;
            }else{System.out.println("CLAVE INCORRECTA\n");
                cont--;
            }
        }while( cont>0 );
        return false;
    }
    @Override
    public void menuUsuario() {
        System.out.println("*,******************************************************************");
        System.out.println("**   MENU DE INGRESO                                              **");
        System.out.println("*,******************************************************************");
        System.out.print("**   INGRESE NOMBRE DE USUARIO  : ");
    }

    //---------------------------------------------------------------------------------------------

}
