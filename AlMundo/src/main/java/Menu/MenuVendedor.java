package Menu;

import Servicios.Servicios;
import Usuarios.Usuario;

import java.util.List;

public interface MenuVendedor extends MenuCliente , MenuBDVendedor{

   public void generarUnaReserva(Usuario usuario, String codigo );
   public void eliminarUnaReserva( Usuario usuario , String codigo);

   public void consultarReservasDisponibles( );

}
