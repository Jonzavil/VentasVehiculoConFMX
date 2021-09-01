/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Objects;
/**
 *
 * @author yober
 */
public class Persona implements Serializable{
    protected int id;
    protected String nombre;
    protected String apellidos;
    protected String organizacion;
    protected String correoElectronico;
    protected String clave; 
    
    public Persona(int id, String nombre, String apellidos, String organizacion, String correoElectronico, String clave){
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.organizacion = organizacion;
        this.correoElectronico = correoElectronico;
        try 
        {
            this.clave = Util.toHexString(Util.getSHA(clave));   
        }
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            System.out.println("Exception thrown for incorrect algorithm: " + e); 
        }
    }
     public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getOrganizacion() {
        return organizacion;
    }
    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        try 
        {
            this.clave = Util.toHexString(Util.getSHA(clave));   
        }
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            System.out.println("Exception thrown for incorrect algorithm: " + e); 
        }
    }
    @Override
    public boolean equals(Object o){
        if(this==null)
            return false;
        if (this== o)
            return true;
        if (this.getClass()!=o.getClass())
            return false;
        Persona other=(Persona)o;
        return this.correoElectronico.equals(other.correoElectronico);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.correoElectronico);
        return hash;
    }
    public static void saveFile(String name, ArrayList<Persona> personas){
        try{
            FileOutputStream fous =new FileOutputStream(name);
            ObjectOutputStream out = new ObjectOutputStream(fous);
            out.writeObject(personas);
            out.flush();
            
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static ArrayList<Persona> readFile(String name){
        try{
            FileInputStream fis =new FileInputStream(name);
            ObjectInputStream oin = new ObjectInputStream(fis);
            ArrayList<Persona> personas =(ArrayList<Persona>)oin.readObject();
            return personas;           
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    } 
    public static boolean compararCorreoYContraseña(String nomfile,String correo,String contraseña){
        ArrayList<Persona> personas = Persona.readFile(nomfile);
        String c=null;
        try 
        {
            contraseña = Util.toHexString(Util.getSHA(contraseña));
            contraseña = Util.toHexString(Util.getSHA(contraseña));
        }
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            System.out.println("Exception thrown for incorrect algorithm: " + e); 
        }
            for(Persona p: personas){
                if(p.correoElectronico.equals(correo)){
                    c=p.clave;
                }
            } 
        return contraseña.equals(c);
    }
    //busca a un vendedor por su identificador unico
    public static Persona searchByID(ArrayList<Persona> personas, int id)
    {
        for(Persona p : personas)
        {
            if(p.id == id)
                return p;
        }
        return null;
    }
    //valida cuando se registra un vendedor que el correo sea unico dentro de los que ya estan almacenadosen la base de datos
    public static Persona searchByCorreo(ArrayList<Persona> personas, String correo)
    {
        for(Persona p: personas)
        {
            if(p.correoElectronico.equals(correo))
                return p;
        }
        return null;
    }
    
}

   
