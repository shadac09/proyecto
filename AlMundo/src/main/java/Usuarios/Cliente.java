package Usuarios;

import Datos.BaseDeDatos;
import Menu.MenuCliente;
import Menu.StrategyMenu;

import java.util.List;

public class Cliente extends  Usuario  implements MenuCliente, StrategyMenu {

   private String codigoTurista;
   private String nombre;
   private String apellido;
   private String direccion;
   private int telefono;
   private MenuCliente menuCliente;
   private String idUsuario;
   private String clave;
   private BaseDeDatos baseDeDatos;
   public Cliente(String nombre, String apellido, String codigoTurista, int telefono,
                  String direccion, String usuario, String clave){
       this.codigoTurista = codigoTurista;
       this.nombre = nombre;
       this.apellido = apellido;
       this.direccion = direccion;
       this.telefono = telefono;
       idUsuario = usuario;
       this.clave = clave;
   }
   @Override
   public void menuUsuario(){
       System.out.println("MENU CLIENTE");
   }
   public void datosDelCliente(){
       System.out.println(" USUARIO : "+ idUsuario + "  Código de Cliente :"+ codigoTurista);
       System.out.println(" Nombre  : "+ nombre+ "   Apellido : "+ apellido);
       System.out.println(" Dirección : "+ direccion + "   Teléfono : "+ telefono);
   }
   @Override
   public String obtenerUsuario(){
      return this.idUsuario;
   }
   @Override
   public String obtenerClave(){
       return this.clave;
   }

    @Override
    public void consultarLaReserva(String nombre, String apellido) {
        System.out.println("Consultando la reserva echa por el usuario "+ nombre + " "+ apellido);
    }

    @Override
    public String consultarCodCliente() {
        return "";
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return this.baseDeDatos.obtenerClientes();
    }

    @Override
    public void leerBD(BaseDeDatos baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }
}


