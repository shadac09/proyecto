package Servicios;

import Usuarios.Cliente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hotel extends Servicios{
    private final int codigoHotel;
    private final String nombre;
    private final String direccion;
    private final String ciudad;
    private final int telefono;
    private final String email;
    private int plazasDisponibles;
    private List<Habitacion> habiataciones;
    private List<Cliente> clientes ;
    private final String codigoSucursalAsignada;
    //public String tipoDeServicio;

    public Hotel( Sucursal sucursal , int codigoHotel, String nombre ,String ciudad,
                  String direccion, int telefono, String email, int plazasDisponibles){
        this.codigoSucursalAsignada = sucursal.obtenerCodigoDeSucursal();
        this.codigoHotel = codigoHotel;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.plazasDisponibles = plazasDisponibles;
        clientes = new ArrayList<Cliente>();
        this.tipoDeServicio = "HOTELERIA";

        //Se crean habitaciones base para el Hotel
        asignarHabitaciones(new Habitacion(50,1,Categoria.BASE,new Date() ));
        asignarHabitaciones(new Habitacion(120,3,Categoria.BASE,new Date() ));
        asignarHabitaciones(new Habitacion(100,2,Categoria.CLASICA,new Date() ));
        asignarHabitaciones(new Habitacion(150,2,Categoria.PREMIUN,new Date() ));

    }
    public void consultarDatosDelServicio(){

        System.out.println("********************************************************************");
        System.out.println("**   DATOS DEL HOTEL                                              **");
        System.out.println("*,******************************************************************");
        System.out.println("**   NOMBRE : "+nombre);
        System.out.print("**COD. DE HOTEL : "+codigoHotel);
        System.out.println("** DIRECCION : "+direccion);
        System.out.print("** CIUDAD : "+ ciudad);
        System.out.println("** TELEFONO : "+ telefono);
        System.out.print("**   EMAIL : "+ email);
        System.out.println("**SUCURSAL ASIGNADA : "+codigoSucursalAsignada);
    }
    public int plazasDisponibles(){
        return plazasDisponibles;
    }

    @Override
    public String sucursalAsociada() {
        return codigoSucursalAsignada;
    }

    @Override
    public List<Cliente> clientesDelServicio() {
        return clientes;
    }

    @Override
    public int  codigoDeServicio() {
        return this.codigoHotel;
    }

    public void asignarHabitaciones(Habitacion habitacion){
        this.habiataciones.add(habitacion);
    }

    public String obtenerNombreDelHotel(){
        return this.nombre;
    }

}
