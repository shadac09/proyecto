/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package almundo.com;
import static almundo.com.VerificarDato.*;
import static almundo.com.VistaConsola.*;
/**
 *
 * @author Ariel Risoluto.
 */
public class Sistema {
    
    private String user;
    private String pass;
    private boolean validar = true;
    
    public void controlDeIngreso(){
        
        BaseDeDatos bd = new BaseDeDatos();
        
        try{
            
            mostrarTexto("Bienvenido al sistema de Almundo.com");
            
            //Usuarios
            Usuario admin1 = new Administrador("Juan", "Pérez", "Jperez", "1234pass", 12345678, "juan@example.com");
            Usuario vend1 = new Vendedor("Lucía", "Martínez", "Lmartinez", "ventapass", 23456789, "lucia@example.com");
            Usuario clint1 = new Cliente("Andrés", "Ramírez", "Aramirez", "comprapass", 34567890, "andres@example.com");
            
            bd.getPersona().add(admin1);
            bd.getPersona().add(vend1);
            bd.getPersona().add(clint1);
            
            //Servicios simples
            
            Servicio vuelo1 = new Vuelo("vuelo1","V0001");
            Servicio vuelo2 = new Vuelo("vuelo2","V0002");
            
            Servicio hotel1 = new Hotel("hotel1","H0001");
            Servicio hotel2 = new Hotel("hotel2","H0002");
            
            bd.getServicio().add(vuelo1);
            bd.getServicio().add(vuelo2);
            bd.getServicio().add(hotel1);
            bd.getServicio().add(hotel2);
            
            //Sucursales
            Sucursal suc1 = new Sucursal("SUC001", "Av. Siempre Viva 742, Springfield", 123456789);
            Sucursal suc2 = new Sucursal("SUC002", "Calle Falsa 123, Shelbyville", 987654321);
            Sucursal suc3 = new Sucursal("SUC002", "Calle Falsa 123, Shelbyville", 987654321);
            
            bd.getSucursal().add(suc1);
            bd.getSucursal().add(suc2);
            bd.getSucursal().add(suc3);
            
            //Hardcodear reservas
            Cliente clienteConReserva = (Cliente) clint1;
            clienteConReserva.getServicioContrado().add(vuelo2);
            clienteConReserva.getServicioContrado().add(hotel1);
            
            Vuelo vueloModificado = (Vuelo) vuelo2;
            vueloModificado.modificarPlazasPrimera(1);
            
            Hotel hotelModificado = (Hotel) hotel1;
            hotelModificado.modificarPlazas(2);
            
            
            while(validar){
                do {
                    this.user = leerString("Ingrese su Usuario: ");
                    this.pass = leerString("Ingrese su Contraseña: ");

                }while(validarIngreso(user) || validarIngreso(pass));
            
                Usuario p = bd.verificarCrdenciales(user+":"+pass);
            
                if(p == null){
                    mostrarTexto("---LAS CREDENCIALES SON INCORRECTAS---");
                }else{
                    validar = p.inciarSesion(bd,p);
                     if(validarSiNo("¿Desea volver ingresar ? si/no")){
                        validar = true;
                    } 
                }
            
            }
            mostrarTexto("PROGRAMA TERMINADO !!!");
            
        } catch (Exception e) {
        }
    }
    
}
