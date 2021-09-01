/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.model.Persona;
import ec.edu.espol.util.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ZavalaAvila
 */
public class Vendedor extends Persona implements Serializable{
    private static final long serialVersionUID = 8799656478674716638L;
    
    public Vendedor(int id, String nombre, String apellidos, String organizacion, String correoElectronico, String clave) {       
        super(id,nombre,apellidos,organizacion,correoElectronico,clave);
    } 
    
    
      
    public static Vendedor registroVendedor(Scanner sc, String nomfile){
         ArrayList<Persona> personas = Persona.readFile(nomfile);
         int id = Util.nextID(personas);
         System.out.println("Ingrese sus nombres: ");
         String nombres = sc.next();
         System.out.println("Ingrese sus apellidos: ");
         String apellidos = sc.next();
         System.out.println("Ingrese la organización  la que pertenece: ");
         String organizacion = sc.next();
         System.out.println("Ingrese el correo electrónico");
         String correo = sc.next();
         System.out.println("Ingrese su clave: ");
         String clave = sc.next();
         if (correo.equals(Persona.searchByCorreo(personas, correo))){
             System.out.println("Registro Fallido correo ya existente");
             return null;
         }
         else{
             Vendedor v1 = new Vendedor(id, nombres,apellidos,organizacion,correo,clave);
             personas.add(v1);
             Persona.saveFile(nomfile, personas);
             //v1.saveFile(nomfile);
             System.out.println("Registro Completado");
             return v1;
         }
     }
     
    
    
    
    
}
