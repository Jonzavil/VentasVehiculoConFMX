/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
/**
 *
 * @author David
 */
public class Vehiculo implements Serializable {
    private int img;
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
    private static final long serialVersionUID = 8799656478674716638L;  
    private static final String PATH = "vehiculos.dat";
    public Vehiculo(int id, String placa, String marca, String modelo, String tipoMotor, int año, double recorrido, String color, String tipoCombustible, double precio, String vidrios, String transmision, String traccion){
      this.img = id;
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
      this.img = id;
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
      this.img = id;
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

    
    public int getImg() {
        return img;
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


    public void setImg(int id) {
        this.img = id;
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
        return this.img+"|"+this.placa+"|"+this.marca+"|"+this.modelo+"|"+this.tipoMotor+"|"+this.año+"|"+this.recorrido+"|"+this.color+"|"+this.tipoCombustible+"|"+this.precio+"|"+this.vidrios+"|"+this.transmision+"|"+this.traccion;
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
    public static void saveFile(String nomfile, ArrayList<Vehiculo> vehiculos){
         try{
            FileOutputStream fous =new FileOutputStream(nomfile);
            ObjectOutputStream out = new ObjectOutputStream(fous);
            out.writeObject(vehiculos);
            out.flush();
            
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static ArrayList<Vehiculo> readFile(String nomFile){
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        try{
            FileInputStream fis =new FileInputStream(nomFile);
            ObjectInputStream oin = new ObjectInputStream(fis);
            vehiculos =(ArrayList<Vehiculo>)oin.readObject();
            return vehiculos;           
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
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
     public static Vehiculo registroVehiculo(String tipo,int img,String placa, String marca, String modelo, String tipoMotor, int año, double recorrido, String color, String tipoCombustible, double precio, String vidrios, String transmision, String traccion) throws ErrorException{
         ArrayList<Vehiculo> vehiculos = Vehiculo.readFile(PATH);
         Vehiculo v1 = null;
         if(!searchByPlaca(vehiculos,placa).equals(placa)){
             switch (tipo) {
                 case "moto":
                 {
                     v1 = new Vehiculo(img,placa,marca,modelo,tipoMotor,año,recorrido,color,tipoCombustible,precio);
                     v1.saveFile(PATH,vehiculos);
                     return v1;
                 }
                 case "camioneta":
                 {
                     v1 = new Vehiculo(img,placa,marca,modelo,tipoMotor,año,recorrido,color,tipoCombustible,precio,vidrios,transmision,traccion);
                     v1.saveFile(PATH,vehiculos);
                     return v1;
                 }       
                 case "auto":
                 {
                     v1 = new Vehiculo(img,placa,marca,modelo,tipoMotor,año,recorrido,color,tipoCombustible,precio,vidrios,transmision);
                     v1.saveFile(PATH,vehiculos);
                     return v1;
                 }
                 default:
                 {
                     throw new ErrorException("No se pudo crear onjeto");
                 }
             }
         }else
            return v1;
     } 
     public static ArrayList<Vehiculo> busquedaPorVehiculo(String tipo){
        ArrayList<Vehiculo> v1=Vehiculo.readFile(PATH);
        ArrayList<Vehiculo> ofer=new ArrayList<>();
        tipo=tipo.toLowerCase();
        for(Vehiculo v: v1){
            if(tipo.contains(v.color)&& tipo.contains(v.marca)){
                ofer.add(v);
            }
            else if(tipo.contains(v.color)&& tipo.contains(v.modelo)){
                ofer.add(v);
            }
            else if(tipo.contains(v.marca)&& tipo.contains(v.modelo)){
                ofer.add(v);
            }
            else if(tipo.contains(v.color)&& tipo.contains(v.modelo)&& tipo.contains(v.marca)){
                ofer.add(v);
            }
            else if(tipo.contains(v.color)||tipo.contains(v.marca)||tipo.contains(v.modelo)||tipo.contains(v.placa)||tipo.contains(v.tipoCombustible)||tipo.contains(v.tipoMotor)||tipo.contains(v.traccion)||tipo.contains(v.transmision)||tipo.contains(v.vidrios)||tipo.contains("moto")||tipo.contains("auto")||tipo.contains("camioneta")){
                ofer.add(v);
            }
        }
        return ofer;        
    }
}