package Menu;
/**
 * @author Diego A. Cesarin
 */
import Servicios.Servicios;
import Usuarios.Cliente;
import Usuarios.Vendedor;

import java.util.List;

public interface MenuBDVendedor extends MenuBDCliente{

    public List<Vendedor> obtenerVendedores();

    public List<Servicios> obtenerServicios();

    public void agregarUnCliente( Cliente cliente ) ;

}
