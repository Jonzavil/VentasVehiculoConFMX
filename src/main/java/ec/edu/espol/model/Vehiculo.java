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
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
/**
 *
 * @author David
 */
public class Vehiculo {
    private int id;
    private String placa;
    private String marca;
    private String modelo;
    private String tipoMotor;
    private int año;
    private double recorrido;
    private String color;
    private String tipoCombustible;
    private double precio;
    private String vidrios;
    private String transmision;
    private String traccion;
    
    public Vehiculo(int id, String placa, String marca, String modelo, String tipoMotor, int año, double recorrido, String color, String tipoCombustible, double precio, String vidrios, String transmision, String traccion){
      this.id = id;
      this.placa = placa;
      this.marca = marca;
      this.modelo = modelo;
      this.tipoMotor = tipoMotor;
      this.año = año;
      this.recorrido = recorrido;
      this.tipoCombustible = tipoCombustible;
      this.precio = precio;
      this.vidrios = vidrios;
      this.traccion = traccion;
      this.transmision = transmision;
      this.color = color;
    }
    public Vehiculo(int id, String placa, String marca, String modelo, String tipoMotor, int año, double recorrido, String color, String tipoCombustible, double precio){
        this.id = id;
      this.placa = placa;
      this.marca = marca;
      this.modelo = modelo;
      this.tipoMotor = tipoMotor;
      this.año = año;
      this.recorrido = recorrido;
      this.tipoCombustible = tipoCombustible;
      this.precio = precio;
      this.vidrios = null;
      this.traccion = null;
      this.transmision = null;
      this.color = color;
    }
    
    public Vehiculo(int id, String placa, String marca, String modelo, String tipoMotor, int año, double recorrido, String color, String tipoCombustible, double precio, String vidrios, String transmision){
      this.id = id;
      this.placa = placa;
      this.marca = marca;
      this.modelo = modelo;
      this.tipoMotor = tipoMotor;
      this.año = año;
      this.recorrido = recorrido;
      this.tipoCombustible = tipoCombustible;
      this.precio = precio;
      this.vidrios = vidrios;
      this.traccion = null;
      this.transmision = transmision;
      this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    
    public int getId() {
        return id;
    }


    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public int getAño() {
        return año;
    }

    public double getRecorrido() {
        return recorrido;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public double getPrecio() {
        return precio;
    }

    public String getVidrios() {
        return vidrios;
    }

    public String getTransmision() {
        return transmision;
    }

    public String getTraccion() {
        return traccion;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setRecorrido(double recorrido) {
        this.recorrido = recorrido;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setVidrios(String vidrios) {
        this.vidrios = vidrios;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    } 
    @Override
    public String toString(){
        return this.id+"|"+this.placa+"|"+this.marca+"|"+this.modelo+"|"+this.tipoMotor+"|"+this.año+"|"+this.recorrido+"|"+this.color+"|"+this.tipoCombustible+"|"+this.precio+"|"+this.vidrios+"|"+this.transmision+"|"+this.traccion;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Vehiculo other = (Vehiculo) obj;
        return Objects.equals(this.placa, other.placa);
    }    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.placa);
        return hash;
    }
    public void saveFile(String nomfile){
         try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(this.id+"|"+this.placa+"|"+this.marca+"|"+this.modelo+"|"+this.tipoMotor+"|"+this.año+"|"+this.recorrido+"|"+this.color+"|"+this.tipoCombustible+"|"+this.precio+"|"+this.vidrios+"|"+this.transmision+"|"+this.traccion);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static ArrayList<Vehiculo> readFile(String nomFile){
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomFile))){
            while(sc.hasNextLine())
            {
                String linea = sc.next();
                String[] tokens = linea.split("\\|");
                Vehiculo v;
                v = new Vehiculo(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3],tokens[4],Integer.parseInt(tokens[5]),Double.parseDouble(tokens[6]),tokens[7],tokens[8],Double.parseDouble(tokens[9]),tokens[10],tokens[11],tokens[12]);
                vehiculos.add(v);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return vehiculos;
    }
    public static String searchByPlaca(ArrayList<Vehiculo> vehiculos,String placa){
        String vn=null;
        for(Vehiculo v : vehiculos){
            if(v.placa.equals(placa));
            vn= v.placa;
        }
        return vn;
    }
     public static Vehiculo registroVehiculo(Scanner sc, String nomfile,String nomfilevendedor){
         ArrayList<Vehiculo> vehiculos = Vehiculo.readFile(nomfile);
         Vehiculo v1;
         int id = Util.nextID(nomfile);
         System.out.println("Ingrese el correo electrónico: ");
         String correo = sc.next();
         System.out.println("Ingrese su clave: ");
         String clave = sc.next();
         //System.out.println("Ingrese el tipo, si es auto ingrese auto, si es camioneta ingrese camioneta, si es moto ingrese moto: ");
         //String tipo = sc.next();
         if(Vendedor.compararCorreoYContraseña(nomfilevendedor, correo, clave)){
             System.out.println("Ingrese el tipo, si es auto ingrese auto, si es camioneta ingrese camioneta, si es moto ingrese moto: ");
             String tipo = sc.next().toLowerCase();
             switch (tipo) {
                 case "moto":
                 {
                     System.out.println("Ingrese la placa: ");
                     String placa = sc.next();
                     System.out.println("Ingrese la marca: ");
                     String marca = sc.next();
                     System.out.println("Ingrese el modelo: ");
                     String modelo = sc.next();
                     System.out.println("Ingrese el tipo de motor: ");
                     String tipomotor = sc.next();
                     System.out.println("Ingrese el año: ");
                     int año = sc.nextInt();
                     System.out.println("Ingrese el recorrido: ");
                     double recorrido = sc.nextDouble();
                     System.out.println("Ingrese el color: ");
                     String color = sc.next();
                     System.out.println("Ingrese el tipo de combustible");
                     String combustible = sc.next();
                     System.out.println("Ingrese el precio: ");
                     double precio = sc.nextDouble();
                     if(!placa.equals(Vehiculo.searchByPlaca(vehiculos, placa))){
                         v1 = new Vehiculo(id,placa,marca,modelo,tipomotor,año,recorrido,color,combustible,precio);
                         v1.saveFile(nomfile);
                         return v1;
                     }else
                         return null;
                 }
                 case "camioneta":
                 {
                     System.out.println("Ingrese la placa: ");
                     String placa = sc.next();
                     System.out.println("Ingrese la marca: ");
                     String marca = sc.next();
                     System.out.println("Ingrese el modelo: ");
                     String modelo = sc.next();
                     System.out.println("Ingrese el tipo de motor: ");
                     String tipomotor = sc.next();
                     System.out.println("Ingrese el año: ");
                     int año = sc.nextInt();
                     System.out.println("Ingrese el recorrido: ");
                     double recorrido = sc.nextDouble();
                     System.out.println("Ingrese el color: ");
                     String color = sc.next();
                     System.out.println("Ingrese el tipo de combustible");
                     String combustible = sc.next();
                     System.out.println("Ingrese el tipo de vidrios: ");
                     String vidrios = sc.next();
                     System.out.println("Ingrese el tipo de transmision: ");
                     String transmision = sc.next();
                     System.out.println("Ingrese el tipo de traccion: ");
                     String traccion = sc.next();
                     System.out.println("Ingrese el precio: ");
                     double precio = sc.nextDouble();
                     if(!placa.equals(Vehiculo.searchByPlaca(vehiculos, placa))){
                         v1 = new Vehiculo(id,placa,marca,modelo,tipomotor,año,recorrido,color,combustible,precio,vidrios,transmision,traccion);
                         v1.saveFile(nomfile);
                         return v1;
                     }else
                         return null;
                 }       
                 case "auto":
                 {
                     System.out.println("Ingrese la placa: ");
                     String placa = sc.next();
                     System.out.println("Ingrese la marca: ");
                     String marca = sc.next();
                     System.out.println("Ingrese el modelo: ");
                     String modelo = sc.next();
                     System.out.println("Ingrese el tipo de motor: ");
                     String tipomotor = sc.next();
                     System.out.println("Ingrese el año: ");
                     int año = sc.nextInt();
                     System.out.println("Ingrese el recorrido: ");
                     double recorrido = sc.nextDouble();
                     System.out.println("Ingrese el color: ");
                     String color = sc.next();
                     System.out.println("Ingrese el tipo de combustible");
                     String combustible = sc.next();
                     System.out.println("Ingrese el tipo de vidrios: ");
                     String vidrios = sc.next();
                     System.out.println("Ingrese el tipo de transmision: ");
                     String transmision = sc.next();
                     System.out.println("Ingrese el precio: ");
                     double precio = sc.nextDouble();
                     if(!placa.equals(Vehiculo.searchByPlaca(vehiculos, placa))){
                         v1 = new Vehiculo(id,placa,marca,modelo,tipomotor,año,recorrido,color,combustible,precio,vidrios,transmision);
                         v1.saveFile(nomfile);
                         return v1;
                     }else
                         return null;
                 }
                 default:
                     System.out.println("EL tipo es incorrecto.");
                     break;
             }
         }else
             System.out.println("Correo o Contraseña Incorrecta");
         return null;
     } 
     public static ArrayList<Vehiculo> busquedaPorVehiculo(String nomfileVehi){
        ArrayList<Vehiculo> v1=new ArrayList<>();
                v1=Vehiculo.readFile(nomfileVehi);
        ArrayList<Vehiculo> ofer=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        int cont=0;
        do{
            System.out.println("Digite tipo,recorrido,año y precio(ingresar en el orden indicado, no es necesario ingresar todos los elementos si usa mas de uno separe con comas \"(,)\"): ");
            String opciones=sc.next().toLowerCase();
            if(opciones.contains(",")){
                String o[]=opciones.split(",");
                for(Vehiculo v:v1){
                    if(o.length==2){
                        if(o[0].equals("moto")||o[0].equals("camioneta")||o[0].equals("auto") && o[1].equals(v.getRecorrido())){
                            ofer.add(v);
                            cont=cont+1;
                        }
                    }if(o.length==3){
                        if(o[0].equals("moto")||o[0].equals("camioneta")||o[0].equals("auto") && o[1].equals(v.getRecorrido())&& o[2].equals(v.getAño())){
                            ofer.add(v);
                            cont=cont+1;
                        }
                        
                    }if(o.length==4){
                        if(o[0].equals("moto")||o[0].equals("camioneta")||o[0].equals("auto") && o[1].equals(v.getRecorrido())&& o[2].equals(v.getAño())&&o[3].equals(v.getPrecio())){
                            ofer.add(v);
                            cont=cont+1;
                        }
                    }
                }
            }else if(opciones.equals("moto")||opciones.equals("camioneta")||opciones.equals("auto") ){
                for(Vehiculo v:v1){
                    if(v.getVidrios().equals("null")&&opciones.equals("moto")){
                        ofer.add(v);
                        cont=cont+1;
                    }
                    if(v.getTraccion().equals("null")&&opciones.equals("auto")){
                        ofer.add(v);
                        cont=cont+1;
                    }
                    if(!v.getTraccion().equals("null")&&opciones.equals("camioneta")){
                        ofer.add(v);
                        cont=cont+1;
                    }
                    }
            }else{
                System.out.println("VALOR INVALIDO");
            }
        }while(cont!=v1.size());
        return ofer;        
    }
}