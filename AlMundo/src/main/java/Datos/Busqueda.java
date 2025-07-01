package Datos;
/**
 * @author Diego A. Cesarin
 */
import Menu.StrategyMenu;
import Usuarios.Usuario;

public interface Busqueda {

    public Usuario buscarUsuario(String usuario);
    public StrategyMenu menuDeBusqueda();
}
