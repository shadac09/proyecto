package Menu;
/**
 * @author Diego A. Cesarin
 */
import Usuarios.Cliente;

import java.util.List;

public interface MenuBDCliente extends LeerBD{

  public List<Cliente> obtenerClientes();
}
