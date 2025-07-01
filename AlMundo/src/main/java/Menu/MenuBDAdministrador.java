package Menu;
/**
 * @author Diego A. Cesarin
 */
import Servicios.Sucursal;
import Usuarios.Administrador;
import Usuarios.Vendedor;

import java.util.List;

public interface MenuBDAdministrador extends MenuVendedor{

    public List<Sucursal> obtenerSucursales( );

    public  List<Administrador> obtenerAdministradores();


    public void agregarUnAdministrador( Administrador admin );

    public void agregarUnVendedor(  Vendedor vendedor );
}
