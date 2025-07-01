package Servicios;

import java.util.Date;
/**
 * @author Diego A. Cesarin
 */
public class Habitacion {

    private int precio;
    private final int capacidad;
    private Categoria categoria;

    private Date fechaDisponibilidad;

    public Habitacion(int precio , int capacidad , Categoria categoria, Date fechaDisponibilidad){

        this.precio = precio;
        this.capacidad = capacidad;
        this.categoria = categoria;
        this.fechaDisponibilidad = fechaDisponibilidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Date getFechaDisponibilidad() {
        return fechaDisponibilidad;
    }

    public int getPrecio() {
        return precio;
    }
}
