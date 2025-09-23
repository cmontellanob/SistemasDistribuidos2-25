/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg1examenparcial;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Dell
 */
public class Juez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try {
            IJusticia justicia;
            
            justicia = (IJusticia)Naming.lookup("rmi://localhost/Justicia"); // instanciar un objeto 
            
            Respuesta respuesta=justicia.ConsultarCuentas("11021654", "Juan Perez", "Segovia");
            if (respuesta.isError()) {
                System.out.println(respuesta.getMensaje());
            }
            else
            {
                for (Cuenta cuenta:respuesta.getCuentasencontradas())
                {
                    System.out.println(cuenta);
                }
            }
            

            
        } catch (NotBoundException ex) {
            System.getLogger(Justicia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (MalformedURLException ex) {
            System.getLogger(Justicia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (RemoteException ex) {
            System.getLogger(Justicia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }


    }
    
}
