/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg1examenparcial;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Asfi extends UnicastRemoteObject implements IAsfi {

    public Asfi() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<Cuenta> ConsultarCuentas(String ci) throws RemoteException {
        int puertoMercantil = 6789;
        int puertoBCP = 4567;
        ArrayList<Cuenta> listaCuentas = new ArrayList();
        try {
            String dato = "buscar:" + ci;
            String ip = "localhost";
            DatagramSocket socketUDP = new DatagramSocket();
            byte[] mensaje = dato.getBytes();
            InetAddress hostServidor = InetAddress.getByName(ip);
            // Construimos un datagrama para enviar el mensaje al servidor
            DatagramPacket peticion
                    = new DatagramPacket(mensaje, dato.length(), hostServidor,
                            puertoMercantil);

            // Enviamos el datagrama
            socketUDP.send(peticion);

            // Construimos el DatagramPacket que contendrá la respuesta
            byte[] bufer = new byte[1000];
            DatagramPacket respuesta
                    = new DatagramPacket(bufer, bufer.length);
            socketUDP.receive(respuesta);

            String[] cuentas = new String(respuesta.getData()).trim().split(":");
            for (String cuenta : cuentas) {
                String[] datosCuenta = cuenta.split("-");
                listaCuentas.add(new Cuenta(Banco.Mercantil, ci, datosCuenta[0], Double.parseDouble(datosCuenta[1])));

            }

            // Llama al BCP
            DatagramPacket peticion2
                    = new DatagramPacket(mensaje, dato.length(), hostServidor,
                            puertoBCP);
            socketUDP.send(peticion);

            // Construimos el DatagramPacket que contendrá la respuesta
            byte[] bufer2 = new byte[1000];
            DatagramPacket respuesta2
                    = new DatagramPacket(bufer2, bufer2.length);
            socketUDP.receive(respuesta2);

            String[] cuentas2 = new String(respuesta2.getData()).trim().split(":");
            for (String cuenta : cuentas2) {
                String[] datosCuenta = cuenta.split("-");
                listaCuentas.add(new Cuenta(Banco.Banco_BCP, ci, datosCuenta[0], Double.parseDouble(datosCuenta[1])));

            }

            // Cerramos el socket
            socketUDP.close();

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }

        return listaCuentas;
    }

}
