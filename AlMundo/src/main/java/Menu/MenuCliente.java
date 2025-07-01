package Menu;


import Usuarios.Usuario;

import java.util.List;

public  interface MenuCliente extends MenuBDCliente{

   public void consultarLaReserva( String nombre , String apellido);

   public String consultarCodCliente();

}
