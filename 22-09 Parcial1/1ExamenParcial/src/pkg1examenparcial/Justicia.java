/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg1examenparcial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Dell
 */
public class Justicia extends UnicastRemoteObject implements IJusticia {

    public Justicia() throws RemoteException {
        super();
    }

    @Override
    public Respuesta ConsultarCuentas(String ci, String nombres, String apellidos) throws RemoteException {
        int port = 5002;
        try {
            Socket client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            String dato = "buscar:" + ci + "-" + nombres + "-" + apellidos;
            toServer.println(dato);
            String result = fromServer.readLine();
            if (result.split(":")[1].equals("no-encontrado")) {
                return new Respuesta(true, "No se encontro a la persona", null);
            } else {
                try {
                    IAsfi asfi;

                    asfi = (IAsfi) Naming.lookup("rmi://localhost/Asfi"); // instanciar un objeto 

                    return new Respuesta(false, "se encontro a la persona", asfi.ConsultarCuentas(ci));

                } catch (NotBoundException ex) {
                    System.getLogger(Asfi.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                } catch (MalformedURLException ex) {
                    System.getLogger(Asfi.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                } catch (RemoteException ex) {
                    System.getLogger(Asfi.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }

            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return new Respuesta(true, "No se encontro a la persona", null);

    }

}
