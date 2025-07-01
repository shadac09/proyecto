package Menu;

/**
 * @author Diego A. Cesarin
 */
import Servicios.*;

import Usuarios.Usuario;

import java.util.List;

public  interface MenuAdministrador extends MenuVendedor, MenuBDAdministrador {

    public void darDeAltaServicio(Servicios servicio);

    public void darDeBajaServicio(Servicios servicio);

    public void darDeAltaUsuario(Usuario usuario);

    public void dardeBajaUsuario(Usuario usuario);

}
