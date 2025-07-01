package Menu;

/**
 * @author Diego A. Cesarin
 */

public  interface MenuCliente extends MenuBDCliente{

   public void consultarLaReserva( String nombre , String apellido);

   public String consultarCodCliente();

}
