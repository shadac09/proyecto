package Servicios;

import Usuarios.Cliente;

import java.util.List;

public abstract class Servicios {
    public String tipoDeServicio;
    public abstract int plazasDisponibles();
    public abstract String sucursalAsociada( );
public abstract List<Cliente> clientesDelServicio();
public abstract int codigoDeServicio( );

}
