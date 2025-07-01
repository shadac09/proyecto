package Servicios;
/**
 * @author Diego A. Cesarin
 */
public class Asientos {

    private int numero;
    private Categoria clase;
    private String codigoReserva;

    public Asientos(int numero, Categoria clase, String codigoReserva) {
        this.numero = numero;
        this.clase = clase;
        this.codigoReserva = codigoReserva;
    }

    public int consultaNumero() {
        return numero;
    }

    public String consultaCodigoReserva() {
        return codigoReserva;
    }

    public Categoria consultaClase() {
        return clase;
    }
}

