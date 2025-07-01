package Usuarios;

import Datos.BaseDeDatos;
import Menu.MenuAdministrador;
import Menu.StrategyMenu;
import Servicios.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
/**
 * @author Diego A. Cesarin
 */
public class Administrador extends Usuario implements MenuAdministrador, StrategyMenu {

    private String idUsuario;
    private String clave;
    private BaseDeDatos baseDeDatos;
    private Scanner scanner;
    private int opcion;


    public Administrador(String idUsuario, String clave){
        this.idUsuario = idUsuario;
        this.clave = clave;
        scanner = new Scanner(System.in);
        opcion = 0;

    }

    @Override
    public void menuUsuario() {
        System.out.println("***********************************************************************************************");
        System.out.println("*  MENU DE USUARIO DE ADMINISTRADOR                                                           *");
        System.out.println("***********************************************************************************************");
        System.out.println("*  INGRESE UNA OPCION                                                                         *");
        System.out.println("* 1- Dar de Alta un Servicio              2- Dar de Baja un Servicio                          *");
        System.out.println("* 3- Listar Servicios                     4- Listar Clientes                                  *");
        System.out.println("* 5- Listar Vendedores                    6- Listar Administradores                           *");
        System.out.println("* 7- Dar de Alta un Usuario               8- Dar de Baja un Usuario                           *");
        System.out.println("* 9- Listar Sucursales                    10- Crear Sucursal                                  *");
        System.out.println("* 11- Listar Servicios                    12- Consultar Reservas                              *");
        System.out.println("* 13- Generar una Reserva                 14-Eliminar una Reserva                             *");
        System.out.println("* 15- Salir                                                                                   *");
        System.out.print("opcion--> ");
        scanner.nextInt();

        while( opcion <1 || opcion>15){
            System.out.print("opcion--> ");
            scanner.nextInt();
        }
        gestionarOpcion(opcion);
       // while (opcion != 14 && opcion)

    }

    private void gestionarOpcion( int opcion){

        switch (opcion){
            case 1 :
                    if(obtenerSucursales().isEmpty()) {
                      System.out.println("NO EXISTEN SUCURSALES, PRIMERO DEBE CREARSE UNA SUCURSAL ");
                     }else {
                        do {
                            System.out.println("SELECCIONE EL SERVICIO:  1- TRANSPORTE AEREO     2- HOTELERIA    3- OTRA-OPCION");
                            opcion = scanner.nextInt();
                           } while (opcion < 1 || opcion > 3);
                             if (opcion == 1) {
                             darDeAltaServicio( gestionarDatosVuelo( seleccionarSucursal() ) );
                            }else if (opcion == 2){
                             darDeAltaServicio( gestionarDatosHotel( seleccionarSucursal() ) );
                             }else if (opcion == 3){
                                //agregar servicio
                             }
                           }
                    break;
            case 2 :   System.out.println("INGRESE CÓDIGO DE SERVICIO(Número de Vuelo o Código de Hotel ");
                        darDeBajaServicio( seleccionarUnServicio() );
                break;
            case 3 :
                  mostrarServicios();
            case 4 :
                  mostrarServicios();
                break;
            case 10 :
                     agregarUnaSucursal();
                break;
        }
    }

    private Sucursal seleccionarSucursal(){
        List<Sucursal> s = obtenerSucursales();
        if(!s.isEmpty()) {
            System.out.println("SUCURSALES : ");
            for (Sucursal suc : s) {
                System.out.println("Orden : " + s.indexOf(suc) + " Código de Sucursal :  " + suc.obtenerCodigoDeSucursal());
            }
            do {System.out.print("SELECCIONE LA SUCURSAL(Nro de Orden) : ");
                opcion = scanner.nextInt();
            } while (opcion < 0 || opcion > s.size() - 1);
        }
        return s.get( opcion);
    }

    public void agregarUnaSucursal(){
        obtenerSucursales().add( gestionarDatosSucursal() );
    }

    public Sucursal gestionarDatosSucursal(){
       int telefono;
       String codSuc;
       String direccion;
        System.out.println("Ingrese el Código de sucursal : ");
        codSuc = scanner.next();
        System.out.println("ingrese la Dirección : ");
        direccion = scanner.next();
        System.out.println("Ingrese el teléfono : ");
        telefono = scanner.nextInt();
        return new Sucursal(codSuc,direccion,telefono);
    }
    @Override
    public List<Sucursal> obtenerSucursales() {
        return this.baseDeDatos.obtenerSucursales();
    }
    //-----------------------------------------------------------------------------------------------------------
    public List<Administrador> obtenerAdministradores() {
        return baseDeDatos.obtenerAdministradores();
    }

    @Override
    public void agregarUnAdministrador(Administrador admin) {
        this.baseDeDatos.agregarUnAdministrador(admin);
    }
    //-----------------------------------------------------------------------------------------------------------
    public Vuelo gestionarDatosVuelo( Sucursal sucursal){

        int numVuelo;
        int numDePlazas;
        Date fechaDeVuelo=null;
        String origen;
        String destino;
        System.out.println("************************************************************************************");
        System.out.println("*   INGRESO DE DATOS DEL VUELO                                                    * ");
        System.out.println("* Número del Vuelo : ");
        numVuelo = scanner.nextInt();
        System.out.println("* Plazas del Avión : ");
        numDePlazas = scanner.nextInt();
        System.out.println("* Origen : ");
        origen = scanner.next();
        System.out.println("* Destino : ");
        destino = scanner.next();
        System.out.println("* Fecha de Vuelo en formato dd/MM/yyyy: ");

        String fechaEnTexto = scanner.nextLine();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            fechaDeVuelo = formato.parse(fechaEnTexto);
        } catch (ParseException e) {
            System.out.println("Formato de fecha incorrecto. Por favor, use dd/MM/yyyy.");
        }

        return new Vuelo( sucursal,numVuelo,origen,destino,numDePlazas,fechaDeVuelo);
    }

    public Hotel gestionarDatosHotel( Sucursal sucursal){

        int codigoHotel;
        int telefono;
        int numDePlazas;
        String nombre;
        String ciudad;
        String direccion;
        String email;

        System.out.println("************************************************************************************");
        System.out.println("*   INGRESO DE DATOS DEL HOTEL                                                    * ");
        System.out.println("* Nombre del Hotel : ");
        nombre = scanner.next();
        System.out.println("* Código del Hotel : ");
        codigoHotel = scanner.nextInt();
        System.out.println("* Teléfono : ");
        telefono = scanner.nextInt();
        System.out.println("* Ciudad : ");
        ciudad = scanner.next();
        System.out.println("* Dirección : ");
        direccion = scanner.next();
        System.out.println("* Email : ");
        email = scanner.next();
        System.out.println("* Número de Plazas : ");
        numDePlazas = scanner.nextInt();

        return new Hotel( sucursal,codigoHotel,nombre,ciudad,direccion,telefono,email,numDePlazas);
    }

    @Override
    public void darDeBajaServicio(Servicios servicio) {
        obtenerServicios().remove(servicio);
    }
    @Override

    public void darDeAltaServicio(Servicios servicio) {
        System.out.println(" ");
    }
    public Servicios seleccionarUnServicio(){
        List<Servicios> stmp = obtenerServicios();
        Servicios servtmp = null;
        int codigo;
        for(Servicios s : stmp){
            System.out.println("SERVICIO : " + s.codigoDeServicio());
        }
        System.out.println("INGRESE EL CÓDIGO DE SERVICIO");
        try {
            codigo = scanner.nextInt();
            for(Servicios s : stmp){
              if(s.codigoDeServicio()== codigo){
                  servtmp = s;
              }
            }
            }catch (Exception e){
            System.out.println("SERVICIO NO ENCONTRADO O CÓDIGO INVÁLIDO");
            servtmp =  seleccionarUnServicio();
            return servtmp;
            }
       return servtmp;
    }
    @Override
    public List<Servicios> obtenerServicios() {
        return this.baseDeDatos.obtenerServicios( );
    }
    public void mostrarServicios(){
        List<Servicios> stmp = obtenerServicios();

        for(Servicios s : stmp){
            System.out.println(" CÓDIGO DE SERVICIO : " + s.codigoDeServicio() +"SERVICIO : "+ s.tipoDeServicio);
        }
    }

    //--------------------------------------------------------------------------
    @Override
    public void agregarUnVendedor(Vendedor vendedor) {
        this.baseDeDatos.agregarUnVendedor(vendedor);
    }
    @Override
    public List<Vendedor> obtenerVendedores() {
        return this.baseDeDatos.obtenerVendedores();
    }
    //--------------------------------------------------------------------------
    @Override
    public void consultarLaReserva(String nombre, String apellido) {
    }

    @Override
    public void generarUnaReserva(Usuario usuario, String codigo) {
    }

    @Override
    public void eliminarUnaReserva(Usuario usuario, String codigo) {
    }
    @Override
    public void consultarReservasDisponibles() {
    }

    @Override
    public void darDeAltaUsuario(Usuario usuario) {
    }

    @Override
    public void dardeBajaUsuario(Usuario usuario) {
    }
    //----------------------------------------------------------------------------
    @Override
    public void agregarUnCliente(Cliente cliente) {
    }
    @Override
    public String consultarCodCliente() {
        return "";
    }
    public void mostrarClientes(){
        List<Cliente> ctmp = obtenerClientes();
        for(Cliente c : ctmp){
           c.datosDelCliente();
        }
    }
    @Override
    public List<Cliente> obtenerClientes() {
        return this.baseDeDatos.obtenerClientes();
    }
    @Override
    public String obtenerUsuario() {
        return this.idUsuario;
    }

    @Override
    public String obtenerClave() {
        return this.clave;
    }
    @Override
    public void leerBD(BaseDeDatos baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }
}
