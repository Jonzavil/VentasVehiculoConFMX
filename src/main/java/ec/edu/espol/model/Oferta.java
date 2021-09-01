/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.JavaMailUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author ZavalaAvila & alphaware
 */
public class Oferta {
    private String placa; 
    private String correo;
    private double precioOfertar;

    public Oferta(double precioOfertar, String correo,String placa) {
        this.precioOfertar = precioOfertar;
        this.correo=correo;
        this.placa=placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public double getPrecioOfertar() {
        return precioOfertar;
    }

    public void setPrecioOfertar(double precioOfertar) {
        this.precioOfertar = precioOfertar;
    }
    public static void saveFile(String name, ArrayList<Oferta> ofertas){
        try{
            FileOutputStream fous =new FileOutputStream(name);
            ObjectOutputStream out = new ObjectOutputStream(fous);
            out.writeObject(ofertas);
            out.flush();    
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static ArrayList<Oferta> readFile(String name){
        ArrayList<Oferta> ofertas=new ArrayList<>();
        try{
            FileInputStream fis =new FileInputStream(name);
            ObjectInputStream oin = new ObjectInputStream(fis);
            ofertas =(ArrayList<Oferta>)oin.readObject();
            return ofertas;           
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return ofertas;
    } 

    public static ArrayList<Oferta> ofertarPorVehiculo(String nomfile,String nomfileVehiculo,String nomfileComprador){
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese Correo Electronico: ");
        String correo=sc.next();
        System.out.println("Ingrese Contraseña: ");
        String clave=sc.next();
        ArrayList<Oferta> cP=new ArrayList<>();
        Oferta ofer;
        ArrayList<Vehiculo>vn;
        int cont=0;
        Vehiculo aV[];
        if(Comprador.compararCorreoYContraseña(nomfileComprador, correo, clave)){
            vn=Vehiculo.busquedaPorVehiculo("codificar para que reciba un tipo de vehiculo");
            aV=new Vehiculo[vn.size()];
            for(Vehiculo v:vn){
                aV[cont]=v;
                cont=cont+1;
            }
            cont=0;
            do{
                System.out.println("Seleccione opcion: ");
                if(cont==0){
                    System.out.println("Vehiculo: "+(aV[cont].toString()));
                    System.out.println("1.Siguiente");
                    System.out.println("2.Ofertar");
                    System.out.println("3.Salir");
                    int opcion=sc.nextInt();
                    if(opcion==1){
                        cont=cont+1;
                    }
                    if(opcion==2){
                        System.out.println("Precio a ofertar: ");
                        double pO=sc.nextDouble();
                        ofer=new Oferta(pO,correo,aV[cont].getPlaca());
                        cP.add(ofer);
                        ofer.saveFile(nomfile);
                        System.out.println("Oferta Realizada");
                    }
                    if(opcion==3){
                        cont=-1;
                    }
                }if(0<cont || cont<=aV.length){
                    System.out.println("Vehiculo: "+(aV[cont].toString()));
                    System.out.println("1.Siguiente");
                    System.out.println("2.Ofertar");
                    System.out.println("3.Atras");
                    System.out.println("4.Salir");
                    int opcion=sc.nextInt();
                    if(opcion==1){
                        cont=cont+1;
                    }
                    if(opcion==2){
                        System.out.println("Precio a ofertar: ");
                        double pO=sc.nextDouble();
                        ofer=new Oferta(pO,correo,aV[cont].getPlaca());
                        cP.add(ofer);
                        ofer.saveFile(nomfile);
                        System.out.println("Oferta Realizada");
                    }
                    if(opcion==3){
                        cont=cont-1;
                    }
                    if(opcion==4){
                        cont=-1;
                    }
                }
                                
            }while(cont!=-1);
        }
        return cP;
    }
    public static void aceptarOferta(String nomfile,String nomfileVendedor, String nomfileVehiculo ){
        ArrayList<Oferta> of=Oferta.readFile(nomfile);
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese Correo Electronico: ");
        String correo=sc.nextLine();
        System.out.println("Ingrese Contraseña: ");
        String clave=sc.nextLine();
        ArrayList<Vehiculo>vn;
        int cont=0;
        Oferta aV[];
        if(Vendedor.compararCorreoYContraseña(nomfileVendedor, correo, clave)){
            System.out.println("Ingrese placa: ");
            String placa=sc.nextLine();
            vn=Vehiculo.readFile(nomfileVehiculo);
            aV=new Oferta[of.size()];
            for(Oferta v:of){
                if(Vehiculo.searchByPlaca(vn, placa).equals(v.getPlaca())){
                    aV[cont]=v;
                    cont=cont+1;
                }
            }
            for(Vehiculo v:vn){
                if(Vehiculo.searchByPlaca(vn, placa).equals(placa)){
                    System.out.println(v.getMarca()+" "+v.getModelo()+" Precio: "+v.getPrecio());
                }
            }
            System.out.println("Se han realizado: "+aV.length+" ofertas.");
            cont=0;
            do{
                System.out.println("Seleccione opcion: ");
                if(cont==0){
                    System.out.println("oferta"+(cont+1));
                    System.out.println("1.Siguiente");
                    System.out.println("2.Aceptar Oferta");
                    System.out.println("3.Salir");
                    int opcion=sc.nextInt();
                    if(opcion==1){
                        cont=cont+1;
                    }
                    if(opcion==2){
                        System.out.println("Oferta ");
                        //envio de email
                        JavaMailUtil.sendMail(aV[cont].correo,"Se ha aceptado su oferta");
                            }
                    if(opcion==3){
                        cont=-1;
                    }
                }if(0<cont || cont<=aV.length){
                    System.out.println("oferta"+(cont+1));
                    System.out.println("1.Siguiente");
                    System.out.println("2.Aceptar Oferta");
                    System.out.println("3.Atras");
                    System.out.println("4.Salir");
                    int opcion=sc.nextInt();
                    if(opcion==1){
                        cont=cont+1;
                    }
                    if(opcion==2){
                        System.out.println("Oferta ");
                        //envio de email
                        JavaMailUtil.sendMail(aV[cont].correo,"Se ha aceptado su oferta");
                    }
                    if(opcion==3){
                        cont=cont-1;
                    }
                    if(opcion==4){
                        cont=-1;
                    }
                }
                                
            }while(cont!=-1);
        }
        
    }
}
