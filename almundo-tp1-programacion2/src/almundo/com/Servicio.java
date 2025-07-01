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
public abstract class Servicio {
    private String tipoDeServicio;
    private String nombreEmpresa;
    private String idServicio;

    public Servicio(String tipoDeServicio, String nombreEmpresa, String idServicio) {
        this.tipoDeServicio = tipoDeServicio;
        this.nombreEmpresa = nombreEmpresa;
        this.idServicio = idServicio;
    }
    public Servicio(String tipoDeServicio,String idServio){ 
        this.tipoDeServicio = tipoDeServicio;
        this.idServicio = idServio;
    }
    
    public String getTipoDeServicio() {
        return tipoDeServicio;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getIdServicio() {
        return idServicio;
    }
 
    
    public abstract void mostrarServicio();

    @Override
    public String toString() {
        return tipoDeServicio + "{\n" +
            "   - nombre: " + idServicio + "\n" +
            "   - nombre de  la empresa: " + nombreEmpresa + "\n" +
            "}";
    }

}
  