package Datos;

import Menu.MenuBDAdministrador;
import Servicios.*;
import Usuarios.Administrador;
import Usuarios.Cliente;
import Usuarios.Usuario;
import Usuarios.Vendedor;

import java.util.ArrayList;
import java.util.List;

public  class BaseDeDatos implements MenuBDAdministrador {

        private List<Vendedor> vendedores;
        private List<Cliente> clientes;
        private List<Administrador> administradores;
        private List<Servicios> servicios;
        private List<Sucursal> sucursales;

     public BaseDeDatos(){
       clientes = new ArrayList<>();
       vendedores = new ArrayList<>();
       administradores = new ArrayList<>();
       servicios = new ArrayList<Servicios>();
       sucursales = new ArrayList<Sucursal>();
      //*****************************************************************************************************
      //se agrega un ADMINISTRADOR PARA PODER GENERAR TODOS LOS RECURSOS INICIALMENTE LUEGO PODRÁ ELIMINARSE
       //  this.agregarUnAdministrador(new Administrador("Admin","1234") );
         administradores.add(new Administrador("Admin","1234"));
         vendedores.add( new Vendedor("Maria","Juarez","Mar","1234") );
         clientes.add( new Cliente("Pedro","Paez","TPP001",
                 1234567,"Manuel Oviedo 123","PEDROP","1234"));

     }


     public List<Sucursal> obtenerSucursales() {

         return this.sucursales;
     }

     public List<Cliente> obtenerClientes(){
         return this.clientes ;
     }

     public List<Vendedor> obtenerVendedores(){
         return   this.vendedores;
     }

    @Override
    public List<Servicios> obtenerServicios() {
        return this.servicios;
    }

    @Override
    public void agregarUnCliente(Cliente cliente) {
          clientes.add(cliente);
    }

    public List<Administrador> obtenerAdministradores() {
             return this.administradores;
    }

    @Override
    public void agregarUnAdministrador(Administrador admin) {
        administradores.add(admin);
    }

    @Override
    public void agregarUnVendedor(Vendedor vendedor) {
       vendedores.add(vendedor);
    }

    @Override
    public void generarUnaReserva(Usuario usuario, String codigo) {

    }

    @Override
    public void eliminarUnaReserva(Usuario usuario, String codigo) {

    }

    @Override
    public void consultarReservasDisponibles() {

    }

    @Override
    public void consultarLaReserva(String nombre, String apellido) {

    }

    @Override
    public String consultarCodCliente() {
        return "";
    }

    @Override
    public void leerBD(BaseDeDatos baseDeDatos) {
    }

    private boolean verificarCredencial(String usuario){
        if((administradores== null) || administradores.isEmpty() ){
            return false;
        }else{
            for( Usuario admin : administradores ){
                if( admin.obtenerUsuario() == usuario){
                    return true;
                }
            }
        }
        System.out.println("Credencial no valida");
        return false;
    }
}
