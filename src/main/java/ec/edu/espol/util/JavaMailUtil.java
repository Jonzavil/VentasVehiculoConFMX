/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;
//import java.net.Authenticator;
//import java.net.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author alpha
 */
public class JavaMailUtil {
    //mirar ejemplo de uso en el codigo de Oferta.java linea 196-197
    public static void sendMail(String recepient,String body){
        System.out.println("Preparando para enviar el mensaje.");
        Properties properties =new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","true");
        properties.put("mail.smtp.port","587");      
        String myAccountEmail ="pooespolg6@gmail.com";
        String password = "001122admin";
        Session session = Session.getInstance(properties,new Authenticator(){
        @Override
        protected PasswordAuthentication getPasswordAuthentication(){
            return new PasswordAuthentication(myAccountEmail,password);
        }
    });
     Message message = prepareMessage(session,myAccountEmail,recepient,body); 
        try {
            Transport.send(message);
        } catch (MessagingException ex) {
            System.out.println("El mensaje no se ha podido enviar");
        }
     System.out.println("Mensaje enviado correctamente");      
    }
    private static Message prepareMessage(Session session, String MyAccountEmail,String recepient, String body){
        //throw new UnsupportedOperationException("Not supported yet");
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(MyAccountEmail));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
            message.setSubject("Aceptacion de Oferta en la APP - Venta de Vehiculos");
            message.setText(body);
            return message;
        }catch(Exception ex){
            System.out.println("No se ha podido preparar el mensaje para enviar");
        }
     return null;   
    }
    
}
