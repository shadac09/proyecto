/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package almundo.com;

import static almundo.com.VistaConsola.*;

/**
 *
 * @author Ariel Risoluto.
 */
public class Hotel extends Servicio{

    private String codHotel;
    private String direccion;
    private int telefono;
    private String email;
    private int plazasDisponibles;

    public Hotel(String codHotel, String direccion, int telefono, String email, int plazasDisponibles, String tipoDeServicio, String nombreEmpresa,String idServicio) {
        super(tipoDeServicio, nombreEmpresa,idServicio);
        this.codHotel = codHotel;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.plazasDisponibles = plazasDisponibles;
    }
    
     public Hotel(String tipoDeServicio,String idServio){

            super(tipoDeServicio,idServio);
    }

    public String getCodHotel() {
        return codHotel;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public int getPlazasDisponibles() {
        return plazasDisponibles;
    }
           
    @Override
    public void mostrarServicio() {
        mostrarTexto(toString());
    }
    
    public void modificarPlazas(int cantidad){
        plazasDisponibles -= cantidad;
    }
    
}
