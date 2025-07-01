package Servicios;

import java.util.List;

public class Sucursal  {
    private String codSucursal;
    private String direccion;
    private int telefono;
    private List<Servicios> listaDeServicios;

    public Sucursal(String codSucursal, String direccion, int telefono){
        this.codSucursal = codSucursal;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public void imprimirDatosDeSucursal(){

    }

    public void mostrarListaDeSucursales(){

    }

    public void mostrarListaDeServicios(){

    }

    public String obtenerCodigoDeSucursal( ){
        return codSucursal;
    }
}
