/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg1examenparcial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author DELL
 */
public class ServidorSegip {

    public static void main(String[] args) {
        int port = 5002;
        ServerSocket server;
        try {
            // TODO code application logic here
            server = new ServerSocket(port);
            System.out.println("Se inicio el servidor con éxito");
            while (true) {
                Socket client;
                PrintStream toClient;
                client = server.accept(); //conexion entre cliente y servidor para comunicacion bidireccional
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                System.out.println("Cliente se conecto");
                String recibido = fromClient.readLine();
                
                System.out.println("El cliente envio el mensaje:" + recibido);
                toClient = new PrintStream(client.getOutputStream());
                toClient.println(ProcesarSolicitud(recibido));
            }
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }
    public static String ProcesarSolicitud(String cadena )
    {
        String[] solicitud=cadena.split(":");
        if (solicitud[1].equals("11021654"))
        {
            return "resultado:encontrado" ;
        }
        else
        {
            return "resultado:no-encontrado" ;
        }
        
        
        
    }

}
