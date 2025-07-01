package Servicios;

import Usuarios.Cliente;
import Usuarios.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vuelo extends Servicios {

    private int numeroDeVuelo;
    private Date fecha;
    private String origen;
    private String destino;
    private  int numeroDePlazasDisponibles;
    private List<Cliente> clientes;
    private List<Asientos> asientos;
    private String codigoDeSucursalAsignada;

    public Vuelo(Sucursal sucursal, int numeroDeVuelo,String origen, String destino , int numeroDePlazasDisponibles,
                 Date fecha ) {
        this.numeroDeVuelo = numeroDeVuelo;
        this.origen = origen;
        this.destino = destino;
        this.numeroDePlazasDisponibles = numeroDePlazasDisponibles;
        this.fecha = fecha;
        this.codigoDeSucursalAsignada = sucursal.obtenerCodigoDeSucursal();
        asientos = new ArrayList<Asientos>();
        this.tipoDeServicio = "TRANSPORTEAEREO";
    }

    public void consultarDatosDelServicio(){

        System.out.println("********************************************************************");
        System.out.println("**   DATOS DEL VUELO                                              **");
        System.out.println("*,******************************************************************");
        System.out.println("**   NUMERO DE VUELO : "+numeroDeVuelo);
        System.out.print("** FECHA : "+fecha.toString());
        System.out.println("** ORIGEN : "+origen);
        System.out.print("** DESTINO : "+ destino);
        System.out.println("**SUCURSAL ASIGNADA : "+ codigoDeSucursalAsignada);
    }
    public int plazasDisponibles(){
        return numeroDePlazasDisponibles;
    }

    @Override
    public String sucursalAsociada() {
        return this.codigoDeSucursalAsignada;
    }

    @Override
    public List<Cliente> clientesDelServicio() {
    return this.clientes;
    }

    @Override
    public int codigoDeServicio() {
        return  this.numeroDeVuelo ;
    }

    public void asignarAsiento( int asiento , Categoria categoria , String codigoR){
        if(verificarDisponibilidad(asiento) &&  numeroDePlazasDisponibles>0){
         asientos.add(new Asientos( asiento, categoria,codigoR   ));
         numeroDePlazasDisponibles--;
        }
    }

    public boolean verificarDisponibilidad(int asiento){
        for(Asientos a : asientos){
            if( a.consultaCodigoReserva() != null ){
                return false;
            }
        }
        return true;
    }
}
