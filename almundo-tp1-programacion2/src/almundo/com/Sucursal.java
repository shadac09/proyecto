/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package almundo.com;

import java.util.ArrayList;

/**
 *
 * @author Ariel Risoluto.
 */
public class Sucursal {
    
    private String codSucursal;
    private String direccion;
    private int telefono;

    public Sucursal(String codSucursal, String direccion, int telefono) {
        this.codSucursal = codSucursal;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getCodSucursal() {
        return codSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getTelefono() {
        return telefono;
    }
    
}
