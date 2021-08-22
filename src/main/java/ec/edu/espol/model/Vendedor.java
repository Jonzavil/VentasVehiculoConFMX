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
public class Vendedor extends Personas {
    
    public Vendedor(int id, String nombre, String apellidos, String organizacion, String correoElectronico, String clave) {
        super(id,nombre,apellidos,organizacion,correoElectronico,clave);
    }
  
    public static ArrayList<Vendedor> readFile(String nomFile){
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomFile))){
            while(sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Vendedor v = new Vendedor(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3],tokens[4],tokens[5]);
                vendedores.add(v);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return vendedores;
    }
    
    public static String searchByCorreo(ArrayList<Vendedor> vendedores,String correo){
        String vn = null;
        for(Vendedor v : vendedores){
            if(v.correoElectronico.equals(correo))
              vn= v.correoElectronico;
        }
        return vn;
    }    
     public static Vendedor registroVendedor(Scanner sc, String nomfile){
         ArrayList<Vendedor> vendedores = Vendedor.readFile(nomfile);
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
         if (correo.equals(Vendedor.searchByCorreo(vendedores, correo))){
             System.out.println("Registro Fallido correo ya existente");
             return null;
         }
         else{
             Vendedor v1 = new Vendedor(id, nombres,apellidos,organizacion,correo,clave);   
             v1.saveFile(nomfile);
             System.out.println("Registro Completado");
             return v1;
         }
     }
     
    public static boolean compararCorreoYContraseña(String nomfile,String correo,String contraseña){
        ArrayList<Vendedor> vendedores = Vendedor.readFile(nomfile);
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
            for(Vendedor v: vendedores){
                if(v.correoElectronico.equals(correo)){
                    c=v.clave;
                }
            } 
        return contraseña.equals(c);
    }
}