/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package almundo.com;

import java.text.ParseException;

/**
 *
 * @author Ariel Risoluto.
 */
public abstract class Usuario{
    String nombre;
    String apellido;
    String id_user;
    String password;
    int dni;
    String mail;

    public Usuario(String nombre,String apellido, String id_user, String Password, int Dni, String mail) throws ParseException {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_user = id_user;
        this.password = Password;
        this.dni = Dni;
        this.mail = mail;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getId_user() {
        return id_user;
    }

    public String getPassword() {
        return password;
    }

    public int getDni() {
        return dni;
    }

    public String getMail() {
        return mail;
    }
    
    public abstract boolean inciarSesion(BaseDeDatos baseDeDatos,Usuario usuarioActul);
    
    public boolean buscarCredenciales(String credenciales){
        return credenciales.equals(id_user+":"+password);
    }

    @Override
    public String toString() {
        
        return "Usuario{\n" +
            "   - nombre: " + nombre + "\n" +
            "   - apellido: " + apellido + "\n" +
            "   - id_user: " + id_user + "\n" +
            "   - dni: " + dni +
            "   - mail: " + mail + "\n" +
            "}";
    }

}
