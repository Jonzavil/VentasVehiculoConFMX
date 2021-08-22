/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author ZavalaAvila
 */
public class Comprador extends Personas {
    
    public Comprador(int id, String nombre, String apellidos, String organizacion, String correoElectronico, String clave) {
        super(id,nombre,apellidos,organizacion,correoElectronico,clave);
    }
    public static ArrayList<Comprador> readFile(String nomFile){
        ArrayList<Comprador> compradores = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomFile))){
            while(sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Comprador c = new Comprador(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3],tokens[4],tokens[5]);
                compradores.add(c);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return compradores;
    }
    public static String searchByCorreo(ArrayList<Comprador> compradores,String correo){
        String cn=null;
        for(Comprador c : compradores){
            if(c.correoElectronico.equals(correo));
            cn= c.correoElectronico;
        }
        return cn;
    }
     public static Comprador registroComprador(Scanner sc, String nomfile){
         ArrayList<Comprador> compradores = Comprador.readFile(nomfile);
         int id = Util.nextID(nomfile);
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
         if (correo.equals(Comprador.searchByCorreo(compradores, correo))){
             return null;
         }
         else{
             Comprador c1 = new Comprador(id, nombres,apellidos,organizacion,correo,clave);   
             c1.saveFile(nomfile);
             return c1;
         }
     }
     public static boolean compararCorreoYContraseña(String nomfile,String correo,String contraseña){
        ArrayList<Comprador> compradores = Comprador.readFile(nomfile);
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
            for(Comprador v: compradores){
                if(v.correoElectronico.equals(correo)){
                    c=v.clave;
                }
            } 
        return contraseña.equals(c);
    }
}
    
   