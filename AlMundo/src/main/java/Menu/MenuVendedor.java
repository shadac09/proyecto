package Menu;


import Usuarios.Usuario;

/**
 * @author Diego A. Cesarin
 */

public interface MenuVendedor extends MenuCliente , MenuBDVendedor{

   public void generarUnaReserva(Usuario usuario, String codigo );
   public void eliminarUnaReserva( Usuario usuario , String codigo);

   public void consultarReservasDisponibles( );

}
