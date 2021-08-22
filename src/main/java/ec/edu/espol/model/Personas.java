/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
/**
 *
 * @author yober
 */
public class Personas {
    protected int id;
    protected String nombre;
    protected String apellidos;
    protected String organizacion;
    protected String correoElectronico;
    protected String clave; 
    
    public Personas(int id, String nombre, String apellidos, String organizacion, String correoElectronico, String clave){
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
        Personas other=(Personas)o;
        return this.correoElectronico.equals(other.correoElectronico);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.correoElectronico);
        return hash;
    }
    public void saveFile(String nomfile){
         try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(this.id+"|"+this.nombre+"|"+this.apellidos+"|"+this.organizacion+"|"+this.correoElectronico+"|"+this.clave);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}

   
