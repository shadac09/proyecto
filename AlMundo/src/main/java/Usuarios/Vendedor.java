package Usuarios;

import Datos.BaseDeDatos;
import Menu.MenuVendedor;
import Menu.StrategyMenu;
import Servicios.Servicios;

import java.util.List;

public class Vendedor extends Usuario implements MenuVendedor, StrategyMenu {

    private String nombre ;
    private String apellido;
    private String idUsuario ;
    private String clave;
    private BaseDeDatos baseDeDatos;

    public Vendedor(String nombre, String apellido, String idUsuario, String clave){
        this.nombre = nombre;
        this.apellido = apellido;
        this.idUsuario = idUsuario;
        this.clave = clave;
    }

    @Override
    public void menuUsuario() {
        System.out.println("MENU VENDEDOR");

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
    public String obtenerUsuario() {
        return this.idUsuario;
    }

    @Override
    public String obtenerClave() {
        return this.clave;
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return this.baseDeDatos.obtenerClientes();
    }

    @Override
    public List<Vendedor> obtenerVendedores() {
        return this.baseDeDatos.obtenerVendedores();
    }

    @Override
    public List<Servicios> obtenerServicios() {
        return this.baseDeDatos.obtenerServicios( );
    }

    @Override
    public void agregarUnCliente(Cliente cliente) {
        this.baseDeDatos.agregarUnCliente(cliente);
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
        this.baseDeDatos = baseDeDatos;
    }
}
