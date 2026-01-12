/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package almundo.com;

import static almundo.com.VistaConsola.*;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Ariel Risoluto.
 */
public class Vuelo extends Servicio{
    
    private String origen;
    private String destino;
    private int  plazasTotales ;
    private int claseTuristaDisponibles;
    private int clasePrimeraDisponibles;

    public Vuelo(String origen, String destino, int plazasTotales, int plazasTuristaDisponibles, int clasePrimeraDisponible, String tipoDeServicio, String nombreEmpresa, String idServicio) {
        super(tipoDeServicio, nombreEmpresa,idServicio);
        this.origen = origen;
        this.destino = destino;
        this.plazasTotales = plazasTotales;
        this.clasePrimeraDisponibles = clasePrimeraDisponible;
        this.claseTuristaDisponibles = plazasTuristaDisponibles;
    }
   
    public Vuelo(String tipoDeServicio,String idServio){
        
        super(tipoDeServicio,idServio);
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public int getPlazasTotales() {
        return plazasTotales;
    }

    public int getClaseTuristaDisponibles() {
        return claseTuristaDisponibles;
    }

    public int getClasePrimeraDisponibles() {
        return clasePrimeraDisponibles;
    }

    @Override
    public void mostrarServicio() {
        mostrarTexto(toString());
    }
    
    public void modificarPlazasTuristas(int cantidad){
        claseTuristaDisponibles -= cantidad;
    }
    
    public void modificarPlazasPrimera(int cantidad){
        clasePrimeraDisponibles -= cantidad;
    }

}
