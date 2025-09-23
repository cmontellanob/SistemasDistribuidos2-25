/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1examenparcial;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author Carlos
 */
public class ServerBancoBCP {

  public static void main (String args[]) { 
    int port=4567;  
    try {
      
      DatagramSocket socketUDP = new DatagramSocket(port);
      byte[] bufer = new byte[1000];

      while (true) {
        // Construimos el DatagramPacket para recibir peticiones
        DatagramPacket peticion =
          new DatagramPacket(bufer, bufer.length);

        // Leemos una petición del DatagramSocket
        socketUDP.receive(peticion);

        System.out.print("Datagrama recibido del host: " +
                           peticion.getAddress());
        System.out.println(" desde enl puerto remoto: " +
                           peticion.getPort());
        
        
        String cadena =new String (peticion.getData());
        String response=ProcesarSolicitud(cadena).trim();
              byte[] mensaje = response.getBytes();
              

        DatagramPacket respuesta =
          new DatagramPacket(mensaje, response.length(),
                             peticion.getAddress(), peticion.getPort());

        // Enviamos la respuesta, que es un eco
        socketUDP.send(respuesta);
      }

    } catch (SocketException e) {
      System.out.println("Socket: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IO: " + e.getMessage());
    }
  }
  public static String ProcesarSolicitud(String cadena )
    {
        String[] solicitud=cadena.split(":");
        if (solicitud[1].equals("11021654"))
        {
            return "657654-6000" ;
        }
        else
        {
            return "" ;
        }
        
        
        
    }

}

    

