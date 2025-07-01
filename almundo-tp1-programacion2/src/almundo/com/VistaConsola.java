/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package almundo.com;

import java.util.Scanner;

/**
 *
 * @author Ariel Risoluto.
 */
public class VistaConsola{
    
   public static String leerString(String texto) {

        Scanner scan = new Scanner(System.in);
        System.out.println(texto);
        String lectura = scan.nextLine();
        //lectura = lectura.toLowerCase();

        return lectura;
    }

    public static int leerNro(String texto) {

        Scanner scan = new Scanner(System.in);
        System.out.println(texto);
        int nro = scan.nextInt();

        return nro;
    }

    public static boolean siNo(String texto) {
        String i = leerString(texto.toLowerCase());
        while (!i.equals("si") && !i.equals("no")) {
            i = leerString("***Por favor ingreses solo si o no***");
        }
        return i.equals("si");
    }

    public static void mostrarTexto(String texto) {
        System.out.println(texto);
    }
    public static void mostrarTexto(int num) {
        System.out.println(num);
    }
    
    public static boolean validarSiNo(String texto){ 
        String opc = leerString(texto);
        opc = opc.toLowerCase();
        
        while (!opc.equals("si") && !opc.equals("no")) {
            opc = leerString("***Por favor ingreses solo si o no***");
        }
        return opc.equals("si");
  
    }
}
