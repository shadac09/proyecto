package Servicios;

import Usuarios.Cliente;

import java.util.List;
/**
 * @author Diego A. Cesarin
 */
public abstract class Servicios {
    public String tipoDeServicio;
    public abstract int plazasDisponibles();
    public abstract String sucursalAsociada( );
public abstract List<Cliente> clientesDelServicio();
public abstract int codigoDeServicio( );

}
