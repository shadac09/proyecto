/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package almundo.com;

import java.util.ArrayList;
import static almundo.com.VistaConsola.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ariel Risoluto.
 */
public class BaseDeDatos {

    private ArrayList<Usuario> usuario;
    private ArrayList<Sucursal> sucursal;
    private ArrayList<Servicio> servicio;

    public BaseDeDatos() {
        usuario = new ArrayList<Usuario>();
        sucursal = new ArrayList<Sucursal>();
        servicio = new ArrayList<Servicio>();
    }

    public ArrayList<Servicio> getServicio() {
        return servicio;
    }

    public ArrayList<Usuario> getPersona() {
        return this.usuario;
    }

    public ArrayList<Sucursal> getSucursal() {
        return sucursal;
    }

    public Usuario verificarCrdenciales(String credenciales) {

        for (Usuario p : usuario) {
            if (p.buscarCredenciales(credenciales)) {
                mostrarTexto("\n---Usuario Encontrado---\n");
                return p;
            }
        }
        return null;
    }

    public Usuario buscarUsuario(String id) {
        for (Usuario p : usuario) {
            if (p.getId_user().equals(id)) {
                return p;
            }
        }
        return null;
    }
    
    public Usuario buscarPorTipoDeUsuario(String id,String tipoDeUsuario) {
        Class<?> clase;
  
        for (Usuario p : usuario) {
            clase = p.getClass();
            if (p.getId_user().equals(id) && (clase.getName().equals(tipoDeUsuario))){
                return p;
            }
        }
        return null;
    }
    
    public Servicio buscarServicio(String id) {
        for (Servicio s : servicio) {
            if (s.getIdServicio().equals(id)) {
                return s;
            }
        }
        return null;
    }
    
    public Sucursal buscarSucursal(String id) {
        for (Sucursal s : sucursal) {
            if (s.getCodSucursal().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public void mostrarServicios() {
        for (Servicio s : servicio) {
            mostrarTexto(s.getTipoDeServicio());
        }
    }

    public void mostrarDatosUsuario(Usuario per) {
        mostrarTexto(per.toString());
    }
    
    public void mostrarDatosServicios() {
        for(Servicio servi : servicio)
            mostrarTexto("Tipo de Servicio: "+ servi.getTipoDeServicio() +  " || ID del Servicio: " + servi.getIdServicio());
    }
    
    public void mostrarDatosSucursales() {
        for(Sucursal sucur : sucursal)
            mostrarTexto("Codigo de surcursal: " + sucur.getCodSucursal() + " || Direcion: " + sucur.getDireccion());
    }

}
