/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author ZavalaAvila
 */
public class Comprador extends Persona {
    private static final long serialVersionUID = 8799656478674716635L;
    public Comprador(String id, String nombre, String apellidos, String organizacion, String correoElectronico, String clave) {
        super(id,nombre,apellidos,organizacion,correoElectronico,clave);
    }
   
     public static Comprador nextCompradorFx(Scanner sc, String nomfile){
         ArrayList<Persona> personas = Persona.readFile(nomfile);
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
         Persona temp=Persona.searchByCorreo(personas, correo);
         if (correo.equals(temp.correoElectronico)){
             return null;
         }
         else{
             Comprador c1 = new Comprador(clave, nombres,apellidos,organizacion,correo,clave);
             personas.add(c1);
             Persona.saveFile(nomfile, personas);
             //c1.saveFile(nomfile);
             return c1;
         }
     }
}
    
   